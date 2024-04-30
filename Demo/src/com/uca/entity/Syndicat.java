package src.com.uca.entity;

public class Syndicat {
    private String nom;
    private String adresse;
    private Personne referent;
    private int numTel; //voir si on le considère comme un entier de dix chiffre ou une chaîne de carac
    private String mail;

    public Syndicat() {
        //ignored
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
