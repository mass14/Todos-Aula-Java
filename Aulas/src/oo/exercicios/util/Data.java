package oo.exercicios.util;

public class Data {
	public static boolean diferencaAnos(String comparador, String aComparar, int limiteAnos) {
		int[] dtInicial = conversor(comparador);
		int[] dtFinal = conversor(aComparar);
		
		int diasInicial = dtInicial[0] + (dtInicial[1] * 30) + (dtInicial[2] * 365);
		int diasFinal = dtFinal[0] + (dtFinal[1] * 30) + (dtFinal[2] * 365);
		int diasTotal = diasInicial - diasFinal;
		
		if(diasTotal > (limiteAnos * 365)) {
			return false;
		}
		
		return true;
	}
	
	// 21/10/2014
	private static int[] conversor(String data) {
		int[] i = new int[3]; // 0 == dia, 1 == mes, 2 == ano
		String[] dtStr = data.split("/");
		i[0] = Integer.parseInt(dtStr[0]);
		i[1] = Integer.parseInt(dtStr[1]);
		i[2] = Integer.parseInt(dtStr[2]);
		
		return i;
	}

}
