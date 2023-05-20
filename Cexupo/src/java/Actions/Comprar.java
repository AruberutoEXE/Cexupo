/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProductoDao;
import DAO.UsuarioDao;
import Hibernate.Direccion;
import Hibernate.Tarifaenvio;
import com.opensymphony.xwork2.ActionSupport;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alber
 */
public class Comprar extends ActionSupport {

    public Comprar() {
    }

    private String producto;

    List<String> direcciones;
    List<String> transportes;
    List<String> pagos;

    public String execute() throws Exception {
        ProductoDao pdao= new ProductoDao();
        List<String> tarifas=new LinkedList<String>();
        List<Tarifaenvio> t=pdao.getAllTarifas();
        for(int i=0;i<t.size();i++ ){
            tarifas.add(t.get(i).getNombreTarifa());
        }
        transportes = tarifas;
        
        UsuarioDao udao=new UsuarioDao();
        List<String> dir=new LinkedList<String>();
        List<Direccion> dirlist=udao.getAllUserDirections();
        for(int i=0;i<dirlist.size();i++ ){
            dir.add(dirlist.get(i).getNombre());
        }
        direcciones=dir;
        
        return SUCCESS;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

}
