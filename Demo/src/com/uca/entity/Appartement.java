package src.com.uca.entity;
import java.util.ArrayList;

public class Appartement {
    private int etage;
    private int numero;
    private float superficie;
    private String adresse;
    private int estLoue; //0 si non, 1 si oui

    public Appartement(int etage, int numero, float superficie, String adresse, int estLoue){
        this.etage = etage;
        this.numero = numero;
        this.superficie = superficie;
        this.adresse = adresse;
        this.estLoue = estLoue;
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
                ", adresse='" + this.adresse +
                ", estLoue=" + this.estLoue +
                '}';
    }
}

