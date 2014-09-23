package exerciciorevisao;

import java.util.Scanner;
// Exercício: Digitar 6 números e dizer quantos números são pares e quantos são ímpares.
public class ExQuatro {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		int numero = 0;
		int qtdpar = 0;
		int qtdimpar = 0;
		
		for (int i = 0; i<=5; i++){
			System.out.println("Digite um numero:");
			numero = k.nextInt();
			if (numero % 2 ==0){
				qtdpar ++;
			}else if(numero % 2 >0){
				qtdimpar ++;
			}
		}
		System.out.println(qtdpar + "pares; " + qtdimpar + "impares;");
		

	}

}
