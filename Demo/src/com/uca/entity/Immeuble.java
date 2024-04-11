package src.com.uca.entity;

import java.util.ArrayList;
import src.com.uca.entity.Syndicat;
import src.com.uca.entity.Appartement;


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

    public Immeuble(){
        this.nom = "";
        this.adresse = "";
        this.numero = -1;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

}