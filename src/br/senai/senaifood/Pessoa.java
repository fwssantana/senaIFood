package br.senai.senaifood;

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String telefone;
	private TipoPessoa tipo;
	
	public Pessoa(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public TipoPessoa getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return nome + ":" + telefone;
	}
}
