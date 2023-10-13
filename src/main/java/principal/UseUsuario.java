package principal;

import java.time.LocalDate;

import DAO.UsuarioDao;
import entidades.Usuario;

public class UseUsuario {
	public static void main(String[] args) {
		//Salvando
//		Usuario a1 = new Usuario(); 
//		a1.setEmail("kauan@gmail.com");
//		a1.setSenha("123456");
//		a1.setNome("Kauan");
//		a1.setAtivo(true);
//		a1.setDataNasc("2004-08-24");
//		a1.setDataCad(LocalDate.now());
//		UsuarioDao.salvar(a1);
		
		//Editando
//		Aluno a1 = AlunoDao.acharPorId(11);
//		a1.setSemestre(6);
//		AlunoDao.atualizar(a1);
		
//		Removendo
//		Aluno a1 = AlunoDao.acharPorId(11);
//		AlunoDao.deletar(a1);
		
		//Consultando
		System.out.println(UsuarioDao.acharTodos());
	}
}
