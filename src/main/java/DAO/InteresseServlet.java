package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Carro;
import entidades.Usuario;  // Importe a classe Usuario
import Util.JPAUtil;

public class InteresseServlet {

    public static void demonstrarInteresse(Carro carro, Usuario usuario) {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            em.getTransaction().begin();

            // Acessando os dados do usuário
            String nomeUsuario = usuario.getNome();
            String telefoneUsuario = usuario.getTelefone();

            // Atualizar informações de interesse no carro
            carro.setInteresseDemonstrado(true);
            carro.setNomeInteressado(nomeUsuario);
            carro.setTelefoneInteressado(telefoneUsuario);

            // Atualizar o carro no banco de dados
            em.merge(carro);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static List<Carro> acharCarrosDisponiveis() {
        EntityManager em = JPAUtil.criarEntityManager();
        try {
            // Consultar apenas carros disponíveis
            Query q = em.createQuery("select c from Carro c where c.interesseDemonstrado = false", Carro.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
		
	}
}
