package kata5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBD {

    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;
        try{
            Connection con = DriverManager.getConnection(url);
            if(con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("El driver es " + meta.getDriverName());
                System.out.println("Se ha creado una nueva BD");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
