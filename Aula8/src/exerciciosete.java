/*Escreva um programa que l� um array de n�meros de tamanho
10 e imprime a posi��o onde se encontra o maior valor do array.
Se houver mais de um valor maior, devolver a posi��o da primeira
ocorr�ncia.
*/
 import java.util.*;
public class exerciciosete {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int arr[] = new int[10];
		int i;
		int posMaiorValor=-1;
		int maiorValor=Integer.MIN_VALUE;//para suprir a entrada de possiveis numeros negativos
		for (i = 0; i<10; i++){
			System.out.println("Digite numero:");
			arr[i] = keyboard.nextInt();
			
		if(arr[i] > maiorValor){
			posMaiorValor=i;
			maiorValor=arr[i];
		}
		}
			
		System.out.println(posMaiorValor);
		
		keyboard.close();
	}

}
