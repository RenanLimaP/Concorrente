package domain;

public class Garfo {

	private String nome;

	public Garfo(String nome) {
		this.nome = nome;
	}

	public Garfo() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Garfo [nome=" + nome + "]";
	}

}
