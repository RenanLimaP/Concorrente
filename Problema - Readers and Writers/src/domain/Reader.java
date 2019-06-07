package domain;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {

	Semaphore semaforoLeitura, semaforoEscrita;
	volatile static int countLeitura = 0;

	public Reader(Semaphore semaforoLeitura, Semaphore semaforoEscrita) {
		this.semaforoLeitura = semaforoLeitura;
		this.semaforoEscrita = semaforoEscrita;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				semaforoLeitura.acquire();
				countLeitura++;
				if (countLeitura == 1) {
					semaforoEscrita.acquire();
				}
				semaforoLeitura.release();

				facaIsso(Thread.currentThread().getName() + " está lendo");
				Thread.sleep(1500);
				facaIsso(Thread.currentThread().getName() + " terminou de ler");

				semaforoLeitura.acquire();
				countLeitura--;
				if (countLeitura == 0) {
					semaforoEscrita.release();
				}
				semaforoLeitura.release();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void facaIsso(String acao) throws InterruptedException {
		System.out.println(acao);
		Thread.sleep(((int) (Math.random() * 300)));
	}
}
