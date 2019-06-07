package main;

import java.util.concurrent.Semaphore;

import domain.Reader;
import domain.Writer;

public class Main {

	static Semaphore semaforoLeitura = new Semaphore(1, true);
	static Semaphore semaforoEscrita = new Semaphore(1, true);

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader(semaforoLeitura, semaforoEscrita);
		Writer writer = new Writer(semaforoEscrita);
		Thread t1 = new Thread(reader, "Ana");
		Thread t2 = new Thread(reader, "Let�cia");
		Thread t3 = new Thread(writer, "Jos�");
		Thread t4 = new Thread(reader, "Lu�s");
		t1.start();
		t3.start();
		t2.start();
		t4.start();
	}
}
