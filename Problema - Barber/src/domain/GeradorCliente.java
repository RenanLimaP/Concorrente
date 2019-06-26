package domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GeradorCliente implements Runnable {

	Salao salao;

	public GeradorCliente(Salao salao) {
		this.salao = salao;
	}

	public void run() {
		while (true) {
			Cliente cliente = new Cliente(salao);
			cliente.setHoraEntrada(new Date());
			Thread thCliente = new Thread(cliente);
			cliente.setNome("Cliente Thread " + thCliente.getId());
			thCliente.start();
			try {
				TimeUnit.SECONDS.sleep((long) (Math.random() * 45));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}