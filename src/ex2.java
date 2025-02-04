import java.util.Scanner;

public class ex2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mostrarMenu();
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Resultado da soma: "+retornaSomaDeNumeros(2));
                break;
            case 2:
                System.out.print("Digite o primeiro número: ");
                float numero1 = scanner.nextFloat();
                System.out.print("Digite o segundo número: ");
                float numero2 = scanner.nextFloat();
                if (numero1 == numero2) {
                    System.out.println("Os números são iguais ");
                } else {
                    System.out.println("Maior número: "+retornaMaiorNumero(numero1, numero2));
                }
                break;
            case 3:
                System.out.print("Digite a quantidade de números a serem somados: ");
                int quantidadeDeNumeros = scanner.nextInt();
                System.out.println("Resultado da soma: "+retornaSomaDeNumeros(quantidadeDeNumeros));
                break;
            case 4:
                System.out.print("Quantos números na sequência: ");
                int quantidade = scanner.nextInt();
                System.out.println("Quantidade de números pares: " + retornaNumeroDeParesDaSequencia(quantidade));
                break;
            case 0:
                System.out.println("Saindo");
                break;
            default:
                break;
        }
    }

    public static void mostrarMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Somar dois números");
        System.out.println("2 - O maior de dois números");
        System.out.println("3 - Somar N números");
        System.out.println("4 - Contador de pares de uma sequência");
        System.out.println("0 - Sair");
    }

    public static float retornaSomaDeNumeros(int quantidadeDeNumeros) {
        float soma = 0;
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            float numero = scanner.nextFloat();
            soma += numero;
        }
        return soma;
    }

    public static float retornaMaiorNumero(float numero1, float numero2) {
        if (numero1 > numero2) {
            return numero1;
        } else {
            return numero2;
        }
    }

    public static int retornaNumeroDeParesDaSequencia(int quantidadeDeNumeros) {
        int pares = 0;
        for (int i = 1; i <= quantidadeDeNumeros; i++) {
            System.out.print("Digite o número " + i + ": ");
            int numero = scanner.nextInt();
            if (numero % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }
}
