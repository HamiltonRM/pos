/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author rouse
 */
public class Venta {
    private int id;
    private Date fecha;
    private int usuario_id;
    private int cliente_id;
    private int forma_pago_id;
    
    
    public Venta(int _id,Date _fecha,int _usuario_id,int _cliente_id, int _forma_pago_id){
        id=_id;
        fecha=_fecha;
        usuario_id=_usuario_id;
        cliente_id=_cliente_id;
        forma_pago_id=_forma_pago_id;
    }
    public void setId(int id){
       this.id=id;
    }
    
    public int getId(){
        return id;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setUsuario_id(int usuario_id){
        this.usuario_id=usuario_id;
    }
    public int getUsuario_id(){
        return usuario_id;
    }
    public void setCliente_id(int cliente_id){
        this.cliente_id=cliente_id;
    }
    public int getCliente_id(){
        return cliente_id;
    }
    public void setForma_pago_id(int forma_pago_id){
        this.forma_pago_id=forma_pago_id;
    }
    public int getForma_pago_id(){
        return forma_pago_id;
    }
}
