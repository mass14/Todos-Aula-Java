
public class ContaBancaria {
	public  double saldo = 0;
	
	public  void debito(double ... valores){
		for (double valor : valores){
			saldo -= valor;
		}
	}
	public  void credito(double ... valores){
		saldo = soma (saldo, valores);
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	private double soma (double inicial, double ... valores){
		for (double valor : valores){
			inicial +=valor;
		}
			return inicial;
		
	}
}
