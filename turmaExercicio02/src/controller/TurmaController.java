package controller;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Curso;
import entities.Professor;
import entities.Turma;
import repositories.Repository;

public class TurmaController {

	public void CadastrarTurma() {
		try {
			
			Turma turma = new Turma();
			turma.setId(UUID.randomUUID());
			turma.setNome(JOptionPane.showInputDialog("Nome da turma:"));
			turma.setPeriodo(JOptionPane.showInputDialog("Período da turma:"));
			turma.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de início da turma (dd/MM/yyyy):")));
			
			turma.setProfessor(new Professor());
			turma.getProfessor().setId(UUID.randomUUID());
			turma.getProfessor().setNome(JOptionPane.showInputDialog("Nome do professor:"));
			turma.getProfessor().setEmail(JOptionPane.showInputDialog("Email do professor:"));
			turma.getProfessor().setTelefone(JOptionPane.showInputDialog("Telefone do professor:"));
			
			turma.setCurso(new Curso());
			turma.getCurso().setCodigo(UUID.randomUUID());
			turma.getCurso().setNome(JOptionPane.showInputDialog("Nome do curso:"));
			turma.getCurso().setCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog("Carga horária do curso:")));
			
			// Salvar turma
			
			var salva = new Repository();
			salva.exportar(turma);
			
			System.out.println("Turma cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar turma");
			e.printStackTrace();
		}

	}

}
