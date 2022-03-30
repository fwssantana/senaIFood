package br.senai.senaifood;

import java.util.HashSet;
import java.util.Set;

public class Estabelecimento {

	private String cnpj;
	private String nome;
	private int previsaoMinima;
	private int previsaoMaxima;
	private Set<Produto> produtos = new HashSet<Produto>();
	private Set<Pedido> pedidos;
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
			System.out.println("Pedido inválido!");
		}
		
		Entregador entregador = App.getEntregadores().get(0);
		entregador.getPedidos().add(pedidoConcluido);
		pedidoConcluido.setEntregador(entregador);
		pedidoConcluido.setSituacao(SituacaoPedido.ENTREGANDO);
	}
	
	public boolean verificaAceite(Pedido pedidoRealizado) {
		return true;
	}
}
