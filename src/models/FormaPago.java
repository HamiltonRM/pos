/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class FormaPago {
    private int id;
    private String nombre;
    private String descripcion;
    
public FormaPago(int _id,String _nombre,String _descripcion){
    id=_id;
    nombre=_nombre;
    descripcion=_descripcion;
    
}
public void setId(int id){
    this.id=id;
}
public int getId(){
    return id;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
public String getNombre(){
    return nombre;
}
public void setDescripcion(String descripcion){
    this.descripcion=descripcion;
}
public String getDescripcion(){
    return descripcion;
}
   @Override
    public String toString() {
        return this.getNombre();
    }
}

