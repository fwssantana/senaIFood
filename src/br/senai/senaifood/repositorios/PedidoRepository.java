package br.senai.senaifood.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.senaifood.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	public Optional<List<Pedido>> findByDataBetween(LocalDate d1, LocalDate d2);
	
}
