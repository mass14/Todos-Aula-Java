import java.util.Scanner;


public class exercicioUm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner k = new Scanner(System.in);
			float numDigitado;
			
			System.out.print("Digite um numero:");
			numDigitado = k.nextInt();
			boolean resultado = isNull(numDigitado);
			
			System.out.println(resultado ? "nulo" : "não nulo");//se resultado = a true imprime nulo, se não imprime não nulo
			k.close();
		}
		public static boolean isNull(float num){
			boolean numm = false;
			if(num == 0.0f){
				numm = true;
			}
			return numm;
			//poderia ser só return numm==0.0f, pois se for a condicao for verdadeira 
			//retorna true senão retorna false.
		}
	}


