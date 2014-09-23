public class OperadoresAritimeticos {

	public static void main(String[] args) {

		int x = 10;

		System.out.println(x++);// imprime depois incrementa
		System.out.println(x--);// imprime depois decrementa
		System.out.println(x); // novo valor de x
		System.out.println(++x);// incrementa e depois imprime
		System.out.println(--x);// incrementa e depois imprime

		String tipo = x % 2 == 0 ? "par" : "impar";// operador ternario - se mod
													// de x/2 = a 0 imrpime par
													// sen�o imprime impar
		System.out.println(tipo);

	}

}
