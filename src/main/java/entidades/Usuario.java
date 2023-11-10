package entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id = 0;
	private String email;
	private String senha;
	@Column(name = "nome_completo")
	private String nome;
	private String telefone;
	private boolean ativo = true;
	private String dataNasc;
	private LocalDate dataCad = LocalDate.now();
	
	@Override
	public String toString() {
		return id + " - " + nome + " - " + email + " - " + senha  + " - " + ativo  + " - " + dataNasc  + " - " + dataCad;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public LocalDate getDataCad() {
		return dataCad;
	}
	public void setDataCad(LocalDate dataCad) {
		this.dataCad = dataCad;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
