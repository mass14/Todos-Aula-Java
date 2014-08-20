package imovel;

public class Velho extends Imovel {
	private double decPreco;
	
	public Velho(String endereco, double preco, double decPreco) {
		super(endereco, preco);
		this.decPreco = decPreco;
	}
	public void setDecPreco(double decPreco){
		this.decPreco = decPreco;
	}
	public double getDecPReco(){
		return this.decPreco;
	}
	public void subPreco(){
		super.setPreco(getPreco() - this.decPreco);
	}
	public String toString(){
		String str = "" + super.getPreco();
		return str;
	}
}
