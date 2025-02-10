import java.util.Scanner;
public class ex3 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		String frase = scanner.nextLine();
		int caracteresPorSubstring = 5;
		String[] substrings = separaStringsEmSubstringsERetorna(frase, caracteresPorSubstring);
		imprimeSubstringsCriptografadas(substrings, caracteresPorSubstring);
	}

	public static void imprimeSubstringsCriptografadas(String[] substrings, int caracteresPorSubstring){
		for(int i=0; i<caracteresPorSubstring; i++){
			for(int j=0; j<substrings.length; j++){
				System.out.print(substrings[j].charAt(i));
				if (j == substrings.length - 1) System.out.print("*");
			}
		}
	}

	public static String[] separaStringsEmSubstringsERetorna(String frase, int caracteresPorSubstring){
		int tamanhoDaFrase = frase.length();
		int quatidadeDeSubstrings = (tamanhoDaFrase + caracteresPorSubstring - 1) / caracteresPorSubstring;
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
}
