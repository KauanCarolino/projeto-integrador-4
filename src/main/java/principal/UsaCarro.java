package principal;

import DAO.CarroDao;

public class UsaCarro {
	public static void main(String[] args) {
		// Salvando
//		Carro c1 = new Carro(); 
//		c1.setMarca("Ford");
//		c1.setModelo("Mustang");
//		c1.setAnoFabricacao(2020);
//		c1.setAnoModelo(2019);
//		c1.setValor("150.000");
//		c1.setDescricao("Carro de luxo para quem tem dinheiro");
//		CarroDao.salvar(c1);

		// Editando
//		Usuario a1 = UsuarioDao.acharPorId(1);
//		a1.setSenha("4567");
//		UsuarioDao.atualizar(a1);

//		Removendo
//		Usuario a1 = UsuarioDao.acharPorId(1);
//		UsuarioDao.deletar(a1);

		// Consultando
		System.out.println(CarroDao.acharTodos());
	}
}
