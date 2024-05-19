package src.com.uca.entity;

public class Compte {

    int num_tel;
    String mdp;

    public Compte(int num_tel, String mdp){
        this.num_tel = num_tel;
        this.mdp = mdp;
    }

    public int getNum_tel(){
        return this.num_tel;
    }

    public String getMdp(){
        return this.mdp;
    }

    public void setNum_tel(int num_tel){
        this.num_tel = num_tel;
    }

    public void setMdp(String mdp){
        this.mdp = mdp;
    }

    
    
}
