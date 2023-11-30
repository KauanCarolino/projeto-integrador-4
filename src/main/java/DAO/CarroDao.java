package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JPAUtil;
import entidades.Carro;

public class CarroDao {
	public static void salvar(Carro carro) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		em.close();
	}

	public static void atualizar(Carro carro) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(carro);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Carro carro) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		carro = em.find(Carro.class, carro.getId());
		em.remove(carro);
		em.getTransaction().commit();
		em.close();
	}

	public static Carro acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Carro a = em.find(Carro.class, id);
		em.close();
		return a;
	}

	public static List<Carro> acharTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Carro a");
		List<Carro> carros = q.getResultList();
		em.close();
		return carros;
	}

}
