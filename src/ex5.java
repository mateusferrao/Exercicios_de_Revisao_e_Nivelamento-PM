import java.util.Scanner;

public class ex5 {
    static Scanner scanner = new Scanner(System.in);

    public static String descriptografar(String criptografada) {
        String[] partes = dividirPartes(criptografada); 
        StringBuilder[] blocos = reconstruirBlocos(partes); 
        return juntarBlocos(blocos); 
    }

    private static String[] dividirPartes(String criptografada) {
        return criptografada.split("\\*", -1);
    }

    private static StringBuilder[] reconstruirBlocos(String[] partes) {
        int maxLinhas = 0;
        for (String parte : partes) {
            if (parte.length() > maxLinhas) {
                maxLinhas = parte.length();
            }
        }

        StringBuilder[] blocos = new StringBuilder[maxLinhas];
        for (int i = 0; i < maxLinhas; i++) {
            blocos[i] = new StringBuilder();
        }

        for (String parte : partes) {
            for (int linha = 0; linha < maxLinhas; linha++) {
                if (linha < parte.length()) {
                    blocos[linha].append(parte.charAt(linha));
                } else {
                    blocos[linha].append(' '); 
                }
            }
        }

        return blocos;
    }

    private static String juntarBlocos(StringBuilder[] blocos) {
        StringBuilder textoOriginal = new StringBuilder();
        for (StringBuilder bloco : blocos) {
            textoOriginal.append(bloco);
        }
        return textoOriginal.toString().trim(); 
    }

    public static String leTexto(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine(); 
    }

    public static void main(String[] args) {
        String criptografada = leTexto("Digite a mensagem criptografada: ");
        String textoOriginal = descriptografar(criptografada);
        System.out.println("Texto original: " + textoOriginal);
    }
}