package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ContaTest {
	Conta c1;
	Conta c2;
	
	@Before 
	public void create() {
		c1 = new Conta(1, 0.0);
		c2 = new Conta(2, 500.0);
	}
	
	
	@Test 
	void contaTest() throws OperacaoIllegalException {
		
		c2.transferir(c2, c1, 200.0);
		
		assertEquals(300.0, c2.getSaldo());
		assertNotEquals(200.0, c2.getSaldo());
		assertEquals(200.0, c1.getSaldo());
		assertNotEquals(700.0, c1.getSaldo());
		assertNotEquals(500.0, c2.getSaldo());
	}

}
