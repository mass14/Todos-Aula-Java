

/*
 * Com uma taxa de inflação de 5,91% ao ano, uma família que ganha um salário mínimo de 
 * R$724,00 e tem gastos com sua cesta básica R$351,46, gastos com deslocamente de R$60.50 
 * e gastos com a moradia de R$350,00 (agua, luz, telefone, alugel).

 * A partir destes dados, informe (imprima na tela) a progressão ano a 
 * ano (de 2014 até 2024) de todo dinheiro que a família conseguiu acumular naquele ano. 

 * Informe também (imprima na tela) também o valor do primeiro ano que 
 * a família conseguiu acumular e o valor acumulado no último ano.

 * Informe também (imprima na tela) o total de valores acumulados ao final dos 10 anos
 */
public class OrcamentFamiliar {
	private static double inflacao = 1.0591;
	private static double dissidio = 1.05;
	private static double salario = 724.0;
	private static double bolsaFamilia = 70.0;
	private static double gastoCesta = 351.46;
	private static double gastoDeslocamento = 60.5;
	private static double gastoMoradia = 350.0;
	private static double acumuladoTotal = 0.0;

	private static void calculaSaldo(double[] saldoAnual) {
		for (int i = 0; i < saldoAnual.length; i++) {
			double gastosTotais = gastoCesta + gastoDeslocamento + gastoMoradia;

			if (i == 0) {
				saldoAnual[i] = ((salario + bolsaFamilia) * 12)
						- (gastosTotais * 12) + salario;
			} else {
				salario *= dissidio;
				saldoAnual[i] = ((salario + bolsaFamilia) * 12)
						- (gastosTotais * Math.pow(inflacao, i)) * 12.0
						+ salario;
			}
			
			acumuladoTotal += saldoAnual[i];
		}
	}
	
	private static void imprimeAcumuladoEntreOsAnos(double[] saldoAnual) {
		System.out.println("Dinheiro acumulado durante os anos");
		double acumuladoDoAno = 0.0;
		for (int i = 0; i < saldoAnual.length; i++) {
			acumuladoDoAno += saldoAnual[i];
			System.out.printf("%d : R$%.2f | R$%.2f\n", (2014 + i), acumuladoDoAno,
					saldoAnual[i]);
		}
	}
	
	private static void imprimeAcumuladoPrimeiroAno(double[] saldoAnual) {
		System.out.printf("\nAcumulado Primeiro Ano: %.2f", saldoAnual[0]);
	}
	
	private static void imprimeAcumuladoUltimoAno(double[] saldoAnual) {
		System.out.printf("\nAcumulado Último Ano: %.2f",
				saldoAnual[saldoAnual.length - 1]);
	}
	
	private static void imprimeAcumuladoFinal(double[] saldoAnual) {
		System.out.printf("\n\nAcumulado Após %d anos: %.2f", saldoAnual.length - 1, acumuladoTotal);
	}

	public static void main(String[] args) {
		double[] saldoAnual = new double[11];

		calculaSaldo(saldoAnual);
		
		imprimeAcumuladoEntreOsAnos(saldoAnual);
		imprimeAcumuladoPrimeiroAno(saldoAnual);
		imprimeAcumuladoUltimoAno(saldoAnual);
		imprimeAcumuladoFinal(saldoAnual);
	}
}
