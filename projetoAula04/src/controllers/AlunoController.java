package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Aluno;
import repositories.AlunoRepositoryTxt;
import repositories.AlunoRepositoryXml;

public class AlunoController {
	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAlunos() {
		var list = new ArrayList<Aluno>();
		System.out.println("Informe a quantidade de Alunos!");
		var quantidade = Integer.parseInt(scanner.nextLine());

		for (var i = 1; i <= quantidade; i++) {
			var aluno = new Aluno();
			aluno.setId(UUID.randomUUID());
			System.out.print("Nome do aluno...: ");
			aluno.setNome(scanner.nextLine());
			System.out.print("Matricula...: ");
			aluno.setMatricula(scanner.nextLine());
			list.add(aluno);
		}
		var alunoRepositoryTxt = new AlunoRepositoryTxt();
		var alunoRepositoryXml = new AlunoRepositoryXml();

		alunoRepositoryTxt.exportar(list);
		alunoRepositoryXml.exportar(list);
	}

}
