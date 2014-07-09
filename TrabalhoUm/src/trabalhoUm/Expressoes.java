package trabalhoUm;

import java.math.*;

public class Expressoes {

	public static void main(String[] args) {

		// some dois inteiros: 10 e 20. Persista o resultado em uma variavel
		// chamada 'somaIntieros'
		int somaInteiros;
		somaInteiros = 10 + 20;
		TestValores.correcao(somaInteiros, 30);

		// subtraia 50,3 de 30,2. Persista o resultado em uma variável chamada
		// 'subtraido'
		BigDecimal valor1 = new BigDecimal(30.2);
		BigDecimal valor2 = new BigDecimal(50.3);
		double subtraido = valor2.subtract(valor1).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
		TestValores.correcao(subtraido, 20.1);

		// crie uma expressão que resolva: a + 40 - b / 10. Salve na variavel
		// chamada expressaoUm
		double b = 10;
		double a = 5;
		double expressaoUm;
		expressaoUm = (a + 40) - b / 10;
		TestValores.correcao(expressaoUm, 44);

		// verifique se um 10 é maior ou igual que 20 e salve em uma variável
		// chamada expressaoDois
		boolean expressaoDois = 10 >= 20;
		TestValores.correcao(expressaoDois, false);

		// verifique se um 10 é menor ou igual que 10 e salve em uma variável
		// chamada expressaoTres
		boolean expressaoTres= 10 <= 10;

		TestValores.correcao(expressaoTres, true);

		// verifique se um 10 é maior que 10 e salve em uma variável chamada
		// expressaoQuatro
		boolean expressaoQuatro = 10 < 10;

	
		TestValores.correcao(expressaoQuatro, false);

		// verifique se um 10 é maior que 10 e salve em uma variável chamada
		// expressaoCinco a valor inverso
		boolean expressaoCinco = 10 > 10;
		expressaoCinco =! false;	
		
		TestValores.correcao(expressaoCinco, true);

		// Concatene as duas String abaixo (de forma que não uma palavra não
		// fique grudada na outra)
		// e salve em uma variável chamada frase
		String casa = "Era uma casa";
		String cadeira = "sem cadeiras";
		String frase;
		frase = casa + " " + cadeira;
		TestValores.correcao(frase, "Era uma casa sem cadeiras");
	}

}