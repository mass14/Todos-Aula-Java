package oo.jogo;

import java.util.Random;

/*
 * O Mapa possui 2 atributos:
 * - Dimensão é uma matriz de tamanho definido durante a construção da 
 *  classe
 * - Obstáculos, são array contendo, ? posições [x,y] definidas pelo 
 *   construtor, tendo como limite as dimensões do mapa.
 * 
 * Os obstáculos devem ser gerados assim que o mapa for construído. 
 * Não podendo haver um obstáculo do lado do outro.
 * 
 * Crie também um método público toString que retorna uma String
 * esse método deve imprimir . (ponto) para localizações com zero,
 * e 0 (zero) para locais com obstáculos.
 * 
 */
public class Mapa {
	private int[][] dimensao;
	private int[][] obstaculos;
	
	public Mapa(int largura, int altura, int numObstaculos) {
		this.dimensao = new int[largura][altura];
		this.obstaculos = new int[numObstaculos][2];
		// .... gerar
		Random gerador = new Random();
		
		int percorridos = 0;
		while(percorridos < numObstaculos) {	
			int x = gerador.nextInt(largura);
			int y = gerador.nextInt(altura);
			
			if(obstaculoValido(x, y)) {
				this.obstaculos[percorridos][0] = x;
				this.obstaculos[percorridos][1] = y;
				percorridos++;
			}
		}
	}
	
	private boolean obstaculoValido(int x, int y) {
		int[][] comparacoes = {{0, 0}, {-1,-1}, {-1, 1}, {1, -1}, {1,1},
				               {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		for(int i = 0; i < this.obstaculos.length; i++) {
			for(int j = 0; j < comparacoes.length; j++) {
				if(j == 0 && x == 0 && y == 0) {
					continue;
				}
				
				if(obstaculos[i][0] == (comparacoes[j][0] + x) &&
						obstaculos[i][1] == (comparacoes[j][1] + y)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String toString() {
		String str = "";
		
		for(int i = 0; i < this.dimensao.length; i++) {
			for(int j = 0; j < this.dimensao[0].length; j++) {
				boolean obstaculo = false;
				
				for(int w = 0; w < this.obstaculos.length; w++) {
					if(this.obstaculos[w][0] == i && 
							this.obstaculos[w][1] == j) {
						obstaculo = true;
					}
				}
				
				if(obstaculo){	
					str += "0";
				} else {
					str += ".";
				}	
			}
			str += "\n";
		}
		
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}