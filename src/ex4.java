import java.util.Scanner;
public class ex4 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		String frase = scanner.nextLine();
		int caracteresPorSubstring = 5;
		double quatidadeDeSubstrings = Math.ceil((frase.length() + caracteresPorSubstring - 1) / caracteresPorSubstring);
		String[] substrings = retornaSubstrings(frase, caracteresPorSubstring, (int)quatidadeDeSubstrings);
		String[] substringsCriptografadas = retornaSubstringsCriptografadas(substrings, caracteresPorSubstring, (int)quatidadeDeSubstrings+1);
		imprimeSubstringsCriptografadas(substringsCriptografadas);
	}

	public static String[] retornaSubstringsCriptografadas(String[] substrings, int caracteresPorSubstring, int quatidadeDeSubstrings){
		String substring = "";
		int k = 0;
		String[] substringsCriptografadas = new String[quatidadeDeSubstrings];
		for(int i=0; i<caracteresPorSubstring; i++){
			for(int j=0; j<substrings.length; j++){
				substring += (substrings[j].charAt(i));
				if (j == substrings.length - 1) {
					substring += "*";
					substringsCriptografadas[k] = substring;
					k++;
					substring = "";
				}
			}
		}
		return substringsCriptografadas;
	}

	// public static void restauraSubstringsCriptografadas(String[] substringsCriptografadas) {
	// 	String string = "";
	// 	for (int i = 0; i < substringsCriptografadas[i].length(); i++) {
	// 		for (int j = 0; j < substringsCriptografadas.length; j++){
	// 			string += s
	// 		}
	// 	}
	// }

	public static void imprimeSubstringsCriptografadas(String[] substringsCriptografadas){
		for (String substring : substringsCriptografadas){
			System.out.println(substring);
		}
	}

	public static String[] retornaSubstrings(String frase, int caracteresPorSubstring, int quatidadeDeSubstrings){
		String[] substrings = separaStringEmSubStrings(frase, caracteresPorSubstring, quatidadeDeSubstrings);
		return substrings;
	}

	public static String[] separaStringEmSubStrings(String frase, int caracteresPorSubstring, int quatidadeDeSubstrings){
		int tamanhoDaFrase = frase.length();
		String[] substrings = new String[quatidadeDeSubstrings];
		for (int i=0; i<quatidadeDeSubstrings; i++){
			substrings[i] = frase.substring(i*caracteresPorSubstring, Math.min((i + 1) * caracteresPorSubstring, tamanhoDaFrase));
			if (substrings[i].length() < caracteresPorSubstring){
				substrings[i] = adionaEspacosEmBranco(substrings[i], caracteresPorSubstring);
			}
		}
		return substrings;
	}

	public static String adionaEspacosEmBranco(String substring, int caracteresPorSubstring){
		return substring + " ".repeat(caracteresPorSubstring - substring.length());
	}

	public static void retornaMensagemOriginalAPartirDeMensagemCriptografada() {
		
	}


}
