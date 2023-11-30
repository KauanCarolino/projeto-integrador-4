package principal;

import DAO.UsuarioDao;

public class UseUsuario {
	public static void main(String[] args) {
		// Salvando
//		Usuario a1 = new Usuario(); 
//		a1.setAtivo(true);
//		a1.setDataCad(LocalDate.now());
//		UsuarioDao.salvar(a1);

		// Editando
//		Usuario a1 = UsuarioDao.acharPorId(1);
//		a1.setSenha("4567");
//		UsuarioDao.atualizar(a1);

//		Removendo
//		Usuario a1 = UsuarioDao.acharPorId(1);
//		UsuarioDao.deletar(a1);

		// Consultando
		System.out.println(UsuarioDao.acharTodos());
	}
}
