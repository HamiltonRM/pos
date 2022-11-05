/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Categoria {

    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;

    public Categoria(int _id, String _codigo, String _nombre, String _descripcion) {
        id = _id;
        codigo = _codigo;
        nombre = _nombre;
        descripcion = _descripcion;
    }

    public int getId() {
        return id;
    }

    public void settId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return this.getDescripcion();
    }
}
