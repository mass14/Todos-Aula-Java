import java.util.*;
public class CorrExDoisSemTres {

	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		int[] valores = new int [10];
		
		System.out.println("Escreva uma sequencia de 10 numeros");
		for ( int i = 0; i< valores.length; i ++) {
			valores[i] = k.nextInt();
		}
		
		for (int i  = 9; i >=0; i--){
			System.out.println(valores [i]);
		}
		k.close();
	}

}
