
package models;

/**
 *
 * @author rouse
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String contrasenia;
    

public Usuario(int _id,String _nombre,String _email,String _contrasenia){
id=_id;
nombre=_nombre;
email=_email;
contrasenia=_contrasenia;
}

   


public int getId(){
    return id;
}
public void setId(int id){
    this.id=id;
}
public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
public String getEmail(){
    return email;
}
public void setEmail(String nombre){
    this.nombre=nombre;
}
public String getContraenia(){
    return contrasenia;
}
public void setContrasenia(String contrasenia){
    this.contrasenia=contrasenia;
}

}