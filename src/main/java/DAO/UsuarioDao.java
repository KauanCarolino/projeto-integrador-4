package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import entidades.Usuario;
import Util.JPAUtil;

public class UsuarioDao {	
	public static void salvar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static void atualizar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static void deletar(Usuario usuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		usuario = em.find(Usuario.class, usuario.getId());
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Usuario acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Usuario a = em.find(Usuario.class, id);
		em.close();
		return a;
	}
	
	
	public static Usuario recuperarSenha(String email, String dataNasc) {
	    EntityManager em = JPAUtil.criarEntityManager();
	    Usuario usuario = em.createQuery("SELECT a FROM Usuario a WHERE a.email = :email AND a.dataNasc = :dataNasc", Usuario.class)
	                        .setParameter("email", email)
	                        .setParameter("dataNasc", dataNasc)
	                        .getSingleResult();
	    em.close();
	    return usuario;
	}
	
	
	public static Usuario validarLogin(String email, String senha) {
	    EntityManager em = JPAUtil.criarEntityManager();
	    try {
	        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class)
	                .setParameter("email", email)
	                .setParameter("senha", senha);
	        
	        Usuario usuario = query.getSingleResult();
	        return usuario;
	    } catch (NoResultException e) {
	        return null; // Retorna null se nenhum usuário correspondente for encontrado
	    } finally {
	        em.close();
	    }
	}
	



	
	public static List<Usuario> acharTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Usuario a");
		List<Usuario> usuarios = q.getResultList();
		em.close();
		return usuarios;
	}
	

}
