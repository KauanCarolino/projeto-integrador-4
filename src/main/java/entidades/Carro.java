package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	@GeneratedValue
	private Integer id;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private int anoModelo;
	private String valor;
	private String descricao;
	
    private boolean reservado;


	@Override
	public String toString() {
		return id + " - " + marca + " - " + modelo + " - " + anoFabricacao  + " - " + anoModelo  + " - " + valor  + " - " + descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getMarca() {
		return marca;
	}
	
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getModelo() {
		return modelo;
	}
	
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	
	
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	
	public int getAnoModelo() {
		return anoModelo;
	}
	
	
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	
	public String getValor() {
		return valor;
	}
	
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




}