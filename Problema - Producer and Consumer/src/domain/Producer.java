package domain;

import java.util.concurrent.Semaphore;

public class Producer extends Thread {
	Semaphore semaphoreProducer;
	Semaphore semaphoreConsumer;

	public Producer(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
		this.semaphoreProducer = semaphoreProducer;
		this.semaphoreConsumer = semaphoreConsumer;
	}

	public void run() {
		for (;;) {
			try {
				semaphoreProducer.acquire();
				facaIsso("Foi produzido: " + Thread.currentThread().getName());
				semaphoreConsumer.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void facaIsso(String acao) throws InterruptedException {
		System.out.println(acao);
		Thread.sleep(((int) (Math.random() * 300)));
	}
}
