package exerciciorevisao;

import static org.junit.Assert.*;

import org.junit.Test;

import exerciciorevisao.RevisaoLogica;

public class RevisaoLogicaTest {
	private static final double DELTA = 0.1;

	/*
	 * Crie o método "potencia" que receba um número do tipo inteiro
	 * como parametro e eleve ele ao cubo e retorne o resultado
	 */
	@Test
	public void potencia() {
		assertEquals(8, RevisaoLogica.potencia(2));
		assertEquals(27, RevisaoLogica.potencia(3));
		assertEquals(6859, RevisaoLogica.potencia(19));
		assertEquals(1000000, RevisaoLogica.potencia(100));
	}
	
	/*
	 * Cria o método "imc" que recebe altura e peso por parametro e
	 * calcule o índice de massa corporal de um indivíduo
	 */
	@Test
	public void imc() {
		assertEquals(30.9, RevisaoLogica.imc(1.90, 111.6), DELTA);
		assertEquals(23.5, RevisaoLogica.imc(1.90, 85.0), DELTA);
		assertEquals(37.7, RevisaoLogica.imc(1.50, 85.0), DELTA);
	}
	
	/*
	 * João Papo-de-Pescador, homem de bem, comprou um microcomputador 
	 * para controlar o rendimento diário de seu trabalho. Toda vez que
	 * ele traz um peso de peixes maior que o estabelecido pelo regulamento
	 * de pesca do estado de São Paulo (50 quilos) deve pagar um multa de 
	 * R$ 4,00 por quilo excedente. João precisa que você faça um método
	 * "multa" que calcule quanto de multa ele irá pagar para cada uma de suas
	 * pescas.
	 */
	@Test
	public void multa() {
		assertEquals(0.0, RevisaoLogica.multa(40.0), DELTA);
		assertEquals(0.0, RevisaoLogica.multa(50.0), DELTA);
		assertEquals(360.0, RevisaoLogica.multa(140.0), DELTA);
		assertEquals(3800.0, RevisaoLogica.multa(1000.0), DELTA);
		assertEquals(0.0, RevisaoLogica.multa(0.0), DELTA);
	}
	
	/*
	 * Elabora um método "nadadores" que dada a idade de um nadador classifique-o em 
	 * uma das seguintes categorias:
	 * 
	 * - Infantil A = 5 a 7 anos
	 * - Infantil B = 8 a 11 anos
	 * - Juvenil A = 12 a 13 anos  
	 * - Juvenil B = 14 a 17 anos
	 * - Adultos = Maiores de 18 anos 
	 */
	@Test
	public void nadadores() {
		assertEquals("Infantil A", RevisaoLogica.nadadores(5));
		assertEquals("Infantil A", RevisaoLogica.nadadores(6));
		assertEquals("Infantil A", RevisaoLogica.nadadores(7));
		assertEquals("Infantil B", RevisaoLogica.nadadores(8));
		assertEquals("Infantil B", RevisaoLogica.nadadores(11));
		assertEquals("Juvenil A", RevisaoLogica.nadadores(12));
		assertEquals("Juvenil B", RevisaoLogica.nadadores(17));
		assertEquals("Adultos", RevisaoLogica.nadadores(19));
		assertEquals("Adultos", RevisaoLogica.nadadores(99));
		assertEquals("Adultos", RevisaoLogica.nadadores(120));
	}
	
	/*
	 * Crie um método "maiores" que a partir de uma lista de numeros verifique
	 * quais do número é o maior e retorne este número;
	 */
	@Test
	public void maiores() {
		assertEquals(10, RevisaoLogica.maiores(3, 2, 10, 4));
		assertEquals(31, RevisaoLogica.maiores(31, 2, 10, 4));
		assertEquals(44, RevisaoLogica.maiores(31, 2, 10, 14, 44));
		assertEquals(1, RevisaoLogica.maiores(1));
		assertEquals(3, RevisaoLogica.maiores(3, 2, 3));
		assertEquals(3, RevisaoLogica.maiores(3, 3, 2));
		assertEquals(3, RevisaoLogica.maiores(2, 3, 2));
		assertEquals(3, RevisaoLogica.maiores(2, 3, 3));
		assertEquals(3, RevisaoLogica.maiores(2, 2, 3));
		assertEquals(3, RevisaoLogica.maiores(3, 3, 2, 2));
		assertEquals(3, RevisaoLogica.maiores(2, 2, 3, 3));
		assertEquals(3, RevisaoLogica.maiores(2, 3, 3, 2));
		assertEquals(3, RevisaoLogica.maiores(3, 2, 2, 3));
	}
	
	/*
	 * Uma rainha requisitou os serviços de um monge e disse-lhe que
	 * pagaria qualquer preço. O monge, necessitando de alimentos, 
	 * indagou à rainha sobre o pagamento, se poderia ser feito com grãos
	 * de trigo dispostos em um tabuleiro de xadrez, de tal forma que o 
	 * primeiro quadro deveria conter apenas um grão e os quadros subseqüentes,
	 * o dobro do quadro anterior. A rainha achou o trabalho barato e pediu 
	 * que o serviço fosse executado, sem se dar conta de que seria impossível
	 * efetuar o pagamento. Faça um método "mongePilantra" para calcular e retornar
	 * o número de grãos que o monge esperava receber.
	 * 
	 * Dica: utilize um double como retorno do método;
	 */
	@Test
	public void mongePilantra() {
		assertEquals(1.8446744073709552E19, RevisaoLogica.mongePilantra(), 0.001);
	}


}
