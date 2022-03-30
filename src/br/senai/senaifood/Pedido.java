package br.senai.senaifood;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<ItemPedido> itens;
	private Cliente cliente;
	private Estabelecimento estabelecimento;
	private LocalDateTime data;
	private String observacao;
	private String apelidoEndereco;
	private SituacaoPedido situacao;
	private boolean entrega;
	private Entregador entregador;

	public Pedido() {
		this.itens = new ArrayList<ItemPedido>();
		this.data = LocalDateTime.now();
		this.situacao = SituacaoPedido.PENDENTE;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double calculaValor() {
		double valor = 0;
		for (ItemPedido itemPedido : itens) {
			valor += itemPedido.getQuantidade() 
					* itemPedido.getProduto().getValor();
		}
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getApelidoEndereco() {
		return apelidoEndereco;
	}

	public void setApelidoEndereco(String apelidoEndereco) {
		this.apelidoEndereco = apelidoEndereco;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public boolean isEntrega() {
		return entrega;
	}

	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
}
