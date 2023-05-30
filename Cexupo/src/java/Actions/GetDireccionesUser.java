/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.UsuarioDao;
import Hibernate.Direccion;
import Hibernate.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class GetDireccionesUser extends ActionSupport {
    
    public GetDireccionesUser() {
    }
    private String idUsuario;
    private String nombre;
    private Integer cp;
    private String direccion;
    private Integer id;
    private List<Direccion> usuarios;
    private Usuario u;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String execute() throws Exception {
        UsuarioDao uDao=new UsuarioDao();
        usuarios = uDao.getAllUserDirections(u);
        return SUCCESS;
    
    }

    public List<Direccion> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Direccion> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
    
}
