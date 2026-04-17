package biblioteca;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private Disponibilidade dis; 
	
	public enum Disponibilidade{
		DISPONIVEL, INDISPONIVEL, ALUGADO
	}

	public Livro(String titulo, String autor, String isbn, Disponibilidade dis) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.dis = dis; 
	}

	public Livro() {
	}

	// --- REGRA DE NEGÓCIO: EMPRÉSTIMO = Regra 1: Só é possível alugar um livro disponível.
	public void alugar() {
		if (this.dis == Disponibilidade.DISPONIVEL) {
			this.dis = Disponibilidade.ALUGADO; 
			System.out.println("Sucesso: O livro '" + this.titulo + "' foi alugado!");
		} else if (this.dis == Disponibilidade.ALUGADO) {
			System.out.println("Aviso: O livro '" + this.titulo + "' já se encontra alugado.");
		} else {
			System.out.println("Erro: O livro '" + this.titulo + "' está indisponível para empréstimo no momento.");
		}
	}

	// --- GETTERS E SETTERS ---
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Disponibilidade getDis() {
		return dis;
	}

	public void setDis(Disponibilidade dis) {
		this.dis = dis;
	}

	// --- TO STRING ---
	@Override
	public String toString() {
		return "Livro [" + 
               "Título = '" + titulo + '\'' + 
               ", Autor = '" + autor + '\'' + 
               ", ISBN = '" + isbn + '\'' + 
               ", Status = " + dis + 
               "]";
	}
}