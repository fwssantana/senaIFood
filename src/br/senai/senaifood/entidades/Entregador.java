package br.senai.senaifood.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Entregador extends Pessoa {

	@Column
	@Enumerated
	private ModalidadeTransporte modalidadeTransporte;

	public Entregador() {
		super(TipoPessoa.ENTREGADOR);
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

}
