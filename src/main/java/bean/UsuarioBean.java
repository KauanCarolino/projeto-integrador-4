package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;
import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.primefaces.PrimeFaces;

import DAO.UsuarioDao;
import Util.JPAUtil;
import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void salvar() {
		UsuarioDao.salvar(usuario);
	}
	
	public void validarLogin() {
	    Usuario usuarioValidado = UsuarioDao.validarLogin(usuario.getEmail(), usuario.getSenha());

	    if (usuarioValidado != null) {
	        // Login válido, redirecionar para a página de boas-vindas
	        FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("usuarioLogado", usuarioValidado);
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	        navigationHandler.handleNavigation(context, null, "loginSucesso"); // "loginSucesso" é o outcome definido no faces-config.xml
	    } else {
	        // Login inválido, exibir mensagem de erro
	        FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", "Email ou senha incorretos"));
	    }
	}
	
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        if (session != null) {
            session.removeAttribute("usuarioLogado");
            session.invalidate();
            return "Cadastro-Login/LoginUsuario.xhtml";
        }
        return "Cadastro-Login/LoginUsuario.xhtml";
    }

}
