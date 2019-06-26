package main;

import domain.Barber;
import domain.GeradorCliente;
import domain.Salao;

public class Main {

	public static void main(String a[]) {

		Salao salao = new Salao();
		Barber barber = new Barber(salao);
		GeradorCliente gc = new GeradorCliente(salao);

		Thread thbarber = new Thread(barber);
		Thread thgc = new Thread(gc);
		thgc.start();
		thbarber.start();
	}

}
