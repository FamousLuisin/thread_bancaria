package thread_bancaria;

public class Funcionario extends Thread{

	private Conta contaCorrente;
	private Conta contaInvestimento;
	private boolean pagamento = false;
	private Banco banco;
	
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
		// Não implementado
		
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
