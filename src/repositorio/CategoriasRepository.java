

package repositorio;

/**
 *
 * @author rouse
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Categoria;
import conections.ConnectionSQL;

public class CategoriasRepository {
    private  Connection conexion;
    
    public CategoriasRepository(Connection _conexion){
        conexion=_conexion;
        
    }
    public Categoria create(String codigo, String nombre, String descripcion) throws SQLException{
        
        PreparedStatement statement =conexion.prepareStatement("Insert into categoria (codigo,nombre,descripcion)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, codigo);
        statement.setString(2, nombre);
        statement.setString(3, descripcion);
        
        statement.executeUpdate();
        ResultSet keys=statement.getGeneratedKeys();
        keys.next();
        int id=keys.getInt(1);
        Categoria creada=new Categoria(id,codigo,nombre,descripcion);
        return creada;
   
}
    public ArrayList<Categoria>read()throws SQLException{
        
        var statement=conexion.prepareStatement("Select * from categoria");
        var result =statement.executeQuery();
        var categorias=new ArrayList<Categoria>();
        while(result.next()){
            Categoria categoria=new Categoria(
                    result.getInt("id"),
                    result.getString("codigo"),
                    result.getString("nombre"),
                    result.getString("descripcion")
            );
            categorias.add(categoria);
            
        }
        return categorias;
        }
        public Categoria update(int id,Categoria categoria)throws SQLException{
            PreparedStatement statement=conexion.prepareStatement("Update categoria set codigo=?,nombre=?,descripcion=? where id=?",Statement.RETURN_GENERATED_KEYS);
         statement.setString(1, categoria.getCodigo());
         statement.setString(2, categoria.getNombre());
         statement.setString(3, categoria.getDescripcion());
         statement.setInt(4, id);
         statement.executeUpdate();
         categoria.settId(id);
         return categoria;
        }
        public void delete (int id)throws SQLException{
            var statement=conexion.prepareStatement("Delete from categoria where id=?");
            statement.setInt(1,id);
            statement.execute();
        }
    }

