/*Crie um programa que lê um array de inteiros de tamanho 5
e retorna a quantidade de elementos do array que são
números negativos.
*/
import java.util.*;
public class exercicioquatro {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int arr[]= new int[10];
		int x;
		int i;
		int totalNeg = 0;
		
		for( i = 0; i< 9; i++){
			System.out.println("Digite um numero:");
			x = keyboard.nextInt();
			arr[i]=x;
		
			if (arr[i] < 0) {
				totalNeg++;
				
			}
			
		}
		System.out.println(totalNeg);
		keyboard.close();
	}

}
