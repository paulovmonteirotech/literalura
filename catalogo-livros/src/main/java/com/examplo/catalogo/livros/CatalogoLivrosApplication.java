package com.examplo.catalogo.livros;

import com.examplo.catalogo.livros.model.Autor;
import com.examplo.catalogo.livros.model.Livro;
import com.examplo.catalogo.livros.service.GutendexService;
import com.examplo.catalogo.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CatalogoLivrosApplication implements CommandLineRunner {

	@Autowired
	private LivroService livroService;

	@Autowired
	private GutendexService gutendexService;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("Escolha uma opção:");
			System.out.println("1. Listar livros");
			System.out.println("2. Buscar livros da API");
			System.out.println("3. Listar autores");
			System.out.println("4. Listar autores vivos em um determinado ano");
			System.out.println("5. Sair");

			int escolha = scanner.nextInt();
			scanner.nextLine();  // Consumir a nova linha

			switch (escolha) {
				case 1:
					listarLivros();
					break;
				case 2:
					System.out.println("Digite os parâmetros de busca:");
					String parametros = scanner.nextLine();
					buscarLivros(parametros);
					break;
				case 3:
					listarAutores();
					break;
				case 4:
					System.out.println("Digite o ano:");
					int ano = scanner.nextInt();
					listarAutoresVivosEmAno(ano);
					break;
				case 5:
					running = false;
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}
	}

	private void listarLivros() {
		List<Livro> livros = livroService.listarLivros();
		for (Livro livro : livros) {
			System.out.println(livro);
		}
	}

	private void buscarLivros(String parametros) {
		List<Livro> livros = gutendexService.buscarLivros(parametros);
		for (Livro livro : livros) {
			livroService.salvarLivro(livro);
		}
	}

	private void listarAutores() {
		List<Autor> autores = livroService.listarAutores();
		for (Autor autor : autores) {
			System.out.println(autor);
		}
	}

	private void listarAutoresVivosEmAno(int ano) {
		List<Autor> autores = livroService.listarAutoresVivosEmAno(ano);
		for (Autor autor : autores) {
			System.out.println(autor);
		}
	}
}
