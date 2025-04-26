package br.com.cotiinformatica.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.CriarUsuarioRequest;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	//Injeção de dependência do repositorio de usuários.
	@Autowired UsuarioRepository usuarioRepository;
	//Método para realizar o cadastro de um novo usuário
	public String criarUsuario(CriarUsuarioRequest request) {
		var usuario = new Usuario();
		usuario.setId(UUID.randomUUID());
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(request.getSenha());
		
		usuarioRepository.save(usuario);
		return "Usuário cadastrado com Sucesso!";
	}
}
