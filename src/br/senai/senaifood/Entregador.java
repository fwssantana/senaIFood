package br.senai.senaifood;

import java.util.ArrayList;
import java.util.List;

public class Entregador extends Pessoa {

	private ModalidadeTransporte modalidadeTransporte;
	private List<Pedido> pedidos;

	public Entregador() {
		super(TipoPessoa.ENTREGADOR);
		this.pedidos = new ArrayList<Pedido>();
	}

	public boolean realizaEntrega(Pedido pedido) {
		boolean pagamentoBemSucedido = true;
		if (pagamentoBemSucedido) {
			pedido.setSituacao(SituacaoPedido.ENTREGUE);
			return true;
		}
		
		return false;
	}
	
	public ModalidadeTransporte getModalidadeTransporte() {
		return modalidadeTransporte;
	}

	public void setModalidadeTransporte(ModalidadeTransporte modalidadeTransporte) {
		this.modalidadeTransporte = modalidadeTransporte;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
