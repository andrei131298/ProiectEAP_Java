package pachet;

public class Categorie {
    private int idCategorie;
    private String denumire;

    public Categorie(int id, String d) {
        idCategorie = id;
        denumire = d;
    }

    public String toString() {
        return String.format("%d,%s", idCategorie, denumire);
    }
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
