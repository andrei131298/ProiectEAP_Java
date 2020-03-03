package pachet;

import java.sql.*;


public class AlimentService {

    private Conexiune c=new Conexiune();

    public void insertAliment(Aliment aliment) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.insertAliment)) {
            statement.setString(1, aliment.getNume());
            statement.setString(2, aliment.getDescriere());
            statement.setInt(3, aliment.getNrCalorii());
            statement.setInt(4, aliment.getIdCategorie());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String cautaDescriere(String desc) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaDescriere)) {
            statement.setString(1, desc);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("descriere");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cautaNumeAliment(String numeAliment) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaNumeAliment)) {
            statement.setString(1, numeAliment);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("daliment");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String afiseazaAliment(String numeAlim) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaNumeAliment)) {
            statement.setString(1, numeAlim);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ("Denumire: "+rs.getString("daliment")+"; Descriere: "+rs.getString("descriere")+"; Numar calorii: "+rs.getInt("nrcalorii"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Nu exista acest aliment";
    }

    public String afiseazaAlimentDupaDesc(String descAlim) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaDescriere)) {
            statement.setString(1, descAlim);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ("Denumire: "+rs.getString("daliment")+"; Descriere: "+rs.getString("descriere")+"; Numar calorii: "+rs.getInt("nrcalorii"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Nu exista aceasta descriere";
    }

    public String afiseazaAlimentDupaNrCaloriiSub(int nrCal) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaSubNrCalorii)) {
            statement.setInt(1, nrCal);
            ResultSet rs = statement.executeQuery();
            String s="";
            while(rs.next()){
                s+= ("Denumire: "+rs.getString("daliment")+"; Descriere: "+rs.getString("descriere")+"; Numar calorii: "+rs.getInt("nrcalorii"));
                s+=";" ;
            }
            rs.close();
            if (s==""){
                return "Nu exista aliment";
            }
            else {
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "nu merge";
        }
    }

    public String afiseazaAlimentDupaNrCaloriiPeste(int nrCalPeste) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaPesteNrCalorii)) {
            statement.setInt(1, nrCalPeste);
            ResultSet rs = statement.executeQuery();
            String s="";
            while(rs.next()){
                s+= ("Denumire: "+rs.getString("daliment")+"; Descriere: "+rs.getString("descriere")+"; Numar calorii: "+rs.getInt("nrcalorii"));
                s+=";" ;
            }
            rs.close();
            if (s==""){
                return "Nu exista un aliment";
            }
            else {
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "nu merge";
        }
    }

    public int cautaPesteNrCalorii(int nrcalPeste) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaPesteNrCalorii)) {
            statement.setInt(1, nrcalPeste);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return (rs.getInt("nrcalorii"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nrcalPeste;
    }

    public int cautaSubNrCalorii(int nrcal) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaSubNrCalorii)) {
            statement.setInt(1, nrcal);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return (rs.getInt("nrcalorii"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nrcal;
    }

    public int cautaIdAliment(String denAlim) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaIdAliment)) {
            statement.setString(1, denAlim);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idaliment");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int cautaIdAlimentDupaDesc(String descAlim) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaIdAlimentDupaDesc)) {
            statement.setString(1, descAlim);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idaliment");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int cautaIdAlimentDupaNrSub(int NrCSub) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaIdAlimentDupaNrSub)) {
            statement.setInt(1, NrCSub);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idaliment");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int cautaIdAlimentDupaNrPeste(int NrCPeste) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaIdAlimentDupaNrSub)) {
            statement.setInt(1, NrCPeste);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idaliment");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String cautaPoza(int idAlim) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaPoza)) {
            statement.setInt(1, idAlim);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("cale");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
