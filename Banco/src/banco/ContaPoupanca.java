package banco;

public class ContaPoupanca extends Conta{
	private double juros;
	public ContaPoupanca(double limite, String dono) {
		super(limite, dono);
		this.juros = 1.0056f;
	}
	
	
	public void Juros(){
		super.setSaldo(super.getSaldo()*juros);
	}

}
