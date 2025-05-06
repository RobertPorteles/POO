package repositories;

import java.util.UUID;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {
	ConnectionFactory connectionFactory = new ConnectionFactory();

	public void inserir(Produto produto) {
		try {
			var connection = connectionFactory.obterConexao();
			var stmt = connection.prepareStatement("insert into produto(id, nome, preco, quantidade) values(?,?,?,?)");
			stmt.setObject(1, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getQuantidade());
			stmt.execute();
			
			connection.close();
			System.out.println("\nProduto cadastro com sucesso!");
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

	public void alterar(Produto produto) {
		try {
			var connection = connectionFactory.obterConexao();
			var stmt = connection.prepareStatement("update produto set nome=?, preco=?, quantidade=? where id=?)");
			stmt.setObject(4, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(1, produto.getQuantidade());
			stmt.execute();
			
			connection.close();
			System.out.println("\nProduto cadastro com sucesso!");
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

	public void excluir(UUID id) {
		try {
			try {
				var connection = connectionFactory.obterConexao();
				var stmt = connection.prepareStatement("delete from produto where id=?S");
				stmt.setObject(1, id);
				stmt.execute();
				connection.close();
				System.out.println("\nProduto cadastro com sucesso!");
			} catch (Exception e) {
				System.out.println("\nErro: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

	public void consultar() {
		try {
			var connection = connectionFactory.obterConexao();
			var stmt = connection.prepareStatement("select * from produto");
			var result = stmt.executeQuery();
			
			while(result.next()) {
				System.out.println("ID.......: "+result.getString("id"));
				System.out.println("NOME.......: "+result.getString("nome"));
				System.out.println("PREÇO.......: "+result.getString("preco"));
				System.out.println("QUANTIDADE.......: "+result.getString("quantidade"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
