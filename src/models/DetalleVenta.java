/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class DetalleVenta {
    private  int id;
    private int cantidad;
    private  int venta_id;
    private int producto_id;
    
    public DetalleVenta(int _id,int _cantidad, int _venta_id,int _producto_id){
        id=_id;
        cantidad=_cantidad;
        venta_id=_venta_id;
        producto_id=_producto_id;
        
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
    public void setVenta_id(int venta_id){
        this.venta_id=venta_id;
    }
    public int getVenta_id(){
        return venta_id;
    }
    public void setProducto_id(int producto_id){
        this.producto_id=producto_id;
    }
    public int getProducto_id(){
        return producto_id;
    }
   
}
