package eu.ensup.etablissementscolaire;

public class NoteEleve  {
    private int idNote;
    private Cours cours ;
    private Etudiant etudiant;
    private float coeff;
    private float note ;

    public NoteEleve(float coeff, float note) {
        this.coeff = coeff;
        this.note = note;
    }

    public NoteEleve(int idNote, float coeff, float note) {
        this.idNote = idNote;
        this.coeff = coeff;
        this.note = note;
    }

    public NoteEleve() {
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public float getCoeff() {
        return coeff;
    }

    public void setCoeff(float coeff) {
        this.coeff = coeff;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "NoteEleve{" +
                "idNote=" + idNote +
                ", cours=" + cours +
                ", etudiant=" + etudiant +
                ", coeff=" + coeff +
                ", note=" + note +
                '}';
    }
}