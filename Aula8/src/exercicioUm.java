/*Para cada conjunto de valores abaixo, escreva o código Java,
usando laço(s), que preencha um array com os valores:
a) 10 9 8 7 6 5 4 3 2 1
b) 0 1 4 9 16 25 36 49 64 81 100
c) 1 2 3 4 5 10 20 30 40 50
d) 3 4 7 12 19 28 39 52 67 84*/

public class exercicioUm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Atividade a
		System.out.println("Atividade a)");
		int arr[] = new int[10];
		int x = 10;

		for (int i = 0; i <= 9; i++) {
			arr[i] = x;
			x--;
			System.out.print(arr[i] + " ");

		}
		System.out.println("\nAtividade b) ");
		// Atividade b
		int b[] = new int[11];

		for (int j = 0; j < 11; j++) {
			b[j] = j * j;
			System.out.print(b[j] + " ");
		}
		// uma outra possibilidade, porem com o for é melhor.
		System.out.println("\nAtividade bb) ");
		int bb[] = new int[11];

		int idx = 0;

		while (idx < 11) {
			bb[idx] = idx * idx;
			idx++;
		}
		idx = 0;
		
		while(idx<bb.length){
		System.out.print(bb[idx]+ " ");// poderia estar dentro do primeiro while.
		idx++;
		}

		System.out.println("\nAtividade c)");
		// Atividade c
		int c[] = new int[10];
		int y = 0;
		int z = 1;

		for (y = 0; y < c.length; y++) {
			if (y < 5) {
				c[y] = z;
				z++;
			} else {
				c[y] = (y - 4) * 10;

			}
			System.out.print(c[y] + " ");
		}
		System.out.println("\nAtividade d)");
		// Atividade d
		int d[] = new int[10];
		int i;
		for (i = 0; i < d.length; i++) {
			d[i] = i*i + 3;
			System.out.print(d[i] + " ");
		}
		
	}

}
