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

public class MarcaRepository {

private Connection conexion;
public MarcaRepository(Connection _conexion){
    conexion=_conexion;
}

public Marca create(String codigo, String nombre, String descripcion) throws SQLException{
    
    PreparedStatement statement=conexion.prepareStatement("insert into marca(codigo,nombre,descripcion)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,codigo);
    statement.setString(2,nombre);
    statement.setString(3,descripcion);
    
    statement.executeUpdate();
    ResultSet keys=statement.getGeneratedKeys();
    keys.next();
    
    int id=keys.getInt(1);
    Marca creada=new Marca(id,codigo,nombre,descripcion);
    return creada;
}
public ArrayList<Marca>read()throws SQLException{
    var statement =conexion.prepareStatement("select * from marca");
    var result=statement.executeQuery();
    var marcas=new ArrayList<Marca>();
    while(result.next()){
           Marca marca=new Marca(
        result.getInt("id"),
        result.getString("codigo"),
                   result.getString("nombre"),
                result.getString("descripcion")
                        );
       
              marcas.add(marca);
    }
    return marcas;
    
}

public Marca update (int id,Marca marca)throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("update marca set codigo=?,nombre=?,descripcion=? where id=?",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, marca.getCodigo());
    statement.setString(2, marca.getNombre());
    statement.setString(3, marca.getDescripcion());
    statement.setInt(4, id);
    statement.executeUpdate();
    marca.setId(id);
    return marca;
}
public void delete (int id)throws SQLException{
    var statement=conexion.prepareStatement("delete from marca where id=?");
    statement.setInt(1, id);
    statement.execute();
}
  

}
