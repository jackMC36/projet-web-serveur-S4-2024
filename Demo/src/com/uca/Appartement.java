package com.uca;
import java.util.ArrayList;

public class Appartement {
    private int etage;
    private int numero;
    private float superficie;
    private ArrayList<Personne> listeOccupant;
    private Boolean estLoue;

    public Appartement(int etage, int numero, float superficie) {
        this.etage = etage;
        this.numero = numero;
        this.superficie = superficie;
        this.listeOccupant = new ArrayList<Personne>();
        this.estLoue = false;
    }
}
