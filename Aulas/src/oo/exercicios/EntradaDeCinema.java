package oo.exercicios;

import oo.exercicios.util.Data;

public class EntradaDeCinema {
	private String dataDoFilme;
	private float horario;
	private int sala;
	private float valor;
	
	public EntradaDeCinema(String dataDoFilme, float horario, int sala, float valor) {
		this.dataDoFilme = dataDoFilme;
		this.horario = horario;
		this.sala = sala;
		this.valor = valor;
	}
	
	public void calculaDesconto(String dtNascimento) {
		if(Data.diferencaAnos(this.dataDoFilme, dtNascimento, 12)) {
			this.valor *= 0.5;
		}
	}
	
	public void calculaDesconto(String dtNascimento, int carteira) {
		boolean algumDesconto = false;
		int[] anos = {13, 14, 15};
		for(int a : anos) {
			if(Data.diferencaAnos(this.dataDoFilme, dtNascimento, a)) {
				this.valor *= 0.6;
				algumDesconto = true;
				break;
			}
		}
		
		if(!algumDesconto) {
			int[] anos2 = {16, 17, 18, 19, 20};
			for(int a : anos2) {
				if(Data.diferencaAnos(this.dataDoFilme, dtNascimento, a)) {
					this.valor *= 0.7;
					algumDesconto = true;
					break;
				}
			}
		}
		
		if(!algumDesconto) {
			this.valor *= 0.8;
		}
	}
	
	public void calculaDescontoHorario() {
		if(this.horario < 16) {
			this.valor *= 0.9;
		}
	}
	
	public String toString() {
		calculaDescontoHorario();
		
		String str = "";
		str += this.dataDoFilme + "\n";
		str += this.horario + "\n";
		str += this.sala + "\n";
		str += this.valor;
		
		
		return str;
	}
}







