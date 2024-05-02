package src.com.uca.entity;

public class Occupation {

    private int numero_appartement;
    private int statut;
    private int numTel;


    public Occupation(){
        //ignored
    }

    public int getNumero_appartement() {
        return numero_appartement;
    }

    public void setNumero_appartement(int numero_appartement) {
        this.numero_appartement = numero_appartement;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "numero_appartement=" + numero_appartement +
                ", statut=" + statut +
                ", numTel=" + numTel +
                '}';
    }
}
