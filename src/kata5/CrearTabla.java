package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

    public static void createNewTable() {
        String url = "jdbc:sqlite:mail.db";
        String sql = "CREATE TABLE IF NOT EXISTS direc_email (\n" +
                     "id integer PRIMARY KEY AUTOINCREMENT, \n" +
                     "direccion text NOT NULL);";
        try {
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla creada");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
