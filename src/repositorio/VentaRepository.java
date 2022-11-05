/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

/**
 *
 * @author rouse
 */
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import models.Venta;
import conections.ConnectionSQL;
import java.util.ArrayList;
import java.sql.Connection;
import models.Usuario;
import java.sql.Date;

public class VentaRepository {

    private final Connection conexion;

    public VentaRepository(Connection _conexion) {
        conexion = _conexion;

    }

    public Venta create(int usuario_id, int cliente_id, int forma_pago_id) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement("insert into venta(fecha,usuario_id,cliente_id,forma_pago_id)values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        var currentDate = new java.util.Date();
        var fecha = new Date(currentDate.getTime());
        statement.setDate(1, fecha);
        statement.setInt(2, usuario_id);
        statement.setInt(3, cliente_id);
        statement.setInt(4, forma_pago_id);
        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);
        Venta creada = new Venta(id, currentDate, usuario_id, cliente_id, forma_pago_id);
        return creada;
    }

    public ArrayList<Venta> read() throws SQLException {
        var statement = conexion.prepareStatement("Select ¨* from venta");
        var result = statement.executeQuery();
        var ventas = new ArrayList<Venta>();
        while (result.next()) {
            Venta venta;
            venta = new Venta(
                    result.getInt("id"),
                    result.getDate("fecha"),
                    result.getInt("usuario_id"),
                    result.getInt("cliente_id"),
                    result.getInt("forma_pago_id")
            );
            ventas.add(venta);
        }
        return ventas;
    }

    public Venta update(int id, Venta venta) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement("update venta set fecha=?,usuario=?,cliente=?,forma_pago_id=? where id=?", Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, new Date(venta.getFecha().getTime()));
        statement.setInt(2, venta.getUsuario_id());
        statement.setInt(3, venta.getCliente_id());
        statement.setInt(4, venta.getForma_pago_id());
        statement.setInt(5, id);
        statement.executeUpdate();
        venta.setId(id);
        return venta;
    }

    public void delete(int id) throws SQLException {
        var statement = conexion.prepareStatement("delete from venta where id=?");
        statement.setInt(1, id);
        statement.execute();
    }
}
