package oo.jogo;

public class Posicao {
	private int x;
	private int y;
	
	public Posicao(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void moverCima(int movimento) {
		setY(getY() + movimento); 
	}
	
	public void moverBaixo(int movimento) {
		setY(getY() - movimento);
	}
	
	public void moverDireita(int movimento) {
		setX(getX() + movimento);
	}
	
	public void moverEsquerda(int movimento) {
		setX(getX() - movimento);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
