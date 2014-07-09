package trabalhoUm;

public class Condicionais {

	public static void main(String[] args) {

		// Crie um método que que verifiquei se um número é divisível por 5
		// ou
		// não.
		// ele deve se chamar divisivelCinco e ter com parametro número double
		// e
		// deve
		// retornar true (para divisível) ou false (para não divisível)
		TestValores.correcao(divisivelCinco(5), true);
		TestValores.correcao(divisivelCinco(6), false);
		TestValores.correcao(divisivelCinco(55), true);
		TestValores.correcao(divisivelCinco(15), true);
		TestValores.correcao(divisivelCinco(85), true);
		TestValores.correcao(divisivelCinco(83), false);

		// Para doar sangue é necessário ter entre 18 e 67 anos.
		// Crie um método chamado chamado eDoador que recebe a idade como
		// parametro.
		// Retorne se uma pessoa pode ou não doar sangue (true ou false)
		TestValores.correcao(eDoador(5), false);
		TestValores.correcao(eDoador(25), true);
		TestValores.correcao(eDoador(33), true);
		TestValores.correcao(eDoador(68), false);
		TestValores.correcao(eDoador(18), true);
		TestValores.correcao(eDoador(67), true);
		TestValores.correcao(eDoador(44), true);
		TestValores.correcao(eDoador(90), false);
		TestValores.correcao(eDoador(11), false);
		TestValores.correcao(eDoador(55), true);

		// Crie um método que verifique se um ano é bissexto ou não.
		// Chame o método de bissexto ele recebe o ano como parametro e retorna
		// true para anos bissextos
		// e false para anos não bissextos.
		int[] anosBissextos = { 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016,
				2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 400, 800,
				1200, 1704, 2000, 2400 };

		int[] anosNaoBissextos = { 500, 600, 1500, 1800, 1900, 2100, 2200, 2300 };

		for (int ano : anosBissextos) {
			TestValores.correcao(bissexto(ano), true);
		}

		for (int ano : anosNaoBissextos) {
			TestValores.correcao(bissexto(ano), false);
		}
	}

	public static boolean divisivelCinco(double a) {
		boolean divisivel = false;
		if (a % 5 == 0) {
			divisivel = true;
		}
		return divisivel;
	}

	public static boolean eDoador(int b) {
		boolean doador = false;
		if (b >= 18 && b <= 67) {
			doador = true;
		}
		return doador;
	}

	public static boolean bissexto(int ano) {
		boolean anoBissexto = false;
		if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
			anoBissexto = true;
		}
		return anoBissexto;
	}

}