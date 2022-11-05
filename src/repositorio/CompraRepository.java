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
import models.Compra;
import conections.ConnectionSQL;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class CompraRepository {
private Connection conexion;
public CompraRepository(Connection _conexion){
    conexion=_conexion;
}
public Compra create (int cantidad,int fecha,int usuario_id,int proveedor_id,int forma_pago_id) throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("insert into compra(cantidad,fecha,usuario_id,proveedor_id,forma_pago_id)values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
    
statement.setInt(1, cantidad);
statement.setInt(2, fecha);
statement.setInt(3, usuario_id);
statement.setInt(4, proveedor_id);
statement.setInt(5, forma_pago_id);
statement.executeUpdate();
ResultSet keys=statement.getGeneratedKeys();
keys.next();
int id=keys.getInt(1);
Compra creada= new Compra(id,cantidad,fecha,usuario_id,proveedor_id,forma_pago_id);
return creada;

}
public ArrayList<Compra>read()throws SQLException{
    var statement = conexion.prepareStatement("Select * from compra");
    var result=statement.executeQuery();
    var compras=new ArrayList<Compra>();
    while(result.next()){
        Compra compra;
        compra = new Compra(
        result.getInt("id"),
        result.getInt("cantidad"),
        result.getInt("fecha"),
        result.getInt("usuario_id"),
        result.getInt("proveedor_id"),
        result.getInt("forma_pago_id")
                );   
        compras.add(compra);
    }
    return compras;
}
public Compra update(int id, Compra compra)throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("update compra set cantidad=?,fecha=?,usuario_id=?,proveedor_id=?,forma_pago_id=? where id=? ",Statement.RETURN_GENERATED_KEYS);
    statement.setInt(1, compra.getCantidad());
    statement.setInt(2, compra.getFecha());
    statement.setInt(3, compra.getUsuario_id());
    statement.setInt(4, compra.getProveedor_id());
    statement.setInt(5, compra.getForma_pago());
    statement.setInt(6, id);
    statement.executeUpdate();
    compra.setId(id);
    return compra;
}
public void delete(int id)throws SQLException{
    var statement=conexion.prepareStatement("delete from compra where id=?");
    statement.setInt(1, id);
    statement.execute();
}
}
