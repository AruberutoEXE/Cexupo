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
import Hibernate.Direccion;
import Hibernate.Metodopago;
import Hibernate.Producto;
import Hibernate.Puntuacion;
import Hibernate.Tarifaenvio;
import Hibernate.Usuario;
import Hibernate.Venta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author alber
 */
public class DetallesVenta extends ActionSupport implements SessionAware  {

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
    private List<String> direcciones;
    private List<String> transportes;
    private List<String> pagos;
    private List<String> dirid;
    private List<String> tranid;
    private List<String> pagosid;

    public DetallesVenta() {
    }
    private SessionMap<String, Object> sessionMap;

    public String execute() throws Exception 
        {

        ProductoDao dao = new ProductoDao();
        ProductoDao pdao = new ProductoDao();
        List<String> tarifas = new LinkedList<String>();
        List<String> traList = new LinkedList<String>();
        List<Tarifaenvio> t = pdao.getAllTarifas();
        for (int i = 0; i < t.size(); i++) {
            tarifas.add(t.get(i).getNombreTarifa());
            traList.add(t.get(i).getId() + "");
            System.out.println(t.get(i).getId());
        }
        transportes = tarifas;
        tranid = traList;
        UsuarioDao udao = new UsuarioDao();
        List<String> dir = new LinkedList<String>();
        List<String> dirList = new LinkedList<String>();
        Usuario usu = udao.getUser((String) sessionMap.get("username"));
        List<Direccion> dirlist = udao.getAllUserDirections(usu);
        for (int i = 0; i < dirlist.size(); i++) {
            dir.add(dirlist.get(i).getNombre());
            dirList.add(dirlist.get(i).getId() + "");
            System.out.println(dirlist.get(i).getId());
        }
        direcciones = dir;
        dirid = dirList;

        List<String> pay = new LinkedList<String>();
        List<String> payList = new LinkedList<String>();
        List<Metodopago> paylist = udao.getAllUserPayMethods(usu);
        for (int i = 0; i < paylist.size(); i++) {
            pay.add(paylist.get(i).getNombre());
            payList.add(paylist.get(i).getId() + "");
            System.out.println(paylist.get(i).getId());
        }
        pagos = pay;
        pagosid = payList;
        Producto p = dao.getProducto(Integer.parseInt(id));
        nombre = p.getNombre();
        precio = p.getPrecio() + "";
        descripcion = p.getDescripcion();
        estado = p.getEstado();
        hastag = p.getHastag();
        id_usuario = p.getUsuario().getUsername();
        VentaDao vdao = new VentaDao();
        Venta v = vdao.getVenta(p.getId() + "");
        direccion = udao.getDireccion((int) v.getIdDireccion()).getNombre();
        TarifaDao tdao = new TarifaDao();
        transporte = tdao.getTarifa(v.getIdTarifa() + "").getNombreTarifa();
        pago = udao.getMetPago((int) v.getIdMetodoPago()).getNombre();
        editable = 1 > getDifferenceDays(v.getFechaVenta(), new Date());
        hayReview = v.getIdPuntuacion() != 0;

        if (hayReview) {
            PuntuacionDao pudao = new PuntuacionDao();
            Puntuacion pun = pudao.getPuntuacion(v.getIdPuntuacion() + "");
            for (int i = 0; i < pun.getNumero(); i++) {
                estrellas = estrellas + "★";
            }
            comentario = pun.getResenya();
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

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }

    public List<String> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<String> transportes) {
        this.transportes = transportes;
    }

    public List<String> getPagos() {
        return pagos;
    }

    public void setPagos(List<String> pagos) {
        this.pagos = pagos;
    }

    public List<String> getDirid() {
        return dirid;
    }

    public void setDirid(List<String> dirid) {
        this.dirid = dirid;
    }

    public List<String> getTranid() {
        return tranid;
    }

    public void setTranid(List<String> tranid) {
        this.tranid = tranid;
    }

    public List<String> getPagosid() {
        return pagosid;
    }

    public void setPagosid(List<String> pagosid) {
        this.pagosid = pagosid;
    }
}
