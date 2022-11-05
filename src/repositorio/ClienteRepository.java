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
import models.Cliente;

public class ClienteRepository {
    private Connection conexion;
public ClienteRepository(Connection _conexion){
    conexion=_conexion;
}
public Cliente create(String nit,String nombre, String apellidos, String edad, String sexo, String direccion) throws SQLException{
    
    PreparedStatement statement=conexion.prepareStatement("insert into cliente(nit,nombre,apellidos,edad,sexo,direccion)values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,nit);
    statement.setString(2,nombre);
    statement.setString(3,apellidos);
    statement.setString(4,edad);
      statement.setString(5,sexo);
        statement.setString(6,direccion);
    statement.executeUpdate();
    ResultSet keys=statement.getGeneratedKeys();
    keys.next();
    
    int id=keys.getInt(1);
    Cliente creada =new Cliente(id,nit,nombre,apellidos,edad,sexo,direccion);
    return creada;
}
public ArrayList<Cliente>read()throws SQLException{
    var statement =conexion.prepareStatement("select * from cliente ");
    var result=statement.executeQuery();
    var clientes=new ArrayList<Cliente>();
    while(result.next()){
           Cliente cliente = new Cliente(
        result.getInt("id"),
       
                   result.getString("nit"),
                result.getString("nombre"),
                   result.getString("apellidos"),
                   result.getString("edad"),
                   result.getString("sexo"),
                   result.getString("direccion")
                        );
       
              clientes.add(cliente);
    }
    return clientes;
    
}
public Cliente update (int id,Cliente cliente)throws SQLException{
    PreparedStatement statement=conexion.prepareStatement("update cliente set nit=?,nombre=?,apellidos=?,edad=?,sexo=?,direccion=?  where id=? ",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1,cliente.getNit());
    statement.setString(2, cliente.getNombre());
    statement.setString(3, cliente.getApellidos());
    statement.setString(4, cliente.getEdad());
    statement.setString(5, cliente.getSexo());
    statement.setString(6, cliente.getDireccion());
    statement.setInt(7, id);
    statement.executeUpdate();
    cliente.setId(id);
    return cliente;
}
public void delete (int id)throws SQLException{
    var statement=conexion.prepareStatement("delete from cliente where id=?");
    statement.setInt(1, id);
    statement.execute();
}

}
