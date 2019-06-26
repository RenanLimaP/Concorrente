package domain;

import java.util.Date;

public class Cliente implements Runnable {

	private String nome;
	private Date horaEntrada;
	private Salao salao;

	public Cliente(Salao salao) {
		this.salao = salao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Salao getSalao() {
		return salao;
	}

	public void setSalao(Salao salao) {
		this.salao = salao;
	}

	public void run() {
		irCortarCabelo();
	}

	private synchronized void irCortarCabelo() {
		salao.add(this);
	}
}
