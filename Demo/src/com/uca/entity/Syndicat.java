package src.com.uca.entity;

public class Syndicat {
    private String nom;
    private String adresse;
    private Personne referent;
    private int numTel;
    private String mail;

    public Syndicat() {
        //ignored
    }

    public Syndicat(String nom, String adresse, String prenomRef, String nomRef, int numTel, String mail) {
        this.nom = nom;
        this.adresse = adresse;
        this.referent = new Personne(nomRef, prenomRef, numTel);
        this.numTel = numTel;
        this.mail = mail;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Personne getReferent() {
        return this.referent;
    }

    public void setReferent(Personne referent) {
        this.referent = referent;
    }

    public int getNumTel() {
        return this.numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        return "Syndicat{" +
                "nom='" + this.nom + '\'' +
                ", adresse='" + this.adresse + '\'' +
                ", referent=" + this.referent +
                ", numTel=" + this.numTel +
                ", mail='" + this.mail + '\'' +
                '}';
    }
}
