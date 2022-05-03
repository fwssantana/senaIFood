package br.senai.senaifood.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.senaifood.dto.CriaClienteDTO;
import br.senai.senaifood.dto.EnderecoDTO;
import br.senai.senaifood.entidades.Cliente;
import br.senai.senaifood.entidades.Endereco;
import br.senai.senaifood.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;

	public void cadastraCliente(CriaClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEmail(clienteDTO.getEnderecoEletronico());
		cliente.setEnderecos(new ArrayList<Endereco>());
		
		for (EnderecoDTO enderecoDTO : clienteDTO.getEnderecos()) {
			Endereco endereco = new Endereco();
			endereco.setApelido(enderecoDTO.getApelido());
			endereco.setCep(enderecoDTO.getCep());
			endereco.setComplemento(enderecoDTO.getComplemento());
			endereco.setEndereco(enderecoDTO.getEndereco());
			endereco.setCliente(cliente);
		}
		cliente.setTelefone(clienteDTO.getTelefone());
		
		this.clienteRepo.save(cliente);
	}

	public Optional<Cliente> obtemCliente(long clienteId) {
		return this.clienteRepo.findById(clienteId);
	}

}
