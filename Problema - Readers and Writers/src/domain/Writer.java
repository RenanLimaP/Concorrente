package domain;

import java.util.concurrent.Semaphore;

public class Writer implements Runnable {
	Semaphore semaforoEscrita;

	public Writer(Semaphore semaforoEscrita) {
		this.semaforoEscrita = semaforoEscrita;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				semaforoEscrita.acquire();
				facaIsso("Está Escrevendo");
				facaIsso("Terminou de escrever");
				semaforoEscrita.release();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				Thread.currentThread().interrupt();
			}
		}
	}
	public void facaIsso(String acao) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + acao);
		Thread.sleep(((int) (Math.random() * 300)));
	}
}
