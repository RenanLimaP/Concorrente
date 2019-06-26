package domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Salao {
	
	private int nCadeiras;
	private Queue<Cliente> listClientes;

	public Salao() {
		nCadeiras = 3;
		listClientes = new LinkedList<Cliente>();
	}

	public void cortarCabelo() {
		Cliente cliente;
		
		synchronized (listClientes) {
			while (listClientes.size() == 0) {
				System.out.println("Barbeiro está dormindo esperando por clientes...");
				try {
					listClientes.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			cliente = listClientes.poll();
			System.out.println("Barbeiro chamou o "  + cliente.getNome() +  " da fila.");
		}
		
		long duration = 0;
		try {
			System.out.println("Cortando o cabelo do cliente: " + cliente.getNome());
			duration = (long) (Math.random() * 16);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cabelo cortado do cliente: " + cliente.getNome() + " em " + duration + " segundos.");
	}

	public void add(Cliente cliente) {
		System.out.println("Cliente : " + cliente.getNome() + " entrou no salão às: " + cliente.getHoraEntrada());

		synchronized (listClientes) {
			if (listClientes.size() == nCadeiras) {
				System.out.println("Não tem cadeira disponível para o cliente: " + cliente.getNome());
				System.out.println("Cliente " + cliente.getNome() + " foi embora...");
				return;
			}

			listClientes.offer(cliente);
			System.out.println("Cliente : " + cliente.getNome() + " se sentou na cadeira." + " Existem " + listClientes.size() + " clientes na fila.");

			if (listClientes.size() == 1)
				listClientes.notify();
		}
	}
}