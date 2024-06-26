package thread_bancaria;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private Lock lock = new ReentrantLock();
	private List<Loja> contasCorporativas;
	
	public void comprar(Cliente cliente, double valor) {
		lock.lock();
		
		try {
			Random rand = new Random();
			int indice = rand.nextInt(contasCorporativas.size());
			
			Loja loja = contasCorporativas.get(indice);
			
			System.out.println(cliente.getName() + " - Transferencia de " + valor + "R$");
			cliente.getConta().debitar(valor);
			loja.getConta().creditar(valor);
			
			if (loja.getConta().getSaldo()>=1400) {
				pagarFuncionario(loja);
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void pagarFuncionario(Loja loja) {
		for (Funcionario funcionario : loja.getFuncionarios()) {
			if (!funcionario.isPagamento()) {
				funcionario.getContaCorrente().creditar(1400);
				loja.getConta().debitar(1400);
				System.out.println("Pagando Funcionario");
				funcionario.pagamentoEfetuado();
				break;
			}
		}
	}
	
	public void investir(Funcionario funcionario) {
		this.lock.lock();
		
		try {
			System.out.println(funcionario.getName() + " está investindo");
			double investimento = funcionario.getContaCorrente().getSaldo() * 0.2; 
	        funcionario.getContaCorrente().debitar(investimento);
			funcionario.getContaInvestimento().creditar(investimento);
		} finally {
			this.lock.unlock();
		}
	}

	public List<Loja> getContasCorporativas() {
		return contasCorporativas;
	}

	public void setContasCorporativas(List<Loja> contasCorporativas) {
		this.contasCorporativas = contasCorporativas;
	}
}
