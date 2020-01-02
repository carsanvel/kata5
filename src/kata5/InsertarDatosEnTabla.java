package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatosEnTabla {

    private static Connection connect() {
        Connection con = null;
        String url = "jdbc:sqlite:mail.db";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public static void insert(String email) {
        String sql  = "INSERT INTO direc_email(direccion) VALUES(?)";
        try {
            Connection con = connect();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
