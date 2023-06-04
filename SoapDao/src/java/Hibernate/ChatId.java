package Hibernate;
// Generated 30-may-2023 15:55:56 by Hibernate Tools 4.3.1



/**
 * ChatId generated by hbm2java
 */
public class ChatId  implements java.io.Serializable {


     private long idProducto;
     private String idUsuario;

    public ChatId() {
    }

    public ChatId(long idProducto, String idUsuario) {
       this.idProducto = idProducto;
       this.idUsuario = idUsuario;
    }
   
    public long getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChatId) ) return false;
		 ChatId castOther = ( ChatId ) other; 
         
		 return (this.getIdProducto()==castOther.getIdProducto())
 && ( (this.getIdUsuario()==castOther.getIdUsuario()) || ( this.getIdUsuario()!=null && castOther.getIdUsuario()!=null && this.getIdUsuario().equals(castOther.getIdUsuario()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdProducto();
         result = 37 * result + ( getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode() );
         return result;
   }   


}


