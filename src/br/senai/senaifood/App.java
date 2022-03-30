package br.senai.senaifood;

import java.util.ArrayList;
import java.util.List;

public class App {

	private static List<Entregador> entregadores;
	
	public static List<Entregador> getEntregadores() {
		if (entregadores == null) {
			Entregador entreg1 = new Entregador();
			entreg1.setCpf("11111");
			entreg1.setModalidadeTransporte(ModalidadeTransporte.BICICLETA);
			entreg1.setNome("Francisco");
			entreg1.setTelefone("11111");
			
			Entregador entreg2 = new Entregador();
			entreg2.setCpf("222");
			entreg2.setModalidadeTransporte(ModalidadeTransporte.MOTO);
			entreg2.setNome("Francisco 2");
			entreg2.setTelefone("2222");
			
			App.entregadores = new ArrayList<Entregador>();
			App.entregadores.add(entreg1);
			App.entregadores.add(entreg2);
		}
		return App.entregadores;
	}

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Francisco");
		cliente.setEmail("francisco.santana@edu.sc.senai.br");
		cliente.setCpf("1111111111");
		cliente.setTelefone("21982856985");

		Endereco enderecoFrancisco = new Endereco();
		enderecoFrancisco.setCep("88015010");
		enderecoFrancisco.setEndereco("aaaaa");
		enderecoFrancisco.setComplemento("101");
		
		Endereco enderecoFrancisco2 = new Endereco();
		enderecoFrancisco2.setCep("88015111");
		enderecoFrancisco2.setEndereco("bbbbb");
		enderecoFrancisco2.setComplemento("n 404");
		
		cliente.getEnderecoPorApelido().put("casa", enderecoFrancisco);
		cliente.getEnderecoPorApelido().put("casa2", enderecoFrancisco2);
		
		Estabelecimento restaurante1 = new Estabelecimento();
		restaurante1.setCategoria(CategoriaEstabelecimento.RESTAURANTE);
		restaurante1.setCnpj("111111111");
		restaurante1.setPrevisaoMaxima(45);
		restaurante1.setPrevisaoMinima(25);

		Produto produto = new Produto();
		produto.setCategoria(CategoriaProduto.ALIMENTO);
		produto.setDescricao("O melhor sushi de florianopolis!");
		produto.setDisponivel(true);
		produto.setNome("Sushi");
		produto.setValor(40.0);
		
		restaurante1.getProdutos().add(produto);
		
		ItemPedido meuSushi = new ItemPedido();
		meuSushi.setProduto(produto);
		meuSushi.setQuantidade(2);
		
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(meuSushi);
		
		Pedido pedidoRealizado = cliente.realizaPedido(restaurante1, itens, "casa", "sem descartáveis!");
		if (pedidoRealizado != null) {
			pedidoRealizado.getEstabelecimento().recebePedido(pedidoRealizado);
			restaurante1.enviaPedido(pedidoRealizado);
			pedidoRealizado.getEntregador().realizaEntrega(pedidoRealizado);
			System.out.println("Pedido entregue!");
			System.out.println(pedidoRealizado.calculaValor());
		}
		
	}
	
}
