/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rouse
 */
public class Producto {

    private int id;
    private String nombre;
    private String cantidad;
    private String precio;
    private String codigo;
    private int medida_id;
    private int marca_id;
    private int seccion_id;
    private int categoria_id;

    public Producto(int _id, String _nombre, String _cantidad, String _precio, String _codigo, int _medida_id, int _marca_id, int _seccion_id, int _categoria_id) {
        id = _id;
        nombre = _nombre;
        cantidad = _cantidad;
        precio = _precio;
        codigo = _codigo;
        medida_id = _marca_id;
        marca_id = _medida_id;
        seccion_id = _seccion_id;
        categoria_id = _categoria_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public int getMedida_id() {
        return medida_id;
    }

    public void setMedida_id(int medida_id) {
        this.medida_id = medida_id;
    }

    public int getSeccion_id() {
        return seccion_id;
    }

    public void setSeccion_id(int seccion_id) {
        this.seccion_id = seccion_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
}
