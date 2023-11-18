package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import DAO.CarroDao;
import entidades.Carro;

@ManagedBean
public class CarroBean {
	private Carro carro = new Carro();

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public void salvar() {
		CarroDao.salvar(carro);
	}
	
    public void removerCarro(String nome, String telefone) {
        // Lógica para verificar as informações no banco de dados
        // e remover o carro se as informações coincidirem.
        // Implemente conforme sua lógica de banco de dados.
        // Exemplo fictício:
        if (verificarInformacoesNoBanco(nome, telefone)) {
            // Remova o carro do banco de dados
            // Implemente a lógica de remoção aqui
            System.out.println("Carro removido: " + nome);
        } else {
            // Informações incorretas, trate conforme necessário
            System.out.println("Informações incorretas. Carro não removido.");
        }
    }

    private boolean verificarInformacoesNoBanco(String nome, String telefone) {
        // Implemente a lógica para verificar as informações no banco de dados.
        // Retorne true se as informações coincidirem, false caso contrário.
        // Exemplo fictício:
        return nome.equals("NomeNoBanco") && telefone.equals("TelefoneNoBanco");
    }
}
