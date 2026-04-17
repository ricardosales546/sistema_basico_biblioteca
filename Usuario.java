package biblioteca;

public class Usuario {
	private String nome;
	private String matricula;

	public Usuario(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public Usuario() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Usuario [Nome = '" + nome + "', Matricula = '" + matricula + "']";
	}
}
