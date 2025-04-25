package controller;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Professor;
import repositories.Repository;

public class TurmaController {

	public void CadastrarTurma() {
		try {
			Professor professor = new Professor();
			professor.getTurma().setId(UUID.randomUUID());
			professor.getTurma().setNome(JOptionPane.showInputDialog("Digite o nome da turma"));
			professor.getTurma().setPeriodo(JOptionPane.showInputDialog("Digite o periodo da turma"));
			professor.getTurma().setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Digite a data de inicio da turma")));
			
			professor.setId(UUID.randomUUID());
			professor.setNome(JOptionPane.showInputDialog("Digite o nome do professor"));
			professor.setEmail(JOptionPane.showInputDialog("Digite o email do professor"));
			professor.setTelefone(JOptionPane.showInputDialog("Digite o telefone do professor"));
			
			professor.getCurso().setCodigo(UUID.randomUUID());
			professor.getCurso().setNome(JOptionPane.showInputDialog("Digite o nome do curso"));
			professor.getCurso().setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horaria do curso")));
			
			
			var salva = new Repository();
			salva.exportar(professor);
			System.out.println("Turma cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar turma");
			e.printStackTrace();
		}

	}

}
