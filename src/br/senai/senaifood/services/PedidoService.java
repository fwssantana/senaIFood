package br.senai.senaifood.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.senaifood.dto.CriaPedidoDto;
import br.senai.senaifood.entidades.Cliente;
import br.senai.senaifood.entidades.Pedido;
import br.senai.senaifood.repositorios.ClienteRepository;
import br.senai.senaifood.repositorios.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	public String criarPedido(CriaPedidoDto solicitacaoPedido) {
		Optional<Cliente> cliente = clienteRepo.findById(solicitacaoPedido.getClienteId());
		if (cliente.isPresent()) {
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente.get());
			pedido.setObservacao(solicitacaoPedido.getObservacao());
			pedido.setApelidoEndereco(solicitacaoPedido.getApelidoEndereco());
			pedido.setSituacao(solicitacaoPedido.getSituacao());
			
			pedidoRepo.save(pedido);
			
			switch (LocalDate.now().getDayOfWeek()) {
			case TUESDAY:
				return "Aproveite seu pedido nessa terça-feira!";
			default:
				return "";
			}
		}
		return "Pedido Inválido!";
	}

	public List<Pedido> listaPedidosEntreDatas(LocalDate dataInicial,
			LocalDate dataFinal) {
		Optional<List<Pedido>> pedidos = pedidoRepo.findByDataBetween(dataInicial, dataFinal);
		if (pedidos.isPresent()) {
			return pedidos.get();
		} else {
			return null;
		}
	}
	
}


// Entidades
// PedidoService = new PedidoService();