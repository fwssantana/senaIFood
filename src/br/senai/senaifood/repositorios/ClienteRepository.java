package br.senai.senaifood.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.senaifood.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public Optional<Cliente> findById(Long id);
	public Optional<Cliente> findByEmailAndCpf(String param1, 
			String param2);
	
}
