import java.util.ArrayList;

public class Immeuble{
    private String nom;
    private String adresse;
    private int numero;
    private Syndicat syndicat;
    private ArrayList<Appartement> listeAppt;


  
    public Immeuble(String nom, String adresse, int numero, Syndicat syndicat){
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.syndicat = syndicat;
        this.listeAppt = new ArrayList<Appartement>();
    }

}