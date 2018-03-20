package banco;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ContaTest {
	Conta c1;
	Conta c2;

	
	
	@Test 
	void contaTest() throws OperacaoIllegalException {
		c1 = new Conta(1, 0.0);
		c2 = new Conta(2, 500);
		c2.transferir(c2, c1, 200.0);
		
		assertEquals(200, c1.getSaldo());
		assertEquals(300, c2.getSaldo());
		
	}
	
	@Test
	void contaTestErroSaldoInsuficiente() throws OperacaoIllegalException {
		c1 = new Conta(1, 0.0);
		c2 = new Conta(2, 100);
		try{
			c2.transferir(c2, c1, 200.0);
		} catch (OperacaoIllegalException oie) {
			System.out.println("Saldo insuficiente");
		}
	
	}
	
	@Test
	void contaTestErroErroAoCreditarValor() throws OperacaoIllegalException {
		c1 = new Conta(1, 0.0);
		c2 = new Conta(2, 100);
		try{
			c2.transferir(c2, c1, -5);
		} catch (OperacaoIllegalException oie) {
			System.out.println("Erro ao creditar valor");
		}
	}

}
