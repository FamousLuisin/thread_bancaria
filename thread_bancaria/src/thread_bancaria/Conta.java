package thread_bancaria;

public class Conta {

	private double saldo;
	
	Conta(double saldo){
		this.saldo = saldo;
	}
	
	public void debitar(double valor) {
		this.saldo -= valor;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}