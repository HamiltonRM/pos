/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class Compra {
    private int id;
    private int cantidad;
    private int fecha;
    private int usuario_id;
    private int proveedor_id;
    private int forma_pago_id;

public Compra(int _id,int _cantidad,int _fecha, int _usuario_id,int _proveedor_id,int _forma_pago_id){
id=_id;
cantidad=_cantidad;
fecha=_fecha;
usuario_id=_usuario_id;
proveedor_id=_proveedor_id;
forma_pago_id=_forma_pago_id;
}
public void setId(int id){
    this.id=id;
}
public int getId(){
    return id;
}
public void setCantidad(int cantidad){
    this.cantidad=cantidad;
}
public int getCantidad(){
    return cantidad;
}
public void setFecha(int fecha){
    this.fecha=fecha;
}
public int getFecha(){
    return fecha;
}
public void setUsuario_id(int usuario_id){
    this.usuario_id=usuario_id;
}
public int getUsuario_id(){
    return usuario_id;
    
}
public void setProveedor_id(int proveedor_id){
    this.proveedor_id=proveedor_id;
}
public int getProveedor_id(){
    return proveedor_id;
}
public void setForma_pago(int forma_pago_id){
    this.forma_pago_id=forma_pago_id;
}
public int getForma_pago(){
    return forma_pago_id;
}

}
