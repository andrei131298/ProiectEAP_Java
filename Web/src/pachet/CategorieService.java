package pachet;

import java.sql.*;

public class CategorieService {

    private Conexiune c=new Conexiune();

    public void insertCategorie(Categorie categ) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.insertCategorie)) {
            statement.setString(1, categ.getDenumire());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String cautaCategorie(String denumire) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaCategorie)) {
            statement.setString(1, denumire);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("denumire");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int cautaIdCategorie(String denumire) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.cautaIdCategorie)) {
            statement.setString(1, denumire);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idcategorie");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
