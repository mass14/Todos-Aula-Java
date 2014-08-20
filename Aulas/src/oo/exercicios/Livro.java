package oo.exercicios;

public class Livro {
	private String titulo;
	private int qtdPaginas;
	private int paginasLidas;
	
	public Livro(String titulo, int qtdPaginas, int paginasLidas) {
		setTitulo(titulo);
		setQtdPaginas(qtdPaginas);
		setPaginasLidas(paginasLidas);
	}
	
	public Livro(String titulo) {
		setTitulo(titulo);
	}
	
	public void verificarProgresso() {
		double porcentagem = paginasLidas * 100.0 / qtdPaginas;
		System.out.printf("Você já leu %.2f%% por cento do livro.\n", porcentagem);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	public int getPaginasLidas() {
		return paginasLidas;
	}
	public void setPaginasLidas(int paginasLidas) {
		this.paginasLidas = paginasLidas;
	}
	
	
}
