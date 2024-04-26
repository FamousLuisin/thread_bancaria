package thread_bancaria;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Funcionario extends Thread{

	private Conta contaCorrente;
	private Conta contaInvestimento;
	private boolean pagamento = false;
	private Banco banco;
	
	private Lock lock = new ReentrantLock();
	private final Condition conditional = lock.newCondition();
	
	Funcionario(Banco banco){
		this.banco = banco;
		this.contaCorrente = new Conta(0);
		this.contaInvestimento = new Conta(0);
	}

	Funcionario(){
		this.setContaCorrente(new Conta(0));
		this.contaInvestimento = new Conta(0);
	}
	
	public void pagamentoEfetuado() {
		lock.lock();
		
		try {
			this.pagamento = true;
			this.conditional.signal();
			System.out.println("Enviando o signal para " + this.getName());
		} finally {
			lock.unlock();
		}
		
		
	}
	
	public void realizarInvestimento() {
		// Não implementado
	}
	
	public void run(){
		this.realizarInvestimento();;
	}

	public Conta getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Conta contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public Conta getContaInvestimento() {
		return contaInvestimento;
	}

	public void setContaInvestimento(Conta contaInvestimento) {
		this.contaInvestimento = contaInvestimento;
	}

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	
}
