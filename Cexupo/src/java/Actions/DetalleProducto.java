/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import Hibernate.Producto;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alber
 */
public class DetalleProducto extends ActionSupport {

    private String nombre;
    private String precio;
    private String descripcion;
    private String estado;
    private String hastag;
    private String id_usuario;
    private String id;

    public DetalleProducto() {
    }

    public String execute() throws Exception {

        ProductoDao dao = new ProductoDao();

        Producto p = dao.getProducto(Integer.parseInt(id));
        nombre = p.getNombre();
        precio = p.getPrecio()+"";
        descripcion = p.getDescripcion();
        estado = p.getEstado();
        hastag = p.getHastag();
        id_usuario = p.getUsuario().getUsername();

        return SUCCESS;
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

}
