/*1-) Modele um funcionário. Ele deve ter o nome do funcionário, o departamento onde trabalha, seu salário, a data de entrada no banco (String), seu RG (String), e um valor booleano que indique se o funcionário está na empresa no momento ou se já foi embora. 

Você deve criar alguns métodos de acordo com o que você sentir necessidade. Além deles, crie um método bonifica que aumenta o salario do funcionário de acordo com o parâmetro passado como argumento. Crie também um método demite que não recebe parâmetro algum, só modifica o valor booleano indicando que o funcionário não trabalha mais aqui.

A idéia aqui é apenas modelar, isto é, só identifique que informações são importantes, e o que um funcionário faz.

---------------

Transforme o modelo acima em uma classe Java. Teste-a, usando uma outra classe que tenha o main. Você deve criar a classe do funcionário chamada Funcionario, e a classe de teste você pode nomear como quiser. A de teste deve possuir o método main.

---------------

Crie um método mostra(), que não recebe nem devolve parâmetro algum, e simplesmente imprime todos os atributos do nosso funcionário. Dessa maneira você não precisa ficar copiando e colando um monte de System.out.println() para cada mudança e teste que fizer com cada um de seus funcionários, você simplesmente vai fazer:

Funcionario f1 = new Funcionario():
// chamadas com f1....
f1.mostra();

Veremos mais a frente o método toString, que é uma solução muito mais elegante para mostrar a representação de um objeto como String, além de não jogar tudo pro System.out (só se você desejar).

------------------

Construa dois funcionários com o new, e compare-os com o ==. E se eles 
tiverem os mesmos atributos?

------------------

Crie duas referências para o mesmo funcionário, compare-os com o ==. Tire suas conclusões. Para criar duas referências pro mesmo funcionário:

Funcionario f1 = new Funcionario():
Funcionario f2 = f1;

------------------

  
  */
public class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private Data dataAdmissao;
	private String rg;
	private boolean admitido;
	
	
	
	public void mostra(){
		System.out.println("\nFuncionário: " + this.nome + "\nDepartamento: " +  this.departamento + "\nSalario Atual: " + this.salario + "\nData de Admissão: " + this.dataAdmissao.dataPadrao() + "\nRG: " + this.rg + "\nDemitido: " + this.admitido);
	}
	public void demite(){
		this.admitido = true;
	}
	public void bonifica(double aumento){
		setSalario(this.salario + aumento);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Data getAdmissao() {
		return dataAdmissao;
	}
	public void setAdmissao(Data admissao) {
		this.dataAdmissao = admissao;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void VerificaDuplicidade (Funcionario outro){
		if (this.nome.equalsIgnoreCase(outro.nome)||this.nome!= null && this.departamento.equalsIgnoreCase(outro.departamento) ||this.departamento!= null && this.rg.equals(outro.rg) || this.rg!= null && this.salario ==  outro.salario &&  this.dataAdmissao == outro.dataAdmissao || this.dataAdmissao!= null){
			System.out.println("Este funcionário já está cadastrado!");
		}
	}
} 
