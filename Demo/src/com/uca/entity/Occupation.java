package src.com.uca.entity;

public class Occupation {

    private int numeroTel;
    private String statut;
    private int numeroAppt;
    private String adresseAppt;


    public Occupation(int numeroTel, String statut, int numeroAppt, String adresseAppt){
        this.numeroTel = numeroTel;
        this.statut = statut;
        this.numeroAppt = numeroAppt;
        this.adresseAppt = adresseAppt;
    }

    public int getNumeroTel() {
        return this.numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getStatut() {
        return this.statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNumeroAppt() {
        return this.numeroAppt;
    }

    public void setNumeroAppt(int numeroAppt) {
        this.numeroAppt = numeroAppt;
    }

    public String getAdresseAppt(){
        return this.adresseAppt;
    }

    public void setAdresseAppt(String adresseAppt){
        this.adresseAppt = adresseAppt;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "numeroTel=" + numeroTel +
                ", statut=" + statut +
                ", numeroAppt=" + numeroAppt +
                ", adresseAppt=" + adresseAppt +
                '}';
    }
}
