package heroi;

public class Posicao {

	private int posicaoX;
	private int posicaoY;

	public Posicao(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	public void moverCima(int move) {
		this.posicaoY = this.posicaoY + move;

	}

	public void moverBaixo(int move) {
		this.posicaoY = this.posicaoY - move;
	}

	public void moverDireita(int move) {
		this.posicaoX = this.posicaoX + move;
	}

	public void moverEsquerda(int move) {
		this.posicaoX = this.posicaoX -move;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
}
