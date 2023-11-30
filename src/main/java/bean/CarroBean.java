package bean;

import java.util.List;

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
    
    public void lista() {
		CarroDao.acharTodos();
	}

    public String getMarcaCarro() {
        return carro.getMarca();
    }
    
    public String getModeloCarro() {
        return carro.getModelo();
    }

    public String getValorCarro() {
        return carro.getValor();
    }
}    

