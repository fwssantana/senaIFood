package br.senai.senaifood.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CriaClienteDTO {

	@NotBlank
	@Email
	private String enderecoEletronico;
	
	@NotEmpty
	private List<EnderecoDTO> enderecos;

	@NotBlank
	protected String nome;
	
	@NotEmpty
	@Size(min = 11, max = 11)
	protected String cpf;

	@NotBlank
	protected String telefone;
}
