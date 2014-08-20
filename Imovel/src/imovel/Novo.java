package imovel;

public class Novo extends Imovel {
	private double addPreco;

	public Novo(String endereco, double preco, double addPreco) {
		super(endereco, preco);
		this.addPreco = addPreco;
	}

	public void aumentaPreco() {
		super.setPreco(getPreco() + this.addPreco);
	}

	/*public String toString() {
		String str = " " + this.addPreco;
		return str;
	}*/

	public double getAddPreco() {
		return addPreco;
	}

	public void setAddPreco(double addPreco) {
		this.addPreco = addPreco;
	}

	

}
