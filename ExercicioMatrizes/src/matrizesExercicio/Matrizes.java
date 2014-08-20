package matrizesExercicio;

import java.util.*;

public class Matrizes {

	private int[][] matrizUm = { { 1, 2, 4, 10 }, { 3, 5, 1, 6 },
			{ 7, 3, 2, 9 } };

	// exercicio Um
	public void somaItenMtriz() {
		int soma = 0;
		for (int i = 0; i < matrizUm.length; i++) {
			for (int j = 0; j < matrizUm[0].length; j++) {

				soma += matrizUm[i][j];
			}
		}
		System.out.println(soma);
	}

	// exercicio Dois
	private double[][] matrizDois = { { 2, 4, 5, 10 }, { 6, 9, 2, 1 },
			{ 3, 4, 1, 7 }, { 9, 8, 4, 0.3 } };

	public double[] minMaxMed() {
		double[] arr = new double[3];
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double media;
		double soma = 0;

		for (int i = 0; i < matrizDois.length; i++) {
			for (int j = 0; j < matrizDois[0].length; j++) {
				if (min > matrizDois[i][j]) {
					min = matrizDois[i][j];
				}
				if (max < matrizDois[i][j]) {
					max = matrizDois[i][j];
				}
				soma += matrizDois[i][j];
			}
		}
		media = soma / (matrizDois.length * matrizDois[0].length);

		arr[0] = min;
		arr[1] = max;
		arr[2] = media;
		return arr;

	}

	// exercicio 3
	public void contatos() {
		Scanner k = new Scanner(System.in);
		System.out.println("quantos contatos serão inseridos?");
		int index = k.nextInt();
		String[][] contatos = new String[index][2];

		for (int i = 0; i < contatos.length; i++) {
			for (int j = 0; j < contatos.length; j++)
				while (j != 2) {
					if (j == 0) {
						Scanner w = new Scanner(System.in);
						System.out.println("Digite o " + (i + 1) + "o nome: ");
						String nome = w.nextLine();
						contatos[i][j] = nome;
						while (nome.length() < 2 || nome.length() > 50) {
							System.out.println("Digite o " + (i + 1)
									+ "o nome: ");
							nome = w.nextLine();
							contatos[i][j] = nome;
						}
						j++;
						
					} else if (j == 1) {
						Scanner x = new Scanner(System.in);
						System.out.println("Digite o " + (i + 1) + "o email: ");
						String email = x.nextLine();
						contatos[i][j] = email;
						while (email.length() < 5 || email.length() > 50) {
							System.out.println("Digite o " + (i + 1)
									+ "o nome: ");
							email = x.nextLine();
							contatos[i][j] = email;
						}
							j++;
							
						}
					}
				}

		
		for (int i = 0; i < contatos.length; i++) {
			for (int l = 0; l < contatos[0].length; l++) {
				System.out.println(contatos[i][l]);
			}
			
			k.close();
		}
	}
}


