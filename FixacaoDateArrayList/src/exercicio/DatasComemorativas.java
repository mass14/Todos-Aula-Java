package exercicio;
/*- Crie uma classe que possui uma lista das datas comemorativas do mês de Novembro no Brasil 
(https://pt.wikipedia.org/wiki/Novembro) e imprima cada uma dessas datas no console.

- Entre os anos de 1400 e 2090, adicione todos os anos bissextos em uma lista chamada anosBissextos e 
depois imprima todos os valores desta lista. (Utilize um objeto do tipo GregorianCalendar para realizar esta 
verificação)

- Receba um data no teclado no formato dia/mes/ano e imprima no formato ano-mes-dia*/


import java.text.*;
import java.util.*;


public class DatasComemorativas {

    private ArrayList <Calendar> datas = new ArrayList<Calendar>();
	private Calendar finados = new GregorianCalendar(2014,  9,  2);
	private Calendar diaLinguaPort = new GregorianCalendar (2014, 12,  5);
	private Calendar procRepublica = new GregorianCalendar(2014, 12,  15);
	private Calendar diaBandeira = new GregorianCalendar( 2014, 12, 19);
	private Calendar conscienciaNegra = new GregorianCalendar(2014,  12,  20);
	private Calendar diaMusico = new GregorianCalendar(2014, 12, 22);
	
	public void datasAdicionadas(){
		datas.add(this.finados);
		datas.add(this.diaLinguaPort);
		datas.add(this.procRepublica);
		datas.add(this.diaBandeira);
		datas.add(this.conscienciaNegra);
		datas.add(this.diaMusico);
	}
	public String toString(){
		
			String str = "";
			for(Calendar i : datas) {
				str += i.toString() + "\n";
			}
			return str;
		
	}
	public ArrayList<Calendar> getDatas() {
		for(Calendar i : datas) {
			return datas;
	}
		return datas;
	}
}
/*finados.get(Calendar.DATE)+ "/" +  finados.get(Calendar.MONTH) + "/" + finados.get(Calendar.YEAR)  + " finados " + diaLinguaPort + 
" Dia do Radioamador Brasileiro, Dia do Técnico em Eletrônica, Dia Nacional da Língua Portuguesa " + 
procRepublica + " Proclamação da Republica " + diaBandeira + " Dia da Bandeira Brasileira no Brasil. " +
conscienciaNegra + " Dia da Consciência Negra no Brasil, feriado municipal em algumas cidades do país. Dia do Biomédico. "+
diaMusico + " Dia da Consciência Negra no Brasil, feriado municipal em algumas cidades do país. Dia do Biomédico. ");*/
		