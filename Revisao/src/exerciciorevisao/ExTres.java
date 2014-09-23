package exerciciorevisao;

import java.util.Scanner;
/*Exercício: Criar um programa que diga quando a resposta da pergunta 
 * "o que é que mantém sempre o mesmo tamanho, não importa o peso?" (balança) está correta utilizando "if/else"*/
public class ExTres {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String resposta;
		System.out.println("O que é que mantém sempre o mesmo tamanho, não importa o peso?");
		resposta = k.nextLine();
		if(resposta.equalsIgnoreCase("balança")){
			System.out.println("resposta correta!");
		}else {
			System.out.println("resposta errada!");
		}

	}

}
