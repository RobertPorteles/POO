package repositories;

import java.io.PrintWriter;
import java.util.List;

import entities.Aluno;
import interfaces.AlunoRepository;

public class AlunoRepositoryXml implements AlunoRepository{

	@Override
	public void exportar(List<Aluno> alunos) {
		try {
			var printWriter = new PrintWriter("c:\\temp\\alunos.xml");
            printWriter.println("<?xml version='1.0' encoding='ISO-8859-1'?>");
            printWriter.println("<Alunos>"); // Abre a lista de alunos

            for (Aluno aluno : alunos) {
                printWriter.println("  <Aluno>");
                printWriter.println("    <Id>" + aluno.getId() + "</Id>");
                printWriter.println("    <Nome>" + aluno.getNome() + "</Nome>");
                printWriter.println("    <Matricula>" + aluno.getMatricula() + "</Matricula>");
                printWriter.println("  </Aluno>");
            }

            printWriter.println("</Alunos>"); // Fecha a lista de alunos
            printWriter.close();
		}catch(Exception e) {
			System.out.println("\nErro: "+e.getMessage());
		}
		
	}

}
