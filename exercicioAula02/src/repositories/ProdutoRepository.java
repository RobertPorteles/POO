package repositories;

import java.io.PrintWriter;

import entitites.Produto;

public class ProdutoRepository {
	public void cadastrarProduto(Produto prod) {
		// Lógica para cadastrar o produto
		try (PrintWriter printWriter = new PrintWriter("Produto_" + prod.getId() + ".xml")) {
			printWriter.println("<?xml version='1.0' encoding='UTF-8'?>");
			printWriter.println("<produto>");

			printWriter.println("<id>" + prod.getId() + "</id>");
			printWriter.println("<nome>" + prod.getNome() + "</nome>");
			printWriter.println("<descricao>" + prod.getDescricao() + "</descricao>");

			printWriter.println("<preco>" + prod.getPreco() + "</preco>");
			printWriter.println("<quantidade>" + prod.getQuantidade() + "</quantidade>");
			printWriter.println("<categoria>");
			printWriter.println("<id>" + prod.getCategoria().getId() + "</id>");
			printWriter.println("<codigo>" + prod.getCategoria().getCodigo() + "</codigo>");
			printWriter.println("<nome>" + prod.getCategoria().getNome() + "</nome>");
			printWriter.println("<descricao>" + prod.getCategoria().getDescricao() + "</descricao>");
			printWriter.println("</categoria>");
			printWriter.println("</produto>");
			printWriter.close();
			System.out.println("Produto exportado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar produto: " + e.getMessage());
		}
	}
}
