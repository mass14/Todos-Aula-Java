/*Escreva um trecho Java que exiba os valores de um array a double
numa mesma linha.*/
public class exerciciodois {
	public static void main(String[] args) {
		double arr[] = new double[10];
		double x = 10.099999;

		for (int i = 0; i <= 9; i++) {
			arr[i] = x;
			x--;
			System.out.printf("%.2f ", arr[i]);// Serve para imprimir somente 2 casas decimais

		}
	}
}
