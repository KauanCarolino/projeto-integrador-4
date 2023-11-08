package bean;

import javax.faces.bean.ManagedBean;

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
}
