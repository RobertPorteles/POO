package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {

	public void gerenciarProdutos() {
		var scanner = new Scanner(System.in);

		
		System.out.println("1 - Cadastrar Produto \n");
		System.out.println("2 - Listar Produto\n");
		System.out.println("3 - Atualizar Produto \n");
		System.out.println("4 - Deletar Produto \n");

		System.out.println("Escolha uma opção");
		var opcao = scanner.nextLine();
		
		var produtoRepository = new ProdutoRepository();
		switch (opcao) {
		case "1":
			
			var produtoCadastro = new Produto();
			
			produtoCadastro.setId(UUID.randomUUID());
			
			System.out.println("Escolha o nome:");
			produtoCadastro.setNome(scanner.nextLine());
			
			System.out.println("Escolha o preço");
			produtoCadastro.setPreco(Double.parseDouble(scanner.nextLine()));
			
			System.out.println("Escolha a quantidade");
			produtoCadastro.setQuantidade(Integer.parseInt(scanner.nextLine()));
			
			
			produtoRepository.inserir(produtoCadastro);
			
			break;

		case "2":
			produtoRepository.consultar();
			break;
		case "3":
			break;
		case "4":
			break;
		default:
			System.out.println("\nOpção inválida!");
		}
		scanner.close();
	}
}
