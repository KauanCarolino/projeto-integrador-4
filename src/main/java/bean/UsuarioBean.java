package bean;
import bean.UsuarioBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import DAO.UsuarioDao;
import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
		
    private String novaSenha;
    private String confirmaSenha;
    
    private List<Usuario> listaUsuario;

    public UsuarioBean() {
        listaUsuario = UsuarioDao.acharTodos();
    }

	public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

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
		System.out.println("Antes de chamar UsuarioDao.validarLogin");
		Usuario usuarioValidado = UsuarioDao.validarLogin(usuario.getEmail(), usuario.getSenha());
		System.out.println("Depois de chamar UsuarioDao.validarLogin");


	    if (usuarioValidado != null) {
	        // Login válido, redirecionar para a página de boas-vindas
	        FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("usuarioLogado", usuarioValidado);
            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(context, null, "loginSucesso");

            System.out.println("Login Efetuado");
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
            
        }
        return "loginUsuario";
    }
    
    
	public String validarEmailEDataNasc() {
    	System.out.println("Iniciando a validação.");
	    Usuario usuarioValidado = UsuarioDao.validarEmailEDataNasc(usuario.getEmail(), usuario.getDataNasc());
        System.out.println("Resultado da validação: " + usuarioValidado);
	    
        if (usuarioValidado != null) {
	        FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("usuarioLogado", usuarioValidado);
            return "RecuperarSenha";
//            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
//	        navigationHandler.handleNavigation(context, null, "RecuperarSenha.xhtml");	        
	    } else {
	        // Login inválido, exibir mensagem de erro
	        FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validação inválida", "Email ou Data Nascimento incorretos"));
	        return null;
	    }
	}
    

	public String atualizarSenha() {
	    // Obtém o usuário da sessão
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

	    if (usuarioLogado != null) {
	        // Verifica se a nova senha e a confirmação de senha coincidem
	        if (novaSenha.equals(confirmaSenha)) {
	            // Atualiza a senha do usuário
	            usuarioLogado.setSenha(novaSenha);
	            
	            // Chama o método para atualizar o usuário no banco de dados
	            UsuarioDao.atualizar(usuarioLogado);
	            
	            // Redireciona para alguma página de sucesso
	            // Você pode definir a página de sucesso desejada
	            return "LoginUsuario";
//	            NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
//	            navigationHandler.handleNavigation(context, null, "atualizacaoSenhaSucesso"); // Substitua "atualizacaoSenhaSucesso" pela página desejada
	        } else {
	            // Senha e confirmação de senha não coincidem, exibe mensagem de erro
	            FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha e confirmação de senha não coincidem", null));
	            return null;
	        }
	    } else {
	    	return null;
	        // Usuário não está na sessão, trate isso de acordo com seus requisitos
	        // Você pode redirecionar para a página de login ou fazer qualquer outra ação necessária
	    }
	}
	


}
