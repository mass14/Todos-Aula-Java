import java.util.*;
public class exercicioZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		float numDigitado;
		
		System.out.print("Digite um numero :");
		numDigitado = k.nextInt();
		boolean resultado = isPositive(numDigitado);
		System.out.println(resultado ? "positivo" : "negativo");// se isPositive for igual a true, imprime positivo
		k.close();
	}
	public static boolean isPositive(float num){
		boolean numm = false;
		if(num >= 0){
			numm = true;
		}
		return numm;
		
	}
}
