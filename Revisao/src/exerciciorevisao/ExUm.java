package exerciciorevisao;

import java.util.Scanner;
/*Exercício: Criar um programa que diga quando a resposta da expressão 15 x 2 - 30 / 3 (20) está correta utilizando "do while"*/
public class ExUm {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int expressao = 15 * 2 - 30 / 3;
		int resultado;
		do {

			System.out.println("qual o resultado de 15 * 2 - 30 / 3? ");
			resultado = k.nextInt();
		} while (resultado != 20);
		System.out.println("Resultado correto");
	}
}
