package pachet;

import java.sql.*;

public class Conexiune {

    public Connection connection;

    public Conexiune() {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String USER = "andrei131298";
        String PASS = "andrei13";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}