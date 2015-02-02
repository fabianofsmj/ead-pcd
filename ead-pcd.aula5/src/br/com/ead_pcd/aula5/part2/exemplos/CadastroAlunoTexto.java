package br.com.ead_pcd.aula5.part2.exemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import br.com.ead_pcd.aula5.oficina.Log;

public class CadastroAlunoTexto {

	private Scanner entrada;
	private final String enderecoArquivo = "F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\alunos.cdt";
	private File arquivo;
	private BufferedReader leitor;
	private BufferedWriter gravador;
	private HashMap<String, Aluno> alunos;
	private Log log;

	public static void main(String[] args) {
		CadastroAlunoTexto cat = new CadastroAlunoTexto();
		cat.iniciar();
	}

	public CadastroAlunoTexto() {
		arquivo = new File(enderecoArquivo);
		alunos = new HashMap<String, Aluno>();
		entrada = new Scanner(System.in);
		log = new Log();
		

		iniciar();
	}

	private void iniciar() {
		int opcao = -1;
		try {

			lerArquivo();

			do {
				exibeMenu();
				opcao = opcaoUsuario();
				switch (opcao) {
				case 1: {
					exibirAlunos();
					break;
				}
				case 2: {
					novoAluno();
					break;
				}
				case 3: {
					removerAluno();
					break;
				}
				case 4: {
					break;
				}
				default: {
					System.out.println("Opção inexistente.");
					opcao = -1;
				}
				}

			} while (opcao != 4);
			finalizar();
		} catch (IOException ioe) {
			System.out.println("Falha na manipulação do arquivo.");
		}
		System.out.println("Encerrando..");
		System.exit(0);
	}

	private void finalizar() throws IOException {
		System.out.println("Salvando dados no arquivo..");
		log.registrar('T',"Salvando dados no arquivo...");
		gravarArquivo();
	}

	private void exibeMenu() {
		System.out.println(":: Menu ::\n");
		System.out.println(" 1. Ver Alunos\n 2. "
				+ "Adicionar Aluno\n 3. Remover Aluno\n 4. Sair");
		System.out.print(">> ");
	}

	private int opcaoUsuario() throws IOException {
		return entrada.nextInt();
	}

	private void exibirAlunos() {
		System.out.println("# Lista de Alunos\n");
		for (Aluno a : alunos.values()) {
			System.out.println("Matrícula: " + a.getMatricula());
			System.out.println("Nome: " + a.getNome());
			if (a.getEndereco() != null && !a.getEndereco().isEmpty()) {
				System.out.println("Endereço: " + a.getEndereco());
			}
			if (a.getTelefone() != null && !a.getTelefone().isEmpty()) {
				System.out.println("Telefone: " + a.getTelefone());
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	private void novoAluno() throws IOException {
		System.out.println("Informe matricula, nome, endereco e "
				+ "telefone do aluno, separados por vírgula.");
		System.out.print("* Apenas matrícula e nome são "
				+ "obrigatórios. \n>>");
		entrada.nextLine();

		String dados = entrada.nextLine();
		String[] dadosAluno = dados.split(",");

		Aluno a = new Aluno(dadosAluno[0], dadosAluno[1]);
		if (dadosAluno.length >= 3) {
			a.setEndereco(dadosAluno[2]);
		}
		if (dadosAluno.length >= 4) {
			a.setTelefone(dadosAluno[3]);
		}

		alunos.put(a.getMatricula(), a);
		log.registrar('T',"O aluno " + a.getMatricula() + "-" + a.getNome() + " foi adicionado.");
	}

	private void removerAluno() throws IOException {
		System.out.print("Informe matricula do aluno que deseja "
				+ "remover.\n>>");
		entrada.nextLine();

		String matricula = entrada.nextLine();

		if (alunos.containsKey(matricula)) {
			Aluno a = alunos.remove(matricula);
			System.out.println("Aluno " + a.getNome() + " removido..");
			log.registrar('T',"O aluno " + a.getMatricula() + "-" + a.getNome() + " foi removido.");
		} else {
			System.out.println("Matricula não encontrada..");
			log.registrar('T',"Aluno " + matricula + " não encontrado!");
		}
	}

	private void lerArquivo() throws IOException {
		
		if (arquivo.length() <= 0)
			return;

		System.out.println("Carregando dados do arquivo..");
		log.registrar('T',"Carregando dados do arquivo " + arquivo.getAbsolutePath());
		leitor = new BufferedReader(new FileReader(arquivo));
		String dados = "";

		while ((dados = leitor.readLine()) != null) {
			String[] dadosAluno = dados.split(",");

			Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);
			if (dadosAluno.length >= 3) {
				aluno.setEndereco(dadosAluno[2]);
			}
			if (dadosAluno.length >= 4) {
				aluno.setTelefone(dadosAluno[3]);
			}
			alunos.put(aluno.getMatricula(), aluno);
			log.registrar('T',"Aluno " + aluno.getMatricula() + "-" + aluno.getNome() + " carregado.");
		}
		leitor.close();
		leitor = null;
	}

	private void gravarArquivo() throws IOException {
		if (alunos != null) {
			gravador = new BufferedWriter(new FileWriter(arquivo, false));
			for (Aluno a : alunos.values()) {
				String representacaoAluno = a.getMatricula() + ","
						+ a.getNome();
				if (a.getEndereco() != null && !a.getEndereco().isEmpty()) {
					representacaoAluno += "," + a.getEndereco();
				}
				if (a.getTelefone() != null && !a.getTelefone().isEmpty()) {
					representacaoAluno += "," + a.getTelefone();
				}
				gravador.write(representacaoAluno
						+ System.getProperty("line.separator"));
			}
			gravador.flush();
			log.registrar('T',"Dados gravados no arquivo " + arquivo.getAbsolutePath());
			gravador.close();
			gravador = null;
		}
	}
} // Final da Classe
