import java.util.Scanner;

public class ex2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mostrarMenu();
        int opcao = leNumero("Digite a opção: ");
        switch (opcao) {
            case 0 -> System.out.println("Saindo");
            case 1 -> System.out.println("Resultado da soma: " + retornaSomaDeNumeros(2));
            case 2 -> retornaOMaiorDeDoisNumeros();
            case 3 -> somaNumeros();
            case 4 -> contaParesDaSequencia();
        }
    }

    public static int leNumero(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    public static void mostrarMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Somar dois números");
        System.out.println("2 - O maior de dois números");
        System.out.println("3 - Somar N números");
        System.out.println("4 - Contador de pares de uma sequência");
        System.out.println("0 - Sair");
    }

    public static void contaParesDaSequencia() {
        int quantidadeDeNumerosNaSequencia = leNumero("Quantos números na sequência:");
        System.out.println("Quantidade de números pares: " + retornaNumeroDeParesDaSequencia(quantidadeDeNumerosNaSequencia));
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
    
    public static void retornaOMaiorDeDoisNumeros() {
        String mensagem = "Os números são iguais.";
        int numero1 = leNumero("Digite o primeiro número: ");
        int numero2 = leNumero("Digite o segundo número: ");
        if (numero1 != numero2) mensagem = "Maior número: " + retornaMaiorNumero(numero1, numero2);
        System.out.println(mensagem);
    }

    public static float retornaMaiorNumero(float numero1, float numero2) {
        if (numero1 > numero2) {
            return numero1;
        } else {
            return numero2;
        }
    }

    public static void somaNumeros() {
        int quantidadeDeNumerosASeremSomados = leNumero("Digite a quantidade de números a serem somados:");
        System.out.println("Resultado da soma: " + retornaSomaDeNumeros(quantidadeDeNumerosASeremSomados));
    }

    public static float retornaSomaDeNumeros(int quantidadeDeNumeros) {
        float soma = 0;
        for (int i = 0; i < quantidadeDeNumeros; i++) {
            float numero = leNumero("Digite o número " + (i + 1) + ": ");
            soma += numero;
        }
        return soma;
    }

}
