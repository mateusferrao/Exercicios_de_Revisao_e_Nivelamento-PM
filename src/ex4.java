import java.util.Scanner;

public class ex4 {
    static Scanner scanner = new Scanner(System.in);

    public static String criptografar(String texto) {
        StringBuilder[] blocos = dividirEmBlocos(texto, 5);
        return construirCriptografia(blocos); 
    }

    private static StringBuilder[] dividirEmBlocos(String texto, int tamanhoBloco) {
        int numBlocos = (int) Math.ceil((double) texto.length() / tamanhoBloco);
        StringBuilder[] blocos = new StringBuilder[numBlocos];

        for (int i = 0; i < numBlocos; i++) {
            int inicio = i * tamanhoBloco;
            int fim = Math.min(inicio + tamanhoBloco, texto.length());
            blocos[i] = new StringBuilder(texto.substring(inicio, fim));
        }

        return blocos;
    }

    private static String construirCriptografia(StringBuilder[] blocos) {
        StringBuilder criptografada = new StringBuilder();

        for (int coluna = 0; coluna < 5; coluna++) {
            for (StringBuilder bloco : blocos) {
                if (coluna < bloco.length()) {
                    criptografada.append(bloco.charAt(coluna));
                } else {
                    criptografada.append(' ');
                }
            }
            criptografada.append('*');
        }

        if (criptografada.length() > 0) {
            criptografada.deleteCharAt(criptografada.length() - 1);
        }

        return criptografada.toString();
    }

    public static String leTexto(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine(); 
    }

    public static void main(String[] args) {
        String texto = leTexto("Digite a frase: ");
        String criptografada = criptografar(texto);
        System.out.println("Texto criptografado: " + criptografada);
    }
}