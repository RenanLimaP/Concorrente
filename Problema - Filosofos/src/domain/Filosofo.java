package domain;

public class Filosofo implements Runnable {

	private Garfo garfoEsquerdo;
	private Garfo garfoDireito;

	public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito) {
		this.garfoEsquerdo = garfoEsquerdo;
		this.garfoDireito = garfoDireito;
	}

	@Override
	public void run() {
		try {
			while (true) {
				durma(" - Pensando");
				
				synchronized (garfoEsquerdo) {
					durma(" - Pegando garfo esquerdo");
					
					synchronized (garfoDireito) {
						durma(" - Pegando o garfo direito e comendo");

						durma(" - Colocando garfo direito de volta");
					}
					durma(" - Colocando garfo esquerdo de volta. Voltando a pensar");
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void durma(String acao) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + acao);
		Thread.sleep(((int) (Math.random() * 400)));
	}

}