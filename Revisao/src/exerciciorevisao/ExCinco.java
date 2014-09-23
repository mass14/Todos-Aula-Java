package exerciciorevisao;

import java.util.Random;
import java.util.Scanner;
/*Exercício: Crie um programa que permita você escolher um numero,
 *  faça um sorteio de um numero e diga se o numero escolhido é o mesmo sorteado, 
 *  retorne uma mensagem se acertar dizendo que acertou, e outra se errar dizendo que errou.*/
public class ExCinco {

	public static void main(String[] args){
		Random r = new Random();
		Scanner k = new Scanner(System.in);
		int numgerado = r.nextInt(21);
		int numrecebido;
		System.out.println("Adivinhe o numero!");
		do{
		System.out.println("digite um numero de 0 a 20");
		numrecebido = k.nextInt();
		}while (numrecebido != numgerado);
		
		System.out.println("parabés você acertou!");
	}
}
