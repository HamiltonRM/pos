package ComboBox;

import conections.ConnectionSQL;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author rouse
 */
public class rellenarComboCategoria {

    public void rellenarcombocategoria(String tabla, String valor, JComboBox combo) {
        String sql = "select * from categoria";
        Statement st;
        ConnectionSQL con = new ConnectionSQL();
        Connection conexion = con.Conexion();
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                combo.addItem(rs.getString(valor));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }

    }
}
