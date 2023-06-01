/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import Hibernate.Producto;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */
public class PublicarAction extends ActionSupport implements SessionAware {
    
    private String nombre;
    private String desc;
    private String estado;
    private float precio;
    private String hashtag;
    private SessionMap<String, Object> sessionMap;
    
    public PublicarAction() {
        
    }
    
    public String execute() throws Exception {
        Producto p = new Producto();
        //nombre, desc, estado, precio, hashtag, "usuario"
        p.setNombre(nombre);
        p.setDescripcion(desc);
        p.setEstado(estado);
        p.setPrecio(precio);
        p.setHastag(hashtag);
        Usuario u = new Usuario();
        u.setUsername((String)sessionMap.get("username"));
        p.setUsuario(u);
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
