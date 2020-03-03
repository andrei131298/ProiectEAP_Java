package pachet;

public class Utilizator {
    private int idUtilizator;
    private String tipUtilizator;
    private String nume;
    private String prenume;
    private String sex;
    private int inaltime;
    private int greutate;
    private String parola;
    private int limitaCalorii;
    private int varsta;
    private String email;
    //private ArrayList<pachet.LinieMeniu> meniu;

    public Utilizator(int id, String tu, String n, String pr, String s,int i, int g, String ps, int lc,int v, String e
                      //,ArrayList<pachet.LinieMeniu> l
    )
    {
        idUtilizator=id; tipUtilizator=tu;nume=n; prenume=pr; sex=s; inaltime=i; greutate=g;parola=ps;varsta=v;
        email=e;limitaCalorii=lc;
        //meniu=l;
    }

    public String toString(){
        return String.format("%d,%s,%s,%s,%c,%.2f,%d,%s,%d",idUtilizator,tipUtilizator,nume,prenume,
                sex,inaltime,greutate,parola,limitaCalorii);
    }
    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getTipUtilizator() {
        return tipUtilizator;
    }

    public void setTipUtilizator(String tipUtilizator) {
        this.tipUtilizator = tipUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSex() { return sex; }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getLimitaCalorii() {
        return limitaCalorii;
    }

    public void setLimitaCalorii(int limitaCalorii) {
        this.limitaCalorii = limitaCalorii;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
