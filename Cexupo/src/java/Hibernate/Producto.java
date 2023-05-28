package Hibernate;
// Generated 28-may-2023 20:01:54 by Hibernate Tools 4.3.1



/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Long id;
     private Usuario usuario;
     private String nombre;
     private String descripcion;
     private String estado;
     private float precio;
     private String hastag;
     private boolean vendido;

    public Producto() {
    }

    public Producto(Usuario usuario, String nombre, String descripcion, String estado, float precio, String hastag, boolean vendido) {
       this.usuario = usuario;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.estado = estado;
       this.precio = precio;
       this.hastag = hastag;
       this.vendido = vendido;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getHastag() {
        return this.hastag;
    }
    
    public void setHastag(String hastag) {
        this.hastag = hastag;
    }
    public boolean isVendido() {
        return this.vendido;
    }
    
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }




}


