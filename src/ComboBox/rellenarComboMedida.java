/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComboBox;
import conections.ConnectionSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
/**
 *
 * @author rouse
 */
public class rellenarComboMedida {
    public void rellenarComboMedida(String tabla,String valor,JComboBox combo){
         String sql="select*from medida";
        Statement st;
        ConnectionSQL con=new ConnectionSQL();
        Connection conexion=con.Conexion();
        try{
            st=conexion.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getString(valor));
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
            
        }
    }
}
