package thread_bancaria;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		int num_funcionarios = 4;
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		
		for (int i = 0; i < num_funcionarios; i++) {
			listaFuncionarios.add(new Funcionario(banco));
			listaFuncionarios.get(i).start();
		}
		
		List<Loja> lojas = new ArrayList<>();
		lojas.add(new Loja(listaFuncionarios.subList(0, 2)));
		lojas.add(new Loja(listaFuncionarios.subList(2, 4)));
		
		banco.setContasCorporativas(lojas);
		
		int num_clientes = 5;
		List<Cliente> listaClientes = new ArrayList<>();
		
		for (int i = 0; i < num_clientes; i++) {
			listaClientes.add(new Cliente(banco));
			listaClientes.get(i).start();
		}
		
		try {
			for (Cliente cliente : listaClientes) {
				cliente.join();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			for (Funcionario funcionario : listaFuncionarios) {
				funcionario.join();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		// Mostrando valor da conta dos clientes
		int somaCliente = 0;
		for (Cliente cliente : listaClientes) {
			somaCliente += cliente.getConta().getSaldo();
			System.out.println(cliente.getName() + " " + cliente.getConta().getSaldo());
		}
		
		// Verificar se está tudo certo
		if (somaCliente == 0) {
			System.out.println("Tudo deu certo com cliente");
		}else {
			System.out.println("Algo deu errado com cliente");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		// Verificando o valor restante na conta das lojas
		int somaTotal = 0;
		for (Loja loja : lojas) {
			somaTotal += loja.getConta().getSaldo();
			System.out.println("Loja: " + loja.getConta().getSaldo());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		// Verificando o valor restante na conta das lojas
		for (Funcionario funcionario : listaFuncionarios) {
			somaTotal += funcionario.getContaCorrente().getSaldo();
			somaTotal += funcionario.getContaInvestimento().getSaldo();
			System.out.println(funcionario.getName() + " " + funcionario.getContaCorrente().getSaldo());
			System.out.println(funcionario.getName() + " " + funcionario.getContaInvestimento().getSaldo());
		}
		
		// Verificar se está tudo certo
		if (somaTotal == 5000) {
			System.out.println("Tudo deu certo com loja e funcionario");
		}else {
			System.out.println("Algo deu errado com loja e funcionario");
		}
	}

}
