package variaveis.exercicios;

import java.util.Scanner;

/*
 * 1 - Escreva um método em java para somar todos os números da matriz:
 * 
 * 1 | 2 | 4 | 10
 * 3 | 5 | 1 | 6
 * 7 | 3 | 2 | 9
 * 
 * Após somar imprima os resultados na tela
 */


/* 2 - Escreva um método em Java para calcular o mínimo, o máximo e a média valor da matriz:
 * 
 * 2 | 4 | 5 | 10
 * 6 | 9 | 2 | 1
 * 3 | 4 | 1 | 7
 * 9 | 8 | 4 | 0.3
 * 
 * 
 * E retorno deve ser um Array de tamanho 3 aonde:
 * - O primeiro valor é o mínimo
 * - O segundo valor é o máximo
 * - O terceiro valor é a média
 */

/*
 * 3 - Crie um método que terá uma matriz para armazenar o nome e o e-mail de contatos.
 * 
 * - O usuário poderá indicar quantos contatos deseja registrar.
 * - Este número deve ser maior que zero.
 * - O usuário poderá registrar um número menor de contatos.
 * - Utilize um laço for para captar e armazenar os dados.
 * - Utilize laços while para captar o nome e o e-mail.
 * Se um dado informado não for válido, solicite-o novamente:
 *   - Nome: de 2 a 50 caracteres
 *   - E-mail: de 5 a 50 caracteres
 * 
 * Utilize um laço for para recuperar e exibir a lista de contatos.
 */

public class MatrizesExercicios {
	
	private static void imprimeMatriz() {
		int[][] matriz = {{1, 2, 4, 10}, {3, 5, 1, 6}, {7, 3, 2, 9}};
		int soma = 0;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				soma += matriz[i][j];
			}
		}
		
		System.out.println(soma);
	}
	
	private static double[] analiseNumerica() {
		double[][] matriz = {{2, 4, 5, 10}, {6, 9, 2, 1}, {3, 4, 1, 7}, {9, 8, 4, 0.3}};
		double[] analise = {Double.MAX_VALUE, Double.MIN_VALUE, 0};
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] < analise[0]) {
					analise[0] = matriz[i][j]; 
				}
				
				if(matriz[i][j] > analise[1]) {
					analise[1] = matriz[i][j]; 
				}
				
				analise[2] += matriz[i][j];
			} 
		}
		
		analise[2] /= matriz.length * matriz[0].length;
		
		return analise;
	}
	
	private static void armazenaNomeEmail() {
		Scanner kb01 = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de usuários a registar: ");
		int len = kb01.nextInt();
		System.out.println(len);
		
		String[][] nomeEmail = new String[len][2];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < 2; j++) {
				nomeEmail[i][j] = "";
			}
		}
		
		for(int i = 0; i < len; i++) {
			System.out.println(i);
			while(nomeEmail[i][0].length() < 2 || nomeEmail[i][0].length() > 50) {
				Scanner kb02 = new Scanner(System.in);
				System.out.print("Digite o nome: ");
				nomeEmail[i][0] = kb02.nextLine();
			}
			
			while(nomeEmail[i][1].length() < 2 || nomeEmail[i][1].length() > 50) {
				Scanner kb03 = new Scanner(System.in);
				System.out.print("Digite o email: ");
				nomeEmail[i][1] = kb03.nextLine();
			}
		}
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.println(nomeEmail[i][j]);
			}
		}
		
		
		kb01.close();
		
		
	}

	public static void main(String[] args) {
//		imprimeMatriz();
//		
		for(double a : analiseNumerica()) {
			System.out.println(a);
		}
//		
//		armazenaNomeEmail();
		 
	}

}
