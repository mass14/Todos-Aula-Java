package ingresso;

public class VIP extends Ingresso {
	private double adicional;

	public VIP(double valor, double adicional) {
		super(valor);
		this.adicional = adicional;
	}

	public double getValor() {
		return super.getValor() + this.adicional;
	}

	public double getAdicional() {
		return adicional;
	}

	public void setAdicional(double adicional) {
		this.adicional = adicional;
	}

}
