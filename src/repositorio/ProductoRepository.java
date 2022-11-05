/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import models.Marca;
import java.sql.SQLException;
import models.Producto;
public class ProductoRepository {
    
 private Connection conexion;
public ProductoRepository(Connection _conexion){
    conexion=_conexion;
}
public Producto create(String nombre,String cantidad,String precio,String codigo,int marca_id,int medida_id,int seccion_id,int categoria_id ) throws SQLException{
    
    PreparedStatement statement=conexion.prepareStatement("insert into producto(nombre,cantidad,precio,codigo,marca_id,medida_id,seccion_id,categoria_id)values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,nombre);
    statement.setString(2,cantidad);
    statement.setString(3,precio);
    statement.setString(4,codigo);
    statement.setInt(5,marca_id);
        statement.setInt(6,medida_id);
        statement.setInt(7,seccion_id);
        statement.setInt(8, categoria_id);
    statement.executeUpdate();
    ResultSet keys=statement.getGeneratedKeys();
    keys.next();
    
    int id=keys.getInt(1);
    Producto creado =new Producto(id,nombre,cantidad,precio,codigo,marca_id,medida_id,seccion_id,categoria_id);
    return creado;
}
public ArrayList<Producto>read()throws SQLException{
    var statement =conexion.prepareStatement("select * from producto");
    var result=statement.executeQuery();
    var productos =new ArrayList<Producto>();
    while(result.next()){
           Producto producto;
        producto = new Producto(
                result.getInt("id"),
                result.getString("nombre"),
                result.getString("cantidad"),
                result.getString("precio"),
                result.getString("codigo"),
                result.getInt("marca_id"),
                result.getInt("medida_id"),
                result.getInt("seccion_id"),
                result.getInt("categoria_id")
        );
       
              productos.add(producto);
    }
    return productos;
    
}
public Producto update (int id,Producto producto)throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("update producto set nombre=?,cantidad=?,precio=?,codigo=?,marca_id=?,medida_id=?,seccion_id=?,categoria_id=?  where id=?",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,producto.getNombre());
    statement.setString(2, producto.getCantidad());
    statement.setString(3, producto.getPrecio());
    statement.setString(4, producto.getCodigo());
    statement.setInt(5, producto.getMarca_id());
    statement.setInt(6, producto.getMedida_id());
    statement.setInt(7, producto.getSeccion_id());
    statement.setInt(8, producto.getCategoria_id());
    statement.setInt(9,id);
    statement.executeUpdate();
    producto.setId(id);
    return producto;
}
public void delete (int id)throws SQLException{
    var statement=conexion.prepareStatement("delete from producto where id=?");
    statement.setInt(1, id);
    statement.execute();
}


}


