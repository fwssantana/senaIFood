package br.senai.senaifood.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.senai.senaifood.entidades.Cliente;
import br.senai.senaifood.services.ClienteService;
import br.senai.senaifood.services.PedidoService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/cliente/")
	public void salvaCliente(@Valid @RequestBody Cliente cliente) {
		this.clienteService.cadastraCliente(cliente);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> obtemCliente(@PathVariable String id) {
		Optional<Cliente> cliente = this.clienteService.obtemCliente(Long.parseLong(id));
		return ResponseEntity.of(cliente);
	}
}
