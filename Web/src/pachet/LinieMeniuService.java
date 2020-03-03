package pachet;

import java.sql.*;


public class LinieMeniuService {

    private Conexiune c=new Conexiune();

    public void insertMeniu(int idUtil, int nrcrt, double cantitate, int idaliment) {
        try (PreparedStatement statement = c.connection.prepareStatement(Database.insertMeniu)) {
            statement.setInt(1, idUtil);
            statement.setInt(2, nrcrt);
            statement.setDouble(3, cantitate);
            statement.setInt(4, idaliment);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

