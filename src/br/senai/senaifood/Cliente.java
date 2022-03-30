package br.senai.senaifood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente extends Pessoa {

	private String email;
	private Map<String, Endereco> enderecoPorApelido;
	
	public Cliente() {
		super(TipoPessoa.CLIENTE);
		this.enderecoPorApelido = new HashMap<String, Endereco>();
	}
	
	public Pedido realizaPedido(Estabelecimento estab, List<ItemPedido> itens, 
			String apelidoEndereco, String observacao) {
		// ! = não lógico
		if (!enderecoPorApelido.containsKey(apelidoEndereco)) {
			System.out.println("Endereço inválido");
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

	public Map<String, Endereco> getEnderecoPorApelido() {
		return enderecoPorApelido;
	}

	public void setEnderecoPorApelido(Map<String, Endereco> enderecoPorApelido) {
		this.enderecoPorApelido = enderecoPorApelido;
	}

	@Override
	public String toString() {
		return this.nome + ":" + this.email;
	}
}
