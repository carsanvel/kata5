package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

    private Connection connect() {
        Connection con = null;
        String url = "jdbc:sqlite:prueba.db";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public void selectAll() {
        String sql = "SELECT * FROM PEOPLE";
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getInt("ID") + "\t" +
                                   result.getString("Name") + "\t" +
                                   result.getString("Apellido") + "\t" +
                                   result.getString("Departamento"));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
}
