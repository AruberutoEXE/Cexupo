package Hibernate;
// Generated 30-mar-2023 13:28:31 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Mensaje generated by hbm2java
 */
public class Mensaje  implements java.io.Serializable {


     private Long id;
     private long idUsuario;
     private long idChat;
     private Date fecha;
     private String contenido;

    public Mensaje() {
    }

    public Mensaje(long idUsuario, long idChat, Date fecha, String contenido) {
       this.idUsuario = idUsuario;
       this.idChat = idChat;
       this.fecha = fecha;
       this.contenido = contenido;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public long getIdChat() {
        return this.idChat;
    }
    
    public void setIdChat(long idChat) {
        this.idChat = idChat;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }




}

