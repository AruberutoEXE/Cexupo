/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import Hibernate.Producto;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Usuario
 */
public class UpdateProductoAction extends ActionSupport {

    private String id;
    private String nombre;
    private float precio;
    private String descripcion;
    private String hastag;
    private String estado;

    public UpdateProductoAction() {
    }

    public String execute() throws Exception {
        ProductoDao pDao = new ProductoDao();
        Producto p = pDao.getProducto(Integer.parseInt(id));
        if (this.nombre != p.getNombre()) {
            p.setNombre(this.nombre);
        }
        if(this.descripcion != p.getDescripcion()){
            p.setDescripcion(this.descripcion);
        }
        if(this.precio != p.getPrecio()){
            p.setPrecio(this.precio);
        }
        if(this.hastag != p.getHastag()){
            p.setHastag(this.hastag);
        }
        if(this.estado != p.getEstado()){
            p.setEstado(this.estado);
        }
        pDao.updateProducto(p);
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHastag() {
        return hastag;
    }

    public void setHastag(String hastag) {
        this.hastag = hastag;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
