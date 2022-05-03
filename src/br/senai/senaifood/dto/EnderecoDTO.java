package br.senai.senaifood.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnderecoDTO {

	@NotBlank
	private String endereco;
	private String complemento;
	@NotBlank
	private String cep;
	@NotBlank
	private String apelido;
}
