package conta;

public class Conta {
	
		
		private int id;
		private double saldo;
		private double limite;
		private String nome;
		
		public Conta(int id, double limite, String nome) {
			this.id = 0;
			this.saldo = 0;
			this.limite = limite;
			this.nome = nome;
		}
		
		public Conta(int id, double saldo, double limite, String nome) {
			this.id = 0;
			this.saldo = 0;
			this.limite = limite;
			this.nome = nome;
		}
		public String toString() {
			String str = "";
			str += "Id: " + id;
			str += "\nNome: " + nome;
			str += "\nSaldo: " + saldo;
			str += "\nLimite: " + limite + "\n";
			
			return str;
		}
		
		public void credito(double valor) {
			this.saldo += valor;
		}
		
		public void debito(double valor) {
			if( (this.saldo + limite) >= valor) {
				this.saldo -= valor;
			} else {
				System.out.println("Pobre, vai codar!!");
			}
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getSaldo() {
			return saldo;
		}

		public double getLimite() {
			return limite;
		}

		public String getNome() {
			return nome;
		}
		
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public void setLimite(double limite) {
			this.limite = limite;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

}
