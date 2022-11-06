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
import models.Proveedor;

public class ProveedorRepository{
    private Connection conexion;
    public ProveedorRepository(Connection _conexion){
    conexion=_conexion;
}
    public Proveedor create(String nombre_proveedor, String nit) throws SQLException{
    
    PreparedStatement statement=conexion.prepareStatement("insert into proveedor(nombre_proveedor,nit)values(?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,nombre_proveedor);
    statement.setString(2,nit);
    
    
    statement.executeUpdate();
    ResultSet keys=statement.getGeneratedKeys();
    keys.next();
    
    int id=keys.getInt(1);
    Proveedor creada=new Proveedor(id,nombre_proveedor,nit);
    return creada;
}
    public ArrayList<Proveedor>read()throws SQLException{
    var statement =conexion.prepareStatement("select * from proveedor");
    var result=statement.executeQuery();
    var proveedores=new ArrayList<Proveedor>();
    while(result.next()){
           Proveedor proveedor=new Proveedor(
        result.getInt("id"),
        result.getString("nombre_proveedor"),
                   result.getString("nit")
                
                        );
       
              proveedores.add(proveedor);
    }
    return proveedores;
    
}
    public Proveedor update (int id,Proveedor proveedor)throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("update proveedor set nombre_proveedor=?,nit=? where id=?",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, proveedor.getNombre_Proveedor());
    statement.setString(2, proveedor.getNit());
    statement.setInt(3, id);
    statement.executeUpdate();
    proveedor.setId(id);
    return proveedor;
}
    public void delete (int id)throws SQLException{
    var statement=conexion.prepareStatement("delete from proveedor where id=?");
    statement.setInt(1, id);
    statement.execute();
}
}
