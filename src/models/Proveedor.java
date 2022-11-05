/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */

public class Proveedor {
private  int id;
private String nombre_proveedor;
private String nit;


public Proveedor(int _id, String _nombre_proveedor,String _nit){

id=_id;
nombre_proveedor=_nombre_proveedor;
nit=_nit;
}
public void setId(int id){
 this.id=id;
}
public int getId(){
    return id;
}
public void setNombre_Proveedor(String nombre_proveedor){
    this.nombre_proveedor=nombre_proveedor;
    
}
public String getNombre_Proveedor(){
    return nombre_proveedor;
}
public void setNit(String nit){
    this.nit=nit;
}
public String getNit(){
    return nit;
}
}