package exerciciorevisao;

import java.util.Scanner;
/*Exercício: Criar um programa que diga quando a resposta da pergunta 
 * "qual é o primeiro número primo depois do número 100?" (101) está correta utilizando "do/while"*/
public class ExDois {
	public static void main(String[] args){
		Scanner k = new Scanner(System.in);	
		int resultado;
		do{
			System.out.println("qual o primeiro numero primo depois do numero 100:");
			resultado = k.nextInt();
		}while(resultado != 101 );
		System.out.println("resposta correta!");
	}

}
