import java.util.Scanner;

public class ex4 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String frase = leFrase("Digite a frase: ");
		int caracteresPorSubstring = 5;
		int quatidadeDeSubstrings = calculaQuantidadeDeSubstrings(caracteresPorSubstring, frase);
		String[] substrings = retornaSubstrings(frase, caracteresPorSubstring, quatidadeDeSubstrings);
		String[] substringsCriptografadas = retornaSubstringsCriptografadas(substrings, caracteresPorSubstring, quatidadeDeSubstrings);
		imprimeArrayDeStrings(substringsCriptografadas);
		scanner.close();
	}

	public static int calculaQuantidadeDeSubstrings(int caracteresPorSubstring, String frase){
		return (int) Math.ceil((double) frase.length() / caracteresPorSubstring);
	}

	public static String leFrase(String mensagem){
		System.out.print(mensagem);
		return scanner.nextLine();
	}

	public static int leNumero(String mensagem) {
		System.out.print(mensagem);
		int numero = scanner.nextInt();
		return numero;
	}

	public static String[] retornaSubstringsCriptografadas(String[] substrings, int caracteresPorSubstring,
			int quatidadeDeSubstrings) {
		String substring = "";
		int k = 0;
		String[] substringsCriptografadas = new String[caracteresPorSubstring];
		for (int i = 0; i < caracteresPorSubstring; i++) {
			for (int j = 0; j < substrings.length; j++) {
				if (i < substrings[j].length()) {
					substring += substrings[j].charAt(i);
				} else {
					substring += " ";
				}
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

	public static void imprimeArrayDeStrings(String[] arrayDeStrings) {
		for (String string : arrayDeStrings) {
			System.out.println(string);
		}
	}

	public static String[] retornaSubstrings(String frase, int caracteresPorSubstring, int quatidadeDeSubstrings) {
		String[] substrings = separaStringEmSubStrings(frase, caracteresPorSubstring, quatidadeDeSubstrings);
		return substrings;
	}

	public static String[] separaStringEmSubStrings(String frase, int caracteresPorSubstring,
			int quatidadeDeSubstrings) {
		int tamanhoDaFrase = frase.length();
		String[] substrings = new String[quatidadeDeSubstrings];
		for (int i = 0; i < quatidadeDeSubstrings; i++) {
			substrings[i] = frase.substring(i * caracteresPorSubstring,
					Math.min((i + 1) * caracteresPorSubstring, tamanhoDaFrase));
			if (substrings[i].length() < caracteresPorSubstring) {
				substrings[i] = adionaEspacosEmBranco(substrings[i], caracteresPorSubstring);
			}
		}
		return substrings;
	}

	public static String adionaEspacosEmBranco(String substring, int caracteresPorSubstring) {
		return substring + " ".repeat(caracteresPorSubstring - substring.length());
	}
}
