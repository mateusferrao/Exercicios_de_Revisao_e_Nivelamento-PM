import java.util.Scanner;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int largura = leLargura();
        int altura = leAltura();
        desenhaRetangulo(largura, altura);
    }

    public static int leLargura() {
        System.out.println("Digite a largura: ");
        return scanner.nextInt();
    }

    public static int leAltura() {
        System.out.println("Digite a altura: ");
        return scanner.nextInt();
    }

    public static void desenhaRetangulo(int largura, int altura) {
        for (int i = 0; i < altura; i++) {
            for (int k = 0; k < largura; k++) {
                if (i == 0 || i == altura - 1 || k == 0 || k == largura - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}