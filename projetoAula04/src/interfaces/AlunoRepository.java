package interfaces;

import java.util.List;

import entities.Aluno;

public interface AlunoRepository {
	void exportar(List<Aluno> alunos);
}
