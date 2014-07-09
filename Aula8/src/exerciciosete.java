/*Escreva um programa que lê um array de números de tamanho
10 e imprime a posição onde se encontra o maior valor do array.
Se houver mais de um valor maior, devolver a posição da primeira
ocorrência.
*/
 import java.util.*;
public class exerciciosete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
