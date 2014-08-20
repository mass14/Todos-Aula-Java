package mapa;

import java.util.*;

public class Mapa {

	private int[][] dimensao;
	private int[][] obstaculos;

	public Mapa(int largura, int altura, int numObstaculos) {
		Random r = new Random();
		this.dimensao = new int[largura][altura];
		this.obstaculos = new int[numObstaculos][2];

		int percorridos = 0;
		while (percorridos < numObstaculos) {
			int x = r.nextInt(largura);
			int y = r.nextInt(altura);

			if (obstaculoValido(x, y)) {
				this.obstaculos[percorridos][0] = x;
				this.obstaculos[percorridos][1] = y;
				percorridos++;
			}

		}

	}

	public String toString() {
		String str = "mapa\n";
		for (int i = 0; i < dimensao.length; i++) {
			for (int j = 0; j < dimensao[0].length; j++) {
				for (int w = 0; w < obstaculos.length; w++){
					if (obstaculos[w][0] == i && obstaculos[w][1] == j) {
						str += "0";
					}
				str += ".";

			}
			}
			str += "\n";
		}
		return str;
	}

	private boolean obstaculoValido(int x, int y) {
		int[][] comparacoes = { { 0, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 1, 1 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int i = 0; i < this.obstaculos.length; i++) {
			for (int j = 0; j < comparacoes.length; j++) {
				if (j == 8 && x == 0 && y == 0) {
					continue;
				}
				if (obstaculos[i][0] == (comparacoes[j][0] + x)
						&& obstaculos[i][1] == (comparacoes[j][1] + y)) {
					return false;
				}
			}

		}

		return true;

	}
}