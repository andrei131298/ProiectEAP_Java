package pachet;

import java.sql.*;


public class UtilizatorService {

    private Conexiune c=new Conexiune();

    public void insertUtilizator(Utilizator utilizator) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.insertUtilizator)) {
            statement.setString(1, utilizator.getTipUtilizator());
            statement.setString(2, utilizator.getNume());
            statement.setString(3, utilizator.getPrenume());
            statement.setString(4, utilizator.getSex());
            statement.setDouble(5, utilizator.getInaltime());
            statement.setInt(6, utilizator.getGreutate());
            statement.setString(7, utilizator.getParola());
            statement.setInt(8, utilizator.getLimitaCalorii());
            statement.setInt(9, utilizator.getVarsta());
            statement.setString(10, utilizator.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setLimitaCalorii(String numeU, int limita) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.setLimitaCalorii)) {
            statement.setString(1, numeU);
            statement.setInt(2, limita);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String cautaNumeUtilizator(String nume){
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaNumeUtilizator)){
            statement.setString(1, nume);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getString("nume");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String cautaPrenume(String prenume) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaPrenume)) {
            statement.setString(1, prenume);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("prenume");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String cautaParola(String parola) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaParola)) {
            statement.setString(1, parola);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("parola");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
