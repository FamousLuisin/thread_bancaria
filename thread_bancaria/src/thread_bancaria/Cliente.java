package thread_bancaria;

public class Cliente extends Thread{
	private Conta conta;
	private Banco banco;
	
	Cliente(Banco banco){
		this.conta = new Conta(1000);
		this.banco = banco;
	}
	
	@Override
	public void run() {
		
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}

