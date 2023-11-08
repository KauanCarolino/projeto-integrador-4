package principal;

import java.time.LocalDate;

import DAO.UsuarioDao;
import entidades.Usuario;

public class UseUsuario {
	public static void main(String[] args) {
		//Salvando
		Usuario a1 = new Usuario(); 
		a1.setAtivo(true);
		a1.setDataCad(LocalDate.now());
		UsuarioDao.salvar(a1);
		
		//Editando
		Usuario a2 = UsuarioDao.acharPorId(1);
		a2.setSenha("1");
		UsuarioDao.atualizar(a2);
		
		//Removendo
		Usuario a3 = UsuarioDao.acharPorId(1);
		UsuarioDao.deletar(a3);
		
		//Consultando
		System.out.println(UsuarioDao.acharTodos());
	}
}
