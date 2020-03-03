package pachet;

import java.util.ArrayList;

public class LinieMeniu {
    private int idUtilizator;
    private int nrCrt;
    private ArrayList<Aliment> alim;
    private double cantitate;

    public LinieMeniu(int id, int nr, Aliment al, double cant){
        idUtilizator=id; nrCrt=nr; ArrayList<Aliment> alim = new ArrayList<>(); cantitate=cant;
    }
    public String toString(){
        return String.format("%d,%d,%s,%.2f",idUtilizator,nrCrt,alim,cantitate);
    }

}

