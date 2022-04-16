package br.senai.senaifood.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.senaifood.entidades.Cliente;
import br.senai.senaifood.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;

	public void cadastraCliente(Cliente cliente) {
		this.clienteRepo.save(cliente);
	}

	public Optional<Cliente> obtemCliente(long clienteId) {
		return this.clienteRepo.findById(clienteId);
	}

}
