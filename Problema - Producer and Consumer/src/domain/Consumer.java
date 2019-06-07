package domain;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	Semaphore semaphoreConsumer;
	Semaphore semaphoreProducer;

	public Consumer(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
		this.semaphoreConsumer = semaphoreConsumer;
		this.semaphoreProducer = semaphoreProducer;
	}

	public void run() {
		for (;;) {
			try {
				semaphoreConsumer.acquire();
				facaIsso("Foi Consumido : " + Thread.currentThread().getName());
				semaphoreProducer.release();
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
