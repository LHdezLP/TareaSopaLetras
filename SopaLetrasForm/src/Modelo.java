
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class Modelo {
    
    private final String sURL = "jdbc:mariadb://localhost:3306/sopaletra";
    
    public String obtenerPalabras() {
    StringBuilder palabrasConcatenadas = new StringBuilder();
    
    try (Connection con = DriverManager.getConnection(sURL, "root", "");
         Statement s = con.createStatement();
         ResultSet rs = s.executeQuery("SELECT * FROM palabras")) {
        
        while (rs.next()) {
            palabrasConcatenadas.append(rs.getString("palabra")).append(", ");
        }
        
        // Elimina la última coma y el espacio extra
        if (palabrasConcatenadas.length() > 0) {
            palabrasConcatenadas.setLength(palabrasConcatenadas.length() - 2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return palabrasConcatenadas.toString();
}
    
    public void agregarPalabra(String palabra) {
        try {
            Connection con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO palabras (palabra) VALUES ('" + palabra + "')");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePalabra(String palabra) {
        try {
            Connection con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            s.executeUpdate("DELETE FROM `palabras` WHERE `palabra` = '"+ palabra +"'");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}

