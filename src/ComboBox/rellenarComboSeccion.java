
package ComboBox;

import conections.ConnectionSQL;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
public class rellenarComboSeccion {
    public void rellenarcomboseccion(String tabla,String valor,JComboBox combo){
        String sql="Select * From seccion";
        Statement st;
        ConnectionSQL con=new ConnectionSQL();
        Connection conexion =con.Conexion();
        try{
            st =conexion.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getString(valor));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error"+e.toString());
            
        }
        
    }
}
