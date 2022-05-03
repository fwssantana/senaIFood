package br.senai.senaifood.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.senai.senaifood.dto.CriaPedidoDto;
import br.senai.senaifood.entidades.Pedido;
import br.senai.senaifood.services.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/pedido/")
	public ResponseEntity salvaPedido(@RequestBody CriaPedidoDto pedido) {
		String retornoPedido = this.pedidoService.criarPedido(pedido);
		return new ResponseEntity<>(retornoPedido, HttpStatus.CREATED);
	}

	@GetMapping("/pedido/{d1}/{d2}")
	public ResponseEntity listaPedidos(@PathVariable String d1, @PathVariable String d2) {
		LocalDate dataInicial = LocalDate.parse(d1);
		LocalDate dataFinal = LocalDate.parse(d2);

		List<Pedido> pedidos = pedidoService.listaPedidosEntreDatas(dataInicial, dataFinal);
		if (pedidos.size() <= 0) {
			return new ResponseEntity<>("Erro!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(pedidos, HttpStatus.OK);
		}
	}

	@GetMapping("/pedido/{mes}")
	public ResponseEntity listaPedidos(@PathVariable String mes) {
		LocalDate dataInicial = LocalDate.now();
		LocalDate dataFinal;

		if (mes.equalsIgnoreCase("jan")) {
			dataInicial = LocalDate.of(dataInicial.getYear(), 1, 1);
			dataFinal = LocalDate.of(dataInicial.getYear(), 1, 31);
		} else if (mes.equalsIgnoreCase("fev")) {
			dataInicial = LocalDate.of(dataInicial.getYear(), 2, 1);
			dataFinal = LocalDate.of(dataInicial.getYear(), 2, 28);
		} else if (mes.equalsIgnoreCase("mar")) {
			dataInicial = LocalDate.of(dataInicial.getYear(), 3, 1);
			dataFinal = LocalDate.of(dataInicial.getYear(), 3, 31);
		} else if (mes.equalsIgnoreCase("abr")) {
			dataInicial = LocalDate.of(dataInicial.getYear(), 4, 1);
			dataFinal = LocalDate.of(dataInicial.getYear(), 4, 30);
		} else {
			dataInicial = LocalDate.of(dataInicial.getYear(), 5, 1);
			dataFinal = LocalDate.of(dataInicial.getYear(), 5, 31);
		}

		List<Pedido> pedidos = pedidoService.listaPedidosEntreDatas(dataInicial, dataFinal);
		return new ResponseEntity<>(pedidos.size(), HttpStatus.OK);
	}

}
