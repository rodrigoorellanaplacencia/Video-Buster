/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ivo
 */
public class Pelicula {
    private int codigo;
    private int precio;
    private int idCategoria;
    private char formato4k;
    private String nombre;

    public Pelicula(int codigo, int precio, int idCategoria, char formato4k, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.formato4k = formato4k;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public char getFormato4k() {
        return formato4k;
    }

    public void setFormato4k(char formato4k) {
        this.formato4k = formato4k;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
