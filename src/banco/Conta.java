package banco;

public class Conta {
	private int conta;
	private double saldo;
	
	
	public Conta(int id_conta, double dep_saldo) {
		this.conta = id_conta;
		this.saldo = dep_saldo;
	}
	
	public void transferir (Conta contaOrig, Conta contaDest, double valor) throws OperacaoIllegalException{
		if (contaOrig.getSaldo() >= valor) {
			contaDest.creditarValor(valor);
			contaOrig.debitarValor(valor);
		}else {
			throw new OperacaoIllegalException("Saldo insuficiente");
		}
	}
	
	public void creditarValor(double valor) throws OperacaoIllegalException{
		if (valor > 0) {
			this.saldo += valor;
		}else {
			throw new OperacaoIllegalException("Erro ao creditar valor");
		}
	}
	
	public void debitarValor(double Valor) throws OperacaoIllegalException{
		this.saldo -= Valor;
	}
	public int getConta() {
		return conta;
	}


	public double getSaldo() {
		return saldo;
	}

	
}
