package src.com.uca.entity;

public class Syndicat {
    private String nom;
    private String adresse;
    private Personne referent;
    private int numTel; //voir si on le considère comme un entier de dix chiffre ou une chaîne de carac
    private String mail;

    public Syndicat(String nom, String adresse, Personne referent, int numTel, String mail) {
        this.nom = nom;
        this.adresse = adresse;
        this.referent = referent;
        this.numTel = numTel;
        this.mail = mail;
    }
}
