package trabalhoUm;

public class TestValores {
	public static void correcao(int recebido, int esperado) {
		boolean resultado = (recebido == esperado);
		impressaoCorrecao(resultado, String.valueOf(esperado),
				String.valueOf(recebido), "int");
	}

	public static void correcao(double recebido, double esperado) {
		boolean resultado = (recebido == esperado);
		impressaoCorrecao(resultado, String.valueOf(esperado),
				String.valueOf(recebido), "double");
	}

	public static void correcao(boolean recebido, boolean esperado) {
		boolean resultado = (recebido == esperado);
		impressaoCorrecao(resultado, String.valueOf(esperado),
				String.valueOf(recebido), "boolean");
	}

	public static void correcao(float recebido, float esperado) {
		boolean resultado = (recebido == esperado);
		impressaoCorrecao(resultado, String.valueOf(esperado),
				String.valueOf(recebido), "float");
	}

	public static void correcao(String recebido, String esperado) {
		boolean resultado = recebido.equals(esperado);
		impressaoCorrecao(resultado, String.valueOf(esperado),
				String.valueOf(recebido), "String");
	}

	private static void impressaoCorrecao(boolean resultado, String esperado,
			String recebido, String tipoDado) {
		if (resultado) {
			System.out.printf("[%s] Correto!\n", tipoDado);
		} else {
			System.out.printf(
					"Correção esperava %s, mas você retornou %s\n",
					esperado, recebido);
		}
	}
}