package Hibernate;
// Generated 04-jun-2023 19:02:43 by Hibernate Tools 4.3.1



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


