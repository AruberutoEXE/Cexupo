package Actions;
import DAO.UsuarioDao;
import usuarioService.Metodopago;
import usuarioService.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class GetPaymentMethods extends ActionSupport implements SessionAware {

    public GetPaymentMethods() {
    }
    private SessionMap<String, Object> sessionMap;

    private List<Metodopago> metodoPago;

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Metodopago> getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(List<Metodopago> metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String execute() throws Exception {

        UsuarioDao udao = new UsuarioDao();

        Usuario usu = udao.getUser((String) sessionMap.get("username"));
        metodoPago = udao.getAllUserPayMethods(usu);

        return SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

}
