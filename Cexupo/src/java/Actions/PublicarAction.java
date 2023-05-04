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
 * @author Usuario
 */
public class PublicarAction extends ActionSupport {
    
    private String nombre;
    private String desc;
    private String estado = "publicado";
    private String precio;
    private String hashtag;
    
    public PublicarAction() {
        
    }
    
    public String execute() throws Exception {
        Producto p = new Producto(nombre, desc, estado, precio, hashtag, "usuario");
        ProductoDao pDAO = new ProductoDao();
        pDAO.addProducto(p);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
