package pachet;

public class Aliment {
    private int idAliment;
    private String nume;
    private String descriere;
    private int nrCalorii;
    private int IdCategorie;
    //private ArrayList<String> poze;

    public Aliment(int id, String n, String d, int nc, int c
                   //,ArrayList<String> p
                   ){
        idAliment=id;
        nume=n;
        descriere=d;
        nrCalorii=nc;
        IdCategorie=c;
        //poze=p;
    }
    public String toString(){
        String s=String.format("Id: %d, Nume: %s , nrCalorii:%d , categorie:%s\nDescriere:%s ",
                idAliment,nume,nrCalorii,IdCategorie,descriere);
        //for (int i=0; i<poze.size();i++)
            //s+="\nFisier poza:" + poze.get(i).toString();
        return s + "\n";
    }

    public int getIdAliment() {
        return idAliment;
    }
    public String getNume() {
        return nume;
    }
    public int getCateg() { return IdCategorie; }
    public String getDescriere() {
        return descriere;
    }
    public int getNrCalorii() {
        return nrCalorii;
    }
    public void setIdAliment(int idAliment) {
        this.idAliment = idAliment;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    public void setNrCalorii(int nrCalorii) {
        this.nrCalorii = nrCalorii;
    }
    public void setCateg(int categ) { this.IdCategorie = categ; }
    public int getIdCategorie(){
        return IdCategorie;
    }
}
