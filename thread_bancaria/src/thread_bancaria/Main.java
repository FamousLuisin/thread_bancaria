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
		}
		
		List<Loja> lojas = new ArrayList<>();
		lojas.add(new Loja(listaFuncionarios.subList(0, 2)));
		lojas.add(new Loja(listaFuncionarios.subList(2, 4)));
		
		
		
		int num_clientes = 5;
		List<Cliente> listaClientes = new ArrayList<>();
		
		for (int i = 0; i < num_clientes; i++) {
			listaClientes.add(new Cliente(banco));
		}
		
		
	}

}
