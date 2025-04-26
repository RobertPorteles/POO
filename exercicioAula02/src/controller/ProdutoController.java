package controller;

import javax.swing.JOptionPane;

import entitites.Categoria;
import entitites.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {
	public void cadastrarProduto() {

		try {
			// Criando a categoria
			var categoria = new Categoria();
			categoria.setId(java.util.UUID.randomUUID());
			categoria.setDescricao(JOptionPane.showInputDialog("Digite a descrição da categoria"));
			categoria.setNome(JOptionPane.showInputDialog("Digite o nome da categoria"));
			categoria.setCodigo(JOptionPane.showInputDialog("Digite o código da categoria"));
			// Criando o produto
			var produto = new Produto();
			produto.setId(java.util.UUID.randomUUID());
			produto.setDescricao(JOptionPane.showInputDialog("Digite a descrição do produto"));
			produto.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
			produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto")));
			produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto")));
			
			produto.setCategoria(categoria);
			var ProdutoRepository = new ProdutoRepository();
			ProdutoRepository.cadastrarProduto(produto);
			

		} catch (Exception e) {

		}

	}

}
