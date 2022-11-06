/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.DetalleVenta;

/**
 *
 * @author rouse
 */
public class DetallesVentaRepository {
    private final Connection conexion;
    
    public DetallesVentaRepository(Connection _conexion) {
        conexion = _conexion;
    }
    
    public DetalleVenta create(int cantidad, int ventaId, int productoId) throws SQLException {
        var statement = conexion.prepareStatement("INSERT INTO detalle_venta (cantidad, venta_id, producto_id) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, cantidad);
        statement.setInt(2, ventaId);
        statement.setInt(3, productoId);
        
        statement.executeUpdate();
       ResultSet keys=statement.getGeneratedKeys();
       keys.next();
       int id=keys.getInt(1);
       
       var creado = new DetalleVenta(id, cantidad, ventaId, productoId);
       return creado;
    }
}
