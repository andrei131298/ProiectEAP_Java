package pachet;

public interface Database {

    public static final String insertUtilizator ="INSERT INTO utilizatori(tiputilizator,nume,prenume,sex,inaltime,greutate,parola,limitacalorii,varsta,email) VALUES (?,?,?,?,?,?,?,?,?,?)";
    public static final String cautaNumeUtilizator ="SELECT * FROM utilizatori WHERE nume LIKE ?";
    public static final String insertCategorie ="INSERT INTO categorii(denumire) VALUES (?)";
    public static final String cautaCategorie ="SELECT * FROM categorii WHERE denumire LIKE ?";
    public static final String cautaIdCategorie ="SELECT * FROM categorii WHERE denumire LIKE ?";
    public static final String cautaIdAliment ="SELECT * FROM alimente WHERE daliment LIKE ?";
    public static final String cautaIdAlimentDupaDesc ="SELECT * FROM alimente WHERE descriere LIKE ?";
    public static final String cautaIdAlimentDupaNrSub ="SELECT * FROM alimente WHERE nrcalorii<=?";
    public static final String cautaIdAlimentDupaNrPeste ="SELECT * FROM alimente WHERE nrcalorii>=?";
    public static final String cautaParola ="SELECT * FROM utilizatori WHERE parola LIKE ?";
    public static final String cautaPrenume ="SELECT * FROM utilizatori WHERE prenume LIKE ?";
    public static final String setLimitaCalorii ="UPDATE utilizatori SET limitacalorii= ? WHERE nume=?";
    public static final String insertMeniu ="INSERT INTO LiniiMeniu  VALUES(?,?,?,?)";
    public static final String cautaDescriere ="SELECT * FROM alimente WHERE descriere LIKE ?";
    public static final String cautaNumeAliment ="SELECT * FROM alimente WHERE daliment LIKE ?";
    public static final String cautaPesteNrCalorii ="SELECT * FROM alimente WHERE nrcalorii>=?";
    public static final String cautaSubNrCalorii ="SELECT * FROM alimente WHERE nrcalorii<=?";
    public static final String insertAliment ="INSERT INTO alimente(daliment,descriere,nrcalorii,idcategorie) VALUES (?,?,?,?)";
    public static final String cautaPoza="SELECT * FROM poze WHERE idaliment=?";

}
