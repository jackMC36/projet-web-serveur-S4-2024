package src.com.uca.entity;

public class Personne {
    private String nom;
    private String prenom;
    private int numTel;

    public Personne() {
        //ignored
    }

    public Personne(String nom, String prenom, int numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
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

    public String toStringNumTel(int numTel){
        String numero = "0" + numTel;
        String numeroAvecEspace = "";
        for (int i = 0 ; i < numero.length() ; i += 2) {
            numeroAvecEspace += numero.charAt(i);
            numeroAvecEspace += numero.charAt(i+1);
            numeroAvecEspace += " ";
        }
        return numeroAvecEspace;
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
