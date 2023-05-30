package Hibernate;
// Generated 30-may-2023 15:55:56 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Venta generated by hbm2java
 */
public class Venta  implements java.io.Serializable {


     private Long id;
     private float precioTotal;
     private String idUsuario;
     private Date fechaVenta;
     private long idProducto;
     private long idPuntuacion;
     private long idTarifa;
     private long idDireccion;
     private long idMetodoPago;

    public Venta() {
    }

    public Venta(float precioTotal, String idUsuario, Date fechaVenta, long idProducto, long idPuntuacion, long idTarifa, long idDireccion, long idMetodoPago) {
       this.precioTotal = precioTotal;
       this.idUsuario = idUsuario;
       this.fechaVenta = fechaVenta;
       this.idProducto = idProducto;
       this.idPuntuacion = idPuntuacion;
       this.idTarifa = idTarifa;
       this.idDireccion = idDireccion;
       this.idMetodoPago = idMetodoPago;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public float getPrecioTotal() {
        return this.precioTotal;
    }
    
    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Date getFechaVenta() {
        return this.fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public long getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    public long getIdPuntuacion() {
        return this.idPuntuacion;
    }
    
    public void setIdPuntuacion(long idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }
    public long getIdTarifa() {
        return this.idTarifa;
    }
    
    public void setIdTarifa(long idTarifa) {
        this.idTarifa = idTarifa;
    }
    public long getIdDireccion() {
        return this.idDireccion;
    }
    
    public void setIdDireccion(long idDireccion) {
        this.idDireccion = idDireccion;
    }
    public long getIdMetodoPago() {
        return this.idMetodoPago;
    }
    
    public void setIdMetodoPago(long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }




}


