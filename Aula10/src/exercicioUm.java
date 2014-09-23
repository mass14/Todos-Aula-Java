import java.util.Scanner;


public class exercicioUm {

	public static void main(String[] args) {
				
			Scanner k = new Scanner(System.in);
			float numDigitado;
			
			System.out.print("Digite um numero:");
			numDigitado = k.nextInt();
			boolean resultado = isNull(numDigitado);
			
			System.out.println(resultado ? "nulo" : "n�o nulo");//se resultado = a true imprime nulo, se n�o imprime n�o nulo
			k.close();
		}
		public static boolean isNull(float num){
			boolean numm = false;
			if(num == 0.0f){
				numm = true;
			}
			return numm;
			//poderia ser s� return numm==0.0f, pois se for a condicao for verdadeira 
			//retorna true sen�o retorna false.
		}
	}


