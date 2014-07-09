package oo.jogo;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeroiTest {
	private Heroi heroi, inimigo;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Before
	public void setUp() throws Exception {
		this.heroi = new Heroi("Teste", 0, 100, 10.2, 30.5);
		this.inimigo = new Heroi("Inimigo", 10, 50, 5, 6.5);
	}

	@After
	public void tearDown() throws IOException {
		this.heroi = null;
		this.inimigo = null;
	}

	@Test
	public void testCaminha() {
		assertEquals(0, this.heroi.getPosicao());
		this.heroi.caminha();
		assertEquals(15, this.heroi.getPosicao());
		
		// Testa msg solicitada
		assertEquals("O heroi " + this.heroi.getNome() + " caminhou.\n",
				outContent.toString());
		
		// Limpa o conteúdo do stream
		outContent.reset();
		
//		 com poção de velocidade ativa;
		this.heroi.setPosicao(0);
		this.heroi.tomarPocaoVelocidade();
		assertEquals("O heroi "+ this.heroi.getNome() + " tomou uma poção de velocidade.\n", outContent.toString());
		outContent.reset();
		this.heroi.caminha();
		assertEquals(30, this.heroi.getPosicao());
		assertEquals("O heroi " + this.heroi.getNome() + " caminhou.\n",
				outContent.toString());
	}

	@Test
	public void testCorre() {
		assertEquals(0, this.heroi.getPosicao());
		this.heroi.corre();
		assertEquals(150, this.heroi.getPosicao());
		assertEquals("O heroi " + this.heroi.getNome() + " correu.\n",
				outContent.toString());
		
		// Limpa o conteúdo do stream
		outContent.reset();
//
//		// com poção de velocidade ativa;
		this.heroi.setPosicao(0);
		this.heroi.tomarPocaoVelocidade();
		this.heroi.corre();
		assertEquals(300, this.heroi.getPosicao());
		assertEquals("O heroi "+ this.heroi.getNome() + " tomou uma poção de velocidade.\nO heroi " + this.heroi.getNome() + " correu.\n",
				outContent.toString());
	}
//
	@Test
	public void testAtaca() {
		assertEquals(50, this.inimigo.getVida());

		heroi.ataca(inimigo);
		assertEquals(47, this.inimigo.getVida());
		assertEquals("O heroi "+ this.heroi.getNome() +" atacou ("+ this.heroi.getAtaque() +") "
				+ "o heroi " + this.inimigo.getNome() + " ("+this.inimigo.getDefesa()+") e "
				+ "o mesmo recebeu "+ 3 +" de dano, "
				+ "ficando com "+ this.inimigo.getVida() +".\n", outContent.toString());
		
		// Limpa o conteúdo do stream
		outContent.reset();

		inimigo.ataca(heroi);
		assertEquals(99, this.heroi.getVida());
		assertEquals("O heroi "+ this.inimigo.getNome() +" atacou ("+ this.inimigo.getAtaque() +") "
				+ "o heroi " + this.heroi.getNome() + " ("+this.heroi.getDefesa()+") e "
				+ "o mesmo recebeu "+ -25 +" de dano, "
				+ "ficando com "+ this.heroi.getVida() +".\n", outContent.toString());
	}
//
	@Test
	public void testTomarPocaoVida() {
		assertEquals(100, this.heroi.getVida());
		heroi.tomarPocaoVida();
		assertEquals(110, this.heroi.getVida());
		assertEquals("O heroi "+this.heroi.getNome()+" tomou uma poção de vida e "
				+ "agora está com "+110+" pontos de vida.\n", outContent.toString());
	}

}
