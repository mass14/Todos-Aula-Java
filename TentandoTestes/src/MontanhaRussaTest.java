import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MontanhaRussaTest {
	MontanhaRussa mr;
	
	@Before
	public void setUp() throws Exception{
		mr = new MontanhaRussa();
		mr.setComprimento(1000);
		mr.setLoopings(14);
		mr.setLugares(20);
		mr.setVelocidade(260.4f);
	}
	
	@Test
	public void TestRecebePassageiros(){
		assertEquals(true,mr.recebePassageiros(10));
		assertEquals(false, mr.recebePassageiros(mr.getLugares()+1));
	}
	
	@Test
	public void TestMovimenta(){
		mr.movimenta(0);
		assertEquals(false, mr.getVelocidadeAtual() == 0);
		
		mr.movimenta(100);
		assertEquals(true, mr.getVelocidadeAtual() == 10);
		
	}
	
	
}
