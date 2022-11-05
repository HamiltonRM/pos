/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class Medida {
    private int id;
    private String codigo;
    private String nombre;
    private String abreviatura;
    
   public Medida(int _id,String _codigo,String _nombre,String _abreviatura){
       id=_id;
       codigo=_codigo;
       nombre=_nombre;
       abreviatura=_abreviatura;
   } 
   public void setId(int id){
       this.id=id;
       
   }
   public int getId(){
       return id;
   }
   public void setCodigo(String codigo){
       this.codigo=codigo;
   }
   public String getCodigo(){
       return codigo;
   }
   public void setNombre(String nombre){
       this.nombre=nombre;
   }
   public String getNombre(){
       return nombre;
       
   }
   public void setAbreviatura(String abreviatura){
        this.abreviatura=abreviatura;
   }
   public String getAbreviatura(){
       return abreviatura;
   }
   
   
   
    @Override
    public String toString(){
        return this.getNombre();
    }
    
    
}
