import java.util.*;
public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o mes (em numero):");
		int mes = keyboard.nextInt();
		
		String mesString = "";
		
		switch (mes){
		case 1:
			mesString = "Janeiro";
			break;
		case 2:
			mesString = "Fevereiro";
			break;
		case 3:
			mesString = "Março";
			break;
		case 4:
			mesString = "Abril";
			break;
		case 5:
			mesString = "Maio";
			break;
		case 6:
			mesString = "Junho";
			break;
		case 7:
			mesString = "Julho";
			break;
		case 8:
			mesString = "Agosto";
			break;
		case 9:
			mesString = "Setembro";
			break;
		case 10:
			mesString = "Outubro";
			break;
		case 11:
			mesString = "Novembro";
			break;
		case 12:
			mesString = "Dezembro";
			break;
		default:
			mesString = "Qual calendário você esta usando?";
		}
		System.out.println(mesString);
		
		keyboard.close();
			
	}

}
