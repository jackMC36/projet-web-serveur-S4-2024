package src.com.uca.entity;

import java.util.ArrayList;
import src.com.uca.entity.Syndicat;
import src.com.uca.entity.Appartement;


public class Immeuble{
    private String nom;
    private String adresse;
    private Syndicat syndicat;
    private ArrayList<Appartement> listeAppt;

    public Immeuble(){
        // ignored
    }

    public Immeuble(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
    }

    public Immeuble(String nom, String adresse, Syndicat syndicat){
        this.nom = nom;
        this.adresse = adresse;
        this.syndicat = syndicat;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public void setSyndicat(Syndicat syndicat){
        this.syndicat = syndicat;
    }

    public String getNom(){
        return this.nom;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public String getSyndicatNom(){
        return this.syndicat.getNom();
    }


    public ArrayList<Appartement> getListeAppt(){
        return this.listeAppt;
    }

    public void setListeAppt(ArrayList<Appartement> listeAppt){
        this.listeAppt = listeAppt;
    }

    @Override
    public String toString(){
        return "Immeuble{" +
                "nom='" + this.nom + '\'' +
                ", adresse='" + this.adresse + '\'' +
                ", syndicat=" + this.syndicat +
                ", listeAppt=" + this.listeAppt +
                '}';
    }


}