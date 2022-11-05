/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Seccion;

      
public class SeccionRepository {
private Connection conexion;
public SeccionRepository(Connection _conexion){
    conexion=_conexion;
}
public Seccion create(String codigo,String nombre, String descripcion)throws SQLException{
    PreparedStatement statement =conexion.prepareStatement("Insert into seccion(codigo,nombre,descripcion)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, codigo);
    statement.setString(2, nombre);
    statement.setString(3, descripcion);
    statement.executeUpdate();
    ResultSet keys=statement.getGeneratedKeys();
    keys.next();
    int id=keys.getInt(1);
    Seccion creada= new Seccion (id,codigo,nombre,descripcion);
    return creada;
}
public ArrayList<Seccion>read()throws SQLException{
    var statement=conexion.prepareStatement("select *from seccion");
    var result = statement.executeQuery();
    var secciones= new ArrayList<Seccion>();
    while(result.next()){
        Seccion seccion =new Seccion(
        result.getInt("id"),
        result.getString("codigo"),
                result.getString("nombre"),
                result.getString("descripcion")
                );
        
        secciones.add(seccion);
        
        
    }
    return secciones;
}
public Seccion Update(int id, Seccion seccion)throws SQLException{
    PreparedStatement statement= conexion.prepareStatement("Update seccion set codigo=?,nombre=?,descripcion=? where id=?",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, seccion.getCodigo());
    statement.setString(2, seccion.getNombre());
    statement.setString(3, seccion.getDescripcion());
    statement.setInt(4, id);
    statement.executeUpdate();
    seccion.setId(id);
    return seccion;
}
public void delete(int id)throws SQLException{
    var statement=conexion.prepareStatement("Delete from seccion where id=?");
    statement.setInt(1, id);
    statement.execute();
    
}
}
