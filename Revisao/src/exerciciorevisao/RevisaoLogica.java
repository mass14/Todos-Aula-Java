package exerciciorevisao;

public class RevisaoLogica {

	/*
	 * Crie o método "potencia" que receba um número do tipo inteiro
	 * como parametro e eleve ele ao cubo e retorne o resultado
	 */
	public static int potencia(int num) {

		return (int) Math.pow(num, 3);
	}
	/*
	 * Cria o método "imc" que recebe altura e peso por parametro e
	 * calcule o índice de massa corporal de um indivíduo
	 */
	public static double imc(double altura, double peso) {
		return peso / Math.pow(altura, 2);
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
	public static double multa(double peso) {
		return peso > 50.0 ? (peso - 50.0) * 4.0 : 0.0;
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
	public static String nadadores(int idade) {

		if (idade >= 5 && idade <= 7) {
			return "Infantil A";
		} else if (idade >= 8 && idade <= 11) {
			return "Infantil B";
		} else if (idade >= 12 && idade <= 13) {
			return "Juvenil A";
		} else if (idade >= 14 && idade <= 17) {
			return "Juvenil B";
		} else if (idade >= 18) {
			return "Adultos";
		}
		return null;
	}
	/*
	 * Crie um método "maiores" que a partir de uma lista de numeros verifique
	 * quais do número é o maior e retorne este número;
	 */
	public static int maiores(int... numeros) {
		int numMaior = Integer.MIN_VALUE;
		for (int num : numeros) {
			if (num > numMaior) {
				numMaior = num;
			}
		}
		return numMaior;
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
	public static double mongePilantra() {
		double valor;
		double valorAtual = 1;

		for (int i = 0; i < 64; i++) {
			valor = valorAtual * 2;
			valorAtual = valor;
		}
		System.out.println(valorAtual);
		return valorAtual;
	}
}

