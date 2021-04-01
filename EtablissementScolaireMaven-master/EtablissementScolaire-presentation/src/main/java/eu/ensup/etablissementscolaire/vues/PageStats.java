package eu.ensup.etablissementscolaire.vues;



import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.NoteEleveService;
import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class PageStats extends Fenetre {

    private JButton retourButton;
    private JPanel JpHisto;
    private JPanel Principal;
    private JPanel JpPie;
    private NoteEleveService eleveService = new NoteEleveService();
    private EtudiantService etudiantService = new EtudiantService();

    public PageStats(Responsable user) {
        super("Statistiques",user);

        initUI();
        this.setContentPane(Principal);

        retourButton.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageStats.super.hide();
        });
    }

    private void initUI() {
        int[] repartition = categoriesCalcul();
        CategoryDataset barDataSet = createChartDataSet(repartition);
        DefaultPieDataset pieDataset = createPieDataSet(repartition);
        JFreeChart pieChart = ChartFactory.createPieChart("Niveau des élèves",pieDataset,true,false,false);

        final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");
        final PiePlot plot1 = (PiePlot) pieChart.getPlot();
        plot1.setLabelGenerator(labelGenerator);

        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pieChartPanel.setBackground(Color.white);


        JFreeChart barChart = ChartFactory.createBarChart("Niveau des éléves", "", "Nombres", barDataSet, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        barChartPanel.setBackground(Color.white);

        JpHisto.add(barChartPanel);
        JpPie.add(pieChartPanel);
        JpHisto.setVisible(true);
        JpPie.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createChartDataSet(int[] repartition) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(repartition[0], "Nombres", "Mauvais");
        dataset.setValue(repartition[1], "Nombres", "Moyens");
        dataset.setValue(repartition[2], "Nombres", "Bons");
        dataset.setValue(repartition[3], "Nombres", "Excellents");


        return dataset;
    }

    private DefaultPieDataset createPieDataSet(int[] repartition) {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Mauvais",repartition[0]);
        pieDataset.setValue("Moyen",repartition[1]);
        pieDataset.setValue("Bon",repartition[2]);
        pieDataset.setValue("Excellent",repartition[3]);

        return pieDataset;

    }

    private int[] categoriesCalcul(){
        int[] repartition = {0, 0, 0, 0};

        try {
            Map<Integer, List<Float>> etudiantsNotes  = eleveService.FindNoteEtudiant();

            for (Map.Entry<Integer, List<Float>> entry : etudiantsNotes.entrySet()) {
                repartition = etudiantService.niveauEleve(repartition, entry.getValue());
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
        return repartition;
    }



}
