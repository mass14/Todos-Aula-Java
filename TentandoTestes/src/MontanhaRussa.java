
public class MontanhaRussa {
private int lugares;
private float velocidade;
private float velocidadeAtual;

private float comprimento;
private int loopings;

	public boolean recebePassageiros (int lugaresAOcupar){
		if(this.lugares >  lugaresAOcupar ){
		this.lugares = lugaresAOcupar;
		return true;
		}else{
			return false;
		}
	}
	public float getVelocidadeAtual() {
		return velocidadeAtual;
	}
	public void movimenta(float velocidade) {
		this.velocidadeAtual = velocidade;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public int getLoopings() {
		return loopings;
	}

	public void setLoopings(int loopings) {
		this.loopings = loopings;
	}
}
