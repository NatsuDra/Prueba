
package Core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Root
 */
public class MetodosDataCopy {
    
    
    public static void llenaCombo(ConexionBBDD c,JComboBox combo, String SQL){
        
        ResultSet resultado=c.Consulta(SQL);//le paso ademas del sql la conexion para cerrarla al final del metodo
        
        
         try {
            resultado.last();//MUEVE EL PUNTERO AL ULTIMO
            int largo=resultado.getRow();//RETORNA EN QUE POSICION SE ENCUENTRA EL RESULTSET(RESULTADO)
            
            if(largo!=0){
              resultado.beforeFirst();//MUEVE EL PUNTERO A ANTES DEL PRIMERO PARA QUE CUANDO ENTRE EN EL WHILE MUESTRE EL PRIMERO
             
             while (resultado.next()) {                 
                combo.addItem(resultado.getString(1));
             }
             
                
    }
         } catch (SQLException ex) {
            Logger.getLogger(MetodosDataCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
