package oo.exercicios;

/*
 * Edificio
Atributos: cor, totalDePortas, totalDeAndares, portas[]
Métodos: void pinta(String s), int quantasPortasEstaoAbertas(), 
         void adicionaPorta(Porta p), int totalDePortas(), 
         void adicionarAndar(), int totalDeAndares()

Para testar, crie um edifício, pinte‐o. Crie seis portas e coloque‐as 
no edifício através do método adicionaPorta, abra e feche‐as como desejar.
Utilize o método quantasPortasEstaoAbertas para imprimir o número de 
portas abertas e o método totalDePortas para imprimir o total de portas
em seu edifício. Cria alguns andares utilizado o método adicionarAndar e
retorne o número total de andares utilizando o método totalDeAndares.
 */
public class Edificio {
	
	private String cor;
	private int totalDePortas;
	private int totalDeAndares;
	private Porta[] portas;
	
	public void adicionarPorta(Porta p) {
		if(!(totalDePortas >= portas.length)) {
			portas[this.totalDePortas] = p;
			this.totalDePortas++;
		}
	}
	
//	public int quantasPortasEstaoAbertas() {
//		
//	}
	
	public String getCor() {
		return cor;
	}
	
	public void pinta(String cor) {
		this.cor = cor;
	}
	
	public int totalDePortas() {
		return this.totalDePortas;
	}
	
	public int quantasPortasEstaoAbertas() {
		int c = 0;
		for(int i = 0; i < totalDePortas; i++) {
			if(portas[i].estaAberta()) {
				c++;
			}
		}
		
		return c;
	}
	
	public int totalDeAndares() {
		return this.totalDeAndares;
	}
	
	public void adicionarAndar() {
		this.totalDeAndares += 1;
	}
	
	public Porta[] getPortas() {
		return portas;
	}
	
	public void abrirPortas(int ... idx) {
		for(int i : idx) {
			if(i < totalDePortas) {
				portas[i].abre();
			}
		}
	}
	
	public Porta getPorta(int idx) {
		if(idx < totalDePortas) {
			return portas[idx];
		}
		
		return null;
	}
	
	public void setPortas(Porta[] portas) {
		this.portas = portas;
	}
	
}
