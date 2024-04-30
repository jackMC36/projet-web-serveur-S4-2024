package src.com.uca.entity;

public class Personne {
    private String nom;
    private String prenom;
    private int numTel;

    public Personne() {
        //ignored
    }

    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumTel() {
        return this.numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + this.nom + '\'' +
                ", prenom='" + this.prenom + '\'' +
                ", numTel=" + this.numTel +
                '}';
    }
}
