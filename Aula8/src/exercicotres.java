/*Escreva um trecho Java que leia 10 valores double do teclado e
armazene-os num array d
*/
import java.util.*;
public class exercicotres {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		double d[]= new double[10];
		double x;
		int i;
		
		for( i = 0; i< 9; i++){
			System.out.println("Digite um numero:");
			x = keyboard.nextDouble();
			d[i]=x;
			
		}
		System.out.println("Numeros Digitados:");
		for( i = 0; i< 9; i++){
	System.out.println( d[i]);}
	
		keyboard.close();
	}
}
