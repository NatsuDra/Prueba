package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Root
 */
public class ConexionBBDD {

    private static String protocolo = "jdbc:mysql://";
    private static String server;
    private static int port;
    private static String db;
    private static String user;
    private static String pass;
    jsjsjsjsjsjsksl
    public ConexionBBDD(String server, int port, String db, String user, String pass) {
        this.server = server;
        this.port = port;
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public  Connection abrirConexion() {

        String url = protocolo + server + ":" + port + "/" + db;
        Connection cnx = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, pass);
            System.out.println("Conneccion Abierta");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 1: " + ex.toString(), "Error de Autenticacion", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR 1: " + ex.toString());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 2: " + ex.toString(), "Error de Autenticacion", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR 2: " + ex.toString());
            ex.printStackTrace();
        }

        return cnx;
    }

    public  void CerrarConexion(Connection c) {
        try {
            c.close();
            System.out.println("Conneccion Cerrada");
        } catch (SQLException ex) {
            System.out.println("ERROR al cerrar  " + ex.toString());
        }
    }

    public  int Actualizacion(String sql) {
        int resultado = 0;
        try {

            Connection cnx = abrirConexion();

            Statement st = cnx.createStatement();
            resultado = st.executeUpdate(sql);

            CerrarConexion(cnx);

        } catch (SQLException ex) {

            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public  ResultSet Consulta(String sql) {
        ResultSet result = null;
        
        try {
            Connection cnx = abrirConexion();

            Statement st = cnx.createStatement();
            result = st.executeQuery(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        return result;
    }

}
