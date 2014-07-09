/*Em vez de utilizar uma String para representar a data, crie uma outra classe, chamada Data. E
 * la possui 3 campos int, para dia, mês e ano. Faça com que seu funcionário passe a usá-la.
*/
public class Data {

	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	public String dataPadrao (){
		return dia + "/" + mes + "/" + ano;
		
	}
}
