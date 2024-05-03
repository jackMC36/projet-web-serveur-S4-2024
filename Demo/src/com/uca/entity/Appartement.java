package src.com.uca.entity;
import java.util.ArrayList;

public class Appartement {
    private int etage;
    private int numero;
    private float superficie;
    String adresse;
    private ArrayList<Personne> listeOccupant;
    private int estLoue;

    public Appartement(){
        //ignored
    }

    public int getEtage() {
        return this.etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public ArrayList<Personne> getListeOccupant() { //PAS UTILISE
        return this.listeOccupant;
    }

    public void setListeOccupant(ArrayList<Personne> listeOccupant) { //PAS UTILISE
        this.listeOccupant = listeOccupant;
    }

    public int getEstLoue() {
        return this.estLoue;
    }

    public void setEstLoue(int estLoue) {
        this.estLoue = estLoue;
    }

    @Override
    public String toString() {
        return "Appartement{" +
                "etage=" + this.etage +
                ", numero=" + this.numero +
                ", superficie=" + this.superficie +
                ", adresse='" + this.adresse + '\'' +
                ", listeOccupant=" + this.listeOccupant +
                ", estLoue=" + this.estLoue +
                '}';
    }
}

