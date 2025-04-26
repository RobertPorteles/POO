package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
	
	//Injeção de dependncia^
	@Autowired UsuarioService usuarioService;
	
	
	@PostMapping("autenticar")
	public void autenticar() throws Exception{
	//TODO Implementar autenticar	
	}
	
	@PostMapping("criar")
	public String criar(CriarUsuarioRequest request) throws Exception{		
			return usuarioService.criarUsuario(request);
	}		
	
}
