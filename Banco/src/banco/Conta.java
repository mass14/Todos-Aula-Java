package banco;

public abstract class Conta {
	private static int novaConta;

	private int identificador = 0;
	private double saldo = 0;
	private double limite;
	private String dono;

	public Conta(double limite, String dono) {
		novaConta++;
		identificador = novaConta;
		this.limite = limite;
		this.dono = dono;
	}

	public String toString() {
		String str = "";
		str += "Id: " + identificador;
		str += "\n Nome: " + dono;
		str += "\n Saldo: " + saldo;
		str += "\n Limite: " + limite + "\n";
		return str;
	}

	public double debito(double debito) {
		if (debito <= (this.saldo + limite)) {
			this.saldo -= debito;
		} else {
			System.out.println("saldo insuficiente");
		}
		return saldo;

	}

	public double getLimite() {
		return limite;
	}

	public String getDono() {
		return dono;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
	public double credito(double credito) {
		this.saldo += credito;
		return saldo;
	}
}
