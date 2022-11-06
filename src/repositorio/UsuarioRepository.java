package repositorio;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import conections.ConnectionSQL;
import java.util.ArrayList;

import java.sql.SQLException;
import models.Usuario;

/**
 *
 * @author rouse
 */
public class UsuarioRepository {

    private Connection conexion;

    public UsuarioRepository(Connection _conexion) {
        conexion = _conexion;

    }

    public Usuario create(String nombre, String email, String contrasenia) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement("insert into usuario(nombre,email,contrasenia)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, nombre);
        statement.setString(2, email);
        statement.setString(3, contrasenia);
        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);
        Usuario creada = new Usuario(id, nombre, email, contrasenia);
        return creada;

    }

    public ArrayList<Usuario> read() throws SQLException {
        var statement = conexion.prepareStatement("select * from usuario");
        var result = statement.executeQuery();
        var usuarioss = new ArrayList<Usuario>();
        while (result.next()) {
            Usuario usuario = new Usuario(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getString("email"),
                    result.getString("contrasenia")
            );
            usuarioss.add(usuario);
        }
        return usuarioss;
    }

    public Usuario Update(int id, Usuario usuario) throws SQLException {
        PreparedStatement statement = conexion.prepareStatement("Update usuario set nombre=?,email=?,contrasenia=? where id=?", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getContraenia());
        statement.setInt(4, id);
        statement.executeUpdate();

        usuario.setId(id);
        return usuario;
    }

    public void delete(int id) throws SQLException {
        var statement = conexion.prepareStatement("delete from usuario where id=?");
        statement.setInt(1, id);
        statement.execute();
    }
}
