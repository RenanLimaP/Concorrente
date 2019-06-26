package domain;

public class Barber implements Runnable {
	
	Salao salao;

	public Barber(Salao salao) {
		this.salao = salao;
	}

	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Barber started..");
		
		while (true) {
			salao.cortarCabelo();
		}
	}
}
