package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Livro> acervo = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		boolean rodando = true; 
		
		System.out.println("Bem-vindo ao Sistema de Biblioteca!");

		while (rodando) {
			System.out.println("\n==================================");
			System.out.println("1 - Cadastrar novo Livro");
			System.out.println("2 - Listar Acervo");
			System.out.println("3 - Atualizar Título de um Livro");
			System.out.println("4 - Remover Livro");
			System.out.println("5 - Realizar Empréstimo");
			System.out.println("0 - Sair");
			System.out.println("==================================");
			System.out.print("Escolha uma opção: ");
			
			
			String opcaoStr = entrada.nextLine();
			
			switch (opcaoStr) {
				case "1":
					System.out.println("\n-- CADASTRAR LIVRO --");
					System.out.print("Digite o título: ");
					String titulo = entrada.nextLine();
					
					System.out.print("Digite o autor: ");
					String autor = entrada.nextLine();
					
					System.out.print("Digite o ISBN: ");
					String isbn = entrada.nextLine();
					
					// Todo livro novo nasce DISPONIVEL por padrão 
					Livro novoLivro = new Livro(titulo, autor, isbn, Livro.Disponibilidade.DISPONIVEL);
					acervo.add(novoLivro);
					System.out.println("Sucesso: Livro cadastrado!");
					break;

				case "2":
					System.out.println("\n-- ACERVO DA BIBLIOTECA --");
					listarLivros(acervo);
					break;

				case "3":
					System.out.println("\n-- ATUALIZAR LIVRO --");
					System.out.print("Digite o ISBN do livro que deseja atualizar: ");
					String isbnBusca = entrada.nextLine();
					boolean encontrou = false;
					
					for (Livro livro : acervo) {
						if (livro.getIsbn().equals(isbnBusca)) {
							System.out.print("Digite o novo título: ");
							String novoTitulo = entrada.nextLine();
							livro.setTitulo(novoTitulo);
							System.out.println("Sucesso: Título atualizado!");
							encontrou = true;
							break; 
						}
					}
					if (!encontrou) {
						System.out.println("Erro: Livro não encontrado com este ISBN.");
					}
					break;

				case "4":
					System.out.println("\n-- REMOVER LIVRO --");
					System.out.print("Digite o ISBN do livro a ser removido: ");
					String isbnRemover = entrada.nextLine();
					
					// O removeIf retorna true se ele conseguiu remover algo
					boolean removeu = acervo.removeIf(l -> l.getIsbn().equals(isbnRemover));
					
					if (removeu) {
						System.out.println("Sucesso: Livro removido do acervo!");
					} else {
						System.out.println("Erro: Nenhum livro encontrado com este ISBN.");
					}
					break;

				case "5":
					System.out.println("\n-- REALIZAR EMPRÉSTIMO --");
					System.out.print("Digite o seu Nome: ");
					String nomeUser = entrada.nextLine();
					System.out.print("Digite a sua Matrícula: ");
					String matUser = entrada.nextLine();
					
					System.out.print("Digite o ISBN do livro que deseja alugar: ");
					String isbnAlugar = entrada.nextLine();
					
					Livro livroParaAlugar = null;
					for (Livro l : acervo) {
						if (l.getIsbn().equals(isbnAlugar)) {
							livroParaAlugar = l;
							break;
						}
					}
					
					if (livroParaAlugar != null) {
						// Cria o usuário temporário e tenta fazer o empréstimo
						Usuario user = new Usuario(nomeUser, matUser);
						
						// A nossa regra de negócio diz que se não estiver disponível, o método 'alugar' apenas avisa o erro
						if (livroParaAlugar.getDis() == Livro.Disponibilidade.DISPONIVEL) {
							Emprestimo emp = new Emprestimo(user, livroParaAlugar);
							System.out.println("\nResumo do Empréstimo:");
							System.out.println(emp.toString());
						} else {
							livroParaAlugar.alugar();
						}
					} else {
						System.out.println("Erro: Livro não encontrado no acervo.");
					}
					break;

				case "0":
					System.out.println("\nEncerrando o sistema. Até logo!");
					rodando = false;
					break;

				default:
					System.out.println("\nErro: Opção inválida! Tente novamente.");
					break;
			}
		}
		
		entrada.close();
	}

	// Método auxiliar para listar
	public static void listarLivros(List<Livro> lista) {
		if (lista.isEmpty()) {
			System.out.println("O acervo está vazio no momento.");
		} else {
			for (Livro livro : lista) {
				System.out.println(livro.toString());
			}
		}
	}
}