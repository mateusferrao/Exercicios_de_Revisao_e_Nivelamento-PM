import java.util.Scanner;
public class ex3 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		String frase = scanner.nextLine();
		String[] substrings = splitString(frase, 5);
		for(String substring : substrings){
			System.out.println(substring);
		}
	}

	public static String[] splitString(String frase, int caracteresPorSubstring){
		int tamanhoDaFrase = frase.length();
		int quatidadeDeSubstrings = (tamanhoDaFrase + caracteresPorSubstring - 1) / caracteresPorSubstring;
		String[] substrings = new String[quatidadeDeSubstrings];
		for (int i=0; i<quatidadeDeSubstrings; i++){
			substrings[i] = frase.substring(i*caracteresPorSubstring, retornaMenorValor((i + 1) * caracteresPorSubstring, tamanhoDaFrase));
		}
		return substrings;
	}

	public static int retornaMenorValor(int valor1, int valor2){
		return Math.min(valor1, valor2);
	}
}
