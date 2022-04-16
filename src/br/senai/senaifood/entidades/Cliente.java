package br.senai.senaifood.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
	
	@Column
	private String email;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	public Cliente() {
		super(TipoPessoa.CLIENTE);
	}
	
	public Pedido realizaPedido(Estabelecimento estab, List<ItemPedido> itens, 
			String apelidoEndereco, String observacao) {
		boolean enderecoExiste = false;
		for (Endereco endereco : this.enderecos) {
			if (apelidoEndereco.equals(endereco.getApelido())) {
				enderecoExiste = true;
				break;
			}
		}
		
		if (!enderecoExiste) {
			System.out.println("Erro! Apelido não existe!");
			return null;
		}
		
		Pedido pedido = new Pedido();
		pedido.setCliente(this);
		pedido.setEntrega(true);
		pedido.setEstabelecimento(estab);
		pedido.setObservacao(observacao);
		pedido.setItens(itens);
		pedido.setApelidoEndereco(apelidoEndereco);
		
		return pedido;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return this.nome + ":" + this.email;
	}
}
