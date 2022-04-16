package br.senai.senaifood.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany
	private List<ItemPedido> itens;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Estabelecimento estabelecimento;
	@Column(name = "dataPedido")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date data;
	@Column(length = 30)
	private String observacao;
	@Column
	private String apelidoEndereco;
	@Column
	@Enumerated(value = EnumType.ORDINAL)
	private SituacaoPedido situacao;
	@Column
	private boolean entrega;
	@ManyToOne
	private Entregador entregador;

	public Pedido() {
		this.itens = new ArrayList<ItemPedido>();
		this.data = new Date();
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

	public Date getData() {
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
