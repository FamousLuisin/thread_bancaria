package thread_bancaria;

import java.util.List;

public class Loja {

	private List<Funcionario> funcionarios;
	private Conta conta;
	
	public Loja(List<Funcionario> listaFuncionarios) {
		this.funcionarios = listaFuncionarios;
		this.conta = new Conta(0);
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}