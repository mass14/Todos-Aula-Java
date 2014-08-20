package oo.exercicios;

public class Filme {
	private String titulo;
	private int duracaoEmMinutos;
	
	public Filme(String titulo, int duracaoEmMinutos) {
		setTitulo(titulo);
		setDuracaoEmMinutos(duracaoEmMinutos);
	}
	
	public void exibirDuracaoEmHoras() {
		int horas = duracaoEmMinutos / 60;
		int minutos = duracaoEmMinutos % 60;
		System.out.printf("O filme %s possui %d horas e %d minutos de duração.\n", getTitulo(),
				horas, minutos);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}
	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	
	
	
	
	
}
