
package repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import models.FormaPago;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class FormaPagoRepository {

private Connection conexion;

public FormaPagoRepository(Connection _conexion){
    conexion=_conexion;
    
}
public FormaPago create(String nombre,String descripcion)throws SQLException{
    PreparedStatement statement =conexion.prepareStatement("insert into forma_pago(nombre,descripcion)values(?,?)",Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, nombre);
    statement.setString(2, descripcion);
     statement.executeUpdate();
        ResultSet keys=statement.getGeneratedKeys();
        keys.next();
        int id=keys.getInt(1);
        FormaPago creada=new FormaPago (id,nombre,descripcion);
        return creada;
   
}
public ArrayList<FormaPago>read()throws SQLException{
        
        var statement=conexion.prepareStatement("Select * from forma_pago");
        var result =statement.executeQuery();
        var formapagos=new ArrayList<FormaPago>();
        while(result.next()){
            FormaPago formapago=new FormaPago(
                    result.getInt("id"),
                    
                    result.getString("nombre"),
                    result.getString("descripcion")
            );
            formapagos.add(formapago);
            
        }
        return formapagos;
        }
public FormaPago update(int id,FormaPago formapago)throws SQLException{
            PreparedStatement statement=conexion.prepareStatement("Update forma_pago set nombre=?,descripcion=? where id=?",Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, formapago.getNombre());
         statement.setString(2, formapago.getDescripcion());
         statement.setInt(3, id);
         statement.executeUpdate();
         formapago.setId(id);
         return formapago;
        }
public void delete (int id)throws SQLException{
            var statement=conexion.prepareStatement("Delete from forma_pago where id=?");
            statement.setInt(1,id);
            statement.execute();
        }
}


