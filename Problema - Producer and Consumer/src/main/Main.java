package main;

import java.util.concurrent.Semaphore;

import domain.Consumer;
import domain.Producer;

public class Main {

	public static void main(String[] args) {

		Semaphore semaphoreProducer = new Semaphore(1);
		Semaphore semaphoreConsumer = new Semaphore(0);

		new Producer(semaphoreProducer, semaphoreConsumer).start();
		new Consumer(semaphoreConsumer, semaphoreProducer).start();
	}
}
