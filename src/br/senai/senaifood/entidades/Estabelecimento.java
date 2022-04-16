package br.senai.senaifood.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String cnpj;
	@Column
	private String nome;
	@Column
	private int previsaoMinima;
	@Column
	private int previsaoMaxima;
	@OneToMany(mappedBy = "estabelecimento")
	private Set<Produto> produtos;
	@OneToMany(mappedBy = "estabelecimento")
	private Set<Pedido> pedidos;
	@Column
	@Enumerated
	private CategoriaEstabelecimento categoria;
	
	public Estabelecimento() {
		this.pedidos = new HashSet<Pedido>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrevisaoMinima() {
		return previsaoMinima;
	}

	public void setPrevisaoMinima(int previsaoMinima) {
		this.previsaoMinima = previsaoMinima;
	}

	public int getPrevisaoMaxima() {
		return previsaoMaxima;
	}

	public void setPrevisaoMaxima(int previsaoMaxima) {
		this.previsaoMaxima = previsaoMaxima;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public CategoriaEstabelecimento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEstabelecimento categoria) {
		this.categoria = categoria;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void recebePedido(Pedido pedidoRealizado) {
		if (verificaAceite(pedidoRealizado)) {
			pedidoRealizado.setSituacao(SituacaoPedido.CONFIRMADO);
			this.pedidos.add(pedidoRealizado);
		} else {
			pedidoRealizado.setSituacao(SituacaoPedido.CANCELADO);
		}
	}
	
	public void enviaPedido(Pedido pedidoConcluido) {
		if (!pedidos.contains(pedidoConcluido)) {
			System.out.println("Pedido inv�lido!");
		}
		
//		Entregador entregador = App.getEntregadores().get(0);
//		entregador.getPedidos().add(pedidoConcluido);
//		pedidoConcluido.setEntregador(entregador);
		pedidoConcluido.setSituacao(SituacaoPedido.ENTREGANDO);
	}
	
	public boolean verificaAceite(Pedido pedidoRealizado) {
		return true;
	}
}
