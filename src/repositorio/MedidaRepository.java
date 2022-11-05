/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import models.Medida;
import conections.ConnectionSQL;


public class MedidaRepository {
    private Connection conexion;
    public MedidaRepository(Connection _conexion){
        conexion=_conexion;
        
    }
    public Medida create(String codigo, String nombre, String abreviatura)throws SQLException {
        PreparedStatement statement = conexion.prepareStatement("Insert into medida (codigo,nombre,abreviatura)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, codigo);
        statement.setString(2, nombre);
        statement.setString(3, abreviatura);
        statement.executeUpdate();
        ResultSet keys=statement.getGeneratedKeys();
        keys.next();
        int id=keys.getInt(1);
        Medida creada = new Medida(id,codigo,nombre,abreviatura);
        return creada;
    }
    public ArrayList<Medida> read()throws SQLException{
     var statement=conexion.prepareStatement("Select * from medida");
     var result=statement.executeQuery();
     var medidas = new ArrayList<Medida>();
     while(result.next()){
         Medida medida= new Medida(
         result.getInt("id"),
         result.getString("codigo"),
         result.getString("nombre"),
         result.getString("abreviatura")
                 );
         medidas.add(medida);
     }
     return medidas;
    }
    public Medida Update(int id, Medida medida)throws SQLException{
        PreparedStatement statement=conexion.prepareStatement("Update medida set codigo=?,nombre=?,abreviatura=? where id=?",Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,medida.getCodigo());
        statement.setString(2, medida.getNombre());
        statement.setString(3, medida.getAbreviatura());
        statement.setInt(4, id);
        statement.executeUpdate();
        medida.setId(id);
        return medida;
    }
    public void delete(int id)throws SQLException{
        var statement=conexion.prepareStatement("delete from medida where id=?");
        statement.setInt(1, id);
        statement.execute();
    }
}


