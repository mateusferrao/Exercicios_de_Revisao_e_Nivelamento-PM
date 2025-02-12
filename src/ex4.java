import java.util.Scanner;

public class ex4 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String frase = scanner.nextLine();
		int caracteresPorSubstring = 5;
		int quatidadeDeSubstrings = (int) Math.ceil((double) frase.length() / caracteresPorSubstring);
		String[] substrings = retornaSubstrings(frase, caracteresPorSubstring, quatidadeDeSubstrings);
		String[] substringsCriptografadas = retornaSubstringsCriptografadas(substrings, caracteresPorSubstring,
				quatidadeDeSubstrings);
		imprimeArrayDeStrings(substringsCriptografadas);
		System.out.println(retornaSubstringsCriptografadasRestauradas(substringsCriptografadas));
		scanner.close();
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

	public static String retornaSubstringsCriptografadasRestauradas(String[] substringsCriptografadas) {
		String stringRestaurada = "";
		int tamanhoMaximo = substringsCriptografadas[0].length();
		for (int i = 0; i < tamanhoMaximo; i++) {
			for (int j = 0; j < substringsCriptografadas.length; j++) {
				if (i < substringsCriptografadas[j].length()) {
					if (substringsCriptografadas[j].charAt(i) == '*' || (substringsCriptografadas[j].charAt(i) == ' '
							&& j > 0 && substringsCriptografadas[j - 1].charAt(i) == ' '))
						break;
					stringRestaurada += substringsCriptografadas[j].charAt(i);
				}
			}
		}
		return stringRestaurada;
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
