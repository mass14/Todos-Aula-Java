
public class MetodosComParametrosInfinitos {

	public static void main(String[] args) {
				
		System.out.println(somaInteiros(10,10, 40, 30, 40, 55));
				
		int[] numero = {10,10, 40, 30, 40, 55};
		System.out.println(somaInteirosArray(numero));
		
	}
	public static int somaInteirosArray(int[] numeros){
		System.out.println(numeros.length);
		int soma = 0;
		for (int numero: numeros){
			soma += numero;
		}
		return soma;
	}
	public static int somaInteiros(int...numeros){
		System.out.println(numeros.length);
		int soma = 0;
		for(int numero : numeros) {
			if (numero % 2 == 0){
			soma += numero;
			}
		}
		return soma;
	}
}
