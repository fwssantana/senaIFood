package br.senai.senaifood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.senai.senaifood.services.PedidoService;

@RestController
public class EstabelecimentoController {

	@Autowired
	private PedidoService pedidoService;
	
}
