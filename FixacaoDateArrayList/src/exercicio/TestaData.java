package exercicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TestaData {

	public static void main(String[] args) {
		datasNovembro();
		//imprimeAnosBissextos();
		converteData();
	}
	
	public static void converteData(){
		Scanner k = new Scanner(System.in);
		System.out.println("Digite uma data: ");
		String dtStr = k.next();
		
		SimpleDateFormat dfIn = new SimpleDateFormat ("dd/MM/yyyy");
		SimpleDateFormat dfOut = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dat;
		try {
			dat = dfIn.parse(dtStr);
			System.out.println(dat);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		try {
			Date data = dfIn.parse(dtStr);
			System.out.println(dfOut.format(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void imprimeAnosBissextos(){
		ArrayList<Integer> anosBissextos = new ArrayList<>();
		GregorianCalendar gc = new GregorianCalendar();
		
		for(int ano = 1400; ano <= 2090; ano++) { 
			if (gc.isLeapYear(ano)){
				anosBissextos.add(ano);
			}
		}
		for (int ano : anosBissextos){
			System.out.println(ano);
		}
	}
	
	
	
	
	public static void datasNovembro(){
		ArrayList<DataComemorativa> novembro = new ArrayList<>();
		novembro.add(new DataComemorativa("Finados", "2/11"));
		
		for (DataComemorativa data : novembro){
			System.out.println(data);
		}
	}
}
class DataComemorativa{
	String desc;
	String data;
	
	public DataComemorativa(String desc, String data){
		this.desc = desc;
		this.data = data;
	}
	public String toString(){
		return data + " - "  + desc;
	}
}