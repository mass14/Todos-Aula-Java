package variaveis;

/*
 * 
 */
public class Matrizes {

	// Arrays multidimensionais, são como os Arrays só que possuem mais de
	// uma dimensão! 
	public static void main(String[] args) {
		// inicializando
		int[][] duasDimensoes = new int[10][10]; // como se fosse uma tabela
		int[][] duasDimensoesFormaDois = { { 12, 22, 44}, { 22, 44, 22 }, {33, 15, 66} };
//		int[][][] tresDimensoes = new int[10][10][20]; // Só vi em jogos 3d e tretas matemáticas
//		int[][][][] quatroDimensoes = new int[2][2][2][2]; // nunca vi nem usei.
		// ...
		
		// Acessando os dados
		System.out.println(duasDimensoesFormaDois.length);
		System.out.println(duasDimensoesFormaDois[0]);
		System.out.println(duasDimensoesFormaDois[0].length);
		System.out.println(duasDimensoesFormaDois[0][2]);
		System.out.println(duasDimensoesFormaDois[1][0]);
		System.out.println(duasDimensoesFormaDois[2][1]);
		
		
		// Navegando
		for(int i = 0; i < duasDimensoesFormaDois.length; i++) {
			for(int j = 0; j < duasDimensoesFormaDois[i].length; j++) {
				System.out.printf("[%d][%d]: %d\n", i, j, duasDimensoesFormaDois[i][j]);;
			}
		}
		
	}

}
