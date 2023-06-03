/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.PuntuacionDao;
import DAO.TarifaDao;
import DAO.UsuarioDao;
import DAO.VentaDao;
import Hibernate.Producto;
import Hibernate.Puntuacion;
import Hibernate.Venta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author alber
 */
public class DetallesVenta extends ActionSupport {

    private String nombre;
    private String precio;
    private String descripcion;
    private String estado;
    private String hastag;
    private String id_usuario;
    private String id;
    private String direccion;
    private String transporte;
    private String pago;
    private boolean editable;
    private boolean hayReview;
    private String estrellas;
    private String comentario;
    public DetallesVenta() {
    }

    public String execute() throws Exception {

        ProductoDao dao = new ProductoDao();

        Producto p = dao.getProducto(Integer.parseInt(id));
        nombre = p.getNombre();
        precio = p.getPrecio() + "";
        descripcion = p.getDescripcion();
        estado = p.getEstado();
        hastag = p.getHastag();
        id_usuario = p.getUsuario().getUsername();
        VentaDao vdao = new VentaDao();
        Venta v = vdao.getVenta(p.getId() + "");
        UsuarioDao udao = new UsuarioDao();
        direccion = udao.getDireccion((int) v.getIdDireccion()).getNombre();
        TarifaDao tdao = new TarifaDao();
        transporte = tdao.getTarifa(v.getIdTarifa() + "").getNombreTarifa();
        pago = udao.getMetPago((int) v.getIdMetodoPago()).getNombre();
        editable = 1 > getDifferenceDays(v.getFechaVenta(), new Date());
        hayReview=v.getIdPuntuacion()!=0;
        
        if(hayReview){
            PuntuacionDao pudao=new PuntuacionDao();
            Puntuacion pun=pudao.getPuntuacion(v.getIdPuntuacion()+"");
            for(int i =0;i<pun.getNumero();i++){
                estrellas=estrellas+"★";
            }
            comentario=pun.getResenya();
        }
        
        
        return SUCCESS;
    }

    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHastag() {
        return hastag;
    }

    public void setHastag(String hastag) {
        this.hastag = hastag;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isHayReview() {
        return hayReview;
    }

    public void setHayReview(boolean hayReview) {
        this.hayReview = hayReview;
    }

}
