/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class Cliente {
    private int id;
    private String nit;
    private String nombre;
    private String apellidos;
    private String edad;
    private String sexo;
    private String direccion;
  
    public Cliente(int _id,String _nit, String _nombre, String _apellidos, String _edad, String _sexo, String _direccion) {
        id = _id;
        nit=_nit;
        nombre = _nombre;
        apellidos = _apellidos;
        edad = _edad;
        sexo = _sexo;
        direccion = _direccion;
    }

   public void setId(int id){
       this.id=id;
       
   }
   public int getId(){
       return id;
   }
   public void setNit(String nit){
       this.nit=nit;
       
   }
   public String getNit(){
       return nit;
   }
     public void setNombre(String nombre){
       this.nombre=nombre;
       
   }
   public String getNombre(){
       return nombre;
   }
    public void setApellidos(String apellidos){
       this.apellidos=apellidos;
       
   }
   public String getApellidos(){
       return apellidos;
   }
    public void setEdad(String edad){
       this.edad=edad;
       
   }
   public String getEdad(){
       return edad;
   }
    public void setSexo(String sexo){
       this.sexo=sexo;
       
   }
   public String  getSexo(){
       return sexo;
   }
    public void setDireccion(String direccion){
       this.direccion=direccion;
       
   }
   public String getDireccion(){
       return direccion;
   }
    
}
