package repositories;

import java.io.PrintWriter;
import java.util.List;

import entities.Aluno;
import interfaces.AlunoRepository;

public class AlunoRepositoryTxt implements AlunoRepository{

	@Override
	public void exportar(List<Aluno> alunos) {
		// TODO Auto-generated method stub
		try {
			var printWriter = new PrintWriter("c:\\temp\\alunos.txt");
			for(var aluno : alunos) {
				printWriter.println(aluno.getId());
				printWriter.println(aluno.getNome());
				printWriter.println(aluno.getMatricula());
			}
			printWriter.close();
		}catch(Exception e) {
			System.out.println("\nErro: "+e.getMessage());
		}
	}

}
