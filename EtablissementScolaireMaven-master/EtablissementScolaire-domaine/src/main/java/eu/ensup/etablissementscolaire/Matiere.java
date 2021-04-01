package eu.ensup.etablissementscolaire;

public class Matiere {
    int id;
    String libelle;

    public Matiere(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public Matiere(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
