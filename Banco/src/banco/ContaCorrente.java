package banco;

public class ContaCorrente extends Conta{
	private float taxaMensal;
	
	public ContaCorrente ( double limite, String dono) {
		super(limite, dono);
		this.taxaMensal = 9;
	}
		
	public ContaCorrente ( double limite, String dono, float taxaMensal) {
		super(limite, dono);
		this.taxaMensal = taxaMensal;
		
	}
	
	public void CobraTaxa(){
		super.setSaldo(getSaldo() - this.taxaMensal);
	}
	
}
