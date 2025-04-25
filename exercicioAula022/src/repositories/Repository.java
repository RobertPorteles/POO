package repositories;

import java.io.PrintWriter;

import entities.Professor;

public class Repository {
	public void exportar(Professor salvar) {
		try {

			var printWriter = new PrintWriter("Turma_" + salvar.getId() + ".xml");
			
			printWriter.println("<?xml version='1.0' encoding='UTF-8'?>");
			printWriter.println("<turma>");
			printWriter.println("<id>" + salvar.getTurma().getId() + "</id>");
			printWriter.println("<nome>" + salvar.getTurma().getNome() + "</nome>");
			printWriter.println("<dataInicio>" + salvar.getTurma().getDataInicio() + "</dataInicio>");
			
			printWriter.println("<professor>");
			printWriter.println("<id>" + salvar.getId() + "</id>");
			printWriter.println("<nome>" + salvar.getNome() + "</nome>");
			printWriter.println("<email>" + salvar.getEmail() + "</email>");
			printWriter.println("<telefone>" + salvar.getTelefone() + "</telefone>");
			printWriter.println("</professor>");
			
			printWriter.println("<curso>");
			printWriter.println("<codigo>" + salvar.getCurso().getCodigo() + "</codigo>");
			printWriter.println("<nome>" + salvar.getCurso().getNome() + "</nome>");
			printWriter.println("<cargaHoraria>" + salvar.getCurso().getCargaHoraria() + "</cargaHoraria>");
			printWriter.println("</curso>");

			printWriter.println("</turma>");

			printWriter.close();
			System.out.println("\nTurma exportada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao exportar");
			e.printStackTrace();
		}
	}
}
