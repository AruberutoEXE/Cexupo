package Hibernate;
// Generated 30-mar-2023 13:28:31 by Hibernate Tools 4.3.1



/**
 * Empresatransporte generated by hbm2java
 */
public class Empresatransporte  implements java.io.Serializable {


     private Long id;
     private String nombre;

    public Empresatransporte() {
    }

    public Empresatransporte(String nombre) {
       this.nombre = nombre;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}

