/*Crie um programa que recebe um array de inteiros de tamanho 10, 
 * aonde todos os os valores pares devem ser substituidos pelo seu 
 * valor + 2 e os valores �mpares devem ser substituidos pelo seu 
 * valor � 3. Mostre na tela o valor final do array.*/
import java.util.*;

public class exercicioOito {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int i;
		int arr[] = new int[10];
		int a[] = new int[10];

		for (i = 0; i <= 9; i++) {
			System.out.println("Digite um numero:");
			arr[i] = keyboard.nextInt();
			if (arr[i] % 2 == 0) {
				a[i] = arr[i] + 2;
			} else {
				a[i] = arr[i] + 3;

			}
		}
		for (i = 0; i <= 9; i++) {
			System.out.println(a[i]);
		}
		keyboard.close();
	}
}
