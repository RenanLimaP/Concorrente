package main;

import domain.Filosofo;
import domain.Garfo;

public class Jantar {

	public static void main(String[] args) {
		Filosofo[] filosofos = new Filosofo[5];
		Garfo[] garfos = new Garfo[filosofos.length];

		for (int i = 0; i < garfos.length; i++) {
			garfos[i] = new Garfo();
		}
		
		Garfo garfoEsquerdo = new Garfo();
		Garfo garfoDireito = new Garfo();

		for (int i = 0; i < filosofos.length; i++) {
			garfoEsquerdo = garfos[i];
			garfoDireito = garfos[(i + 1) % garfos.length];
			
			filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);

			//DeadLock
			if (i == filosofos.length - 1) {
				filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo);
			} else {
				filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);
			}

			Thread t = new Thread(filosofos[i], "Filósofo " + (i + 1));
			t.start();
		}
	}

}
