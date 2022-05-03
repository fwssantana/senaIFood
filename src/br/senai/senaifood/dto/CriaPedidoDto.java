package br.senai.senaifood.dto;

import java.time.LocalDate;

import br.senai.senaifood.entidades.SituacaoPedido;
import lombok.Data;

@Data
public class CriaPedidoDto {

	private Long clienteId;
	private LocalDate data;
	private String observacao;
	private String apelidoEndereco;
	private SituacaoPedido situacao;
	
}
