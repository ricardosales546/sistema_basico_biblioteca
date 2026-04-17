package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucaoPrevista;

	
	public Emprestimo(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
		
		this.dataEmprestimo = LocalDate.now();
		
		this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(7);
		
		this.livro.alugar(); 
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	@Override
	public String toString() {
		return "Emprestimo [" + 
               "Usuario = " + usuario.getNome() + 
               ", Livro = " + livro.getTitulo() + 
               ", Data = " + dataEmprestimo + 
               ", Devolver em = " + dataDevolucaoPrevista + 
               "]";
	}
}
