import java.util.Scanner;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite largura e altura do retângulo: ");
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        desenhaRetangulo(largura, altura);
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