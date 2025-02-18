import java.util.Scanner;

public class ex3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double[] notasExercicios = obterNotasExercicios();
        double[] notasProvas = obterNotasProvas();
        double notaTrabalho = obterNotaTrabalho();

        double notaFinal = calcularNotaFinal(notasExercicios, notasProvas, notaTrabalho);

        exibirNotaFinal(notaFinal);

        scanner.close();
    }

    public static double[] obterNotasExercicios() {
        double[] notas = new double[4];
        System.out.println("Digite as quatro notas dos exercícios (0 a 100):");
        for (int i = 0; i < 4; i++) {
            notas[i] = scanner.nextDouble();
        }
        return notas;
    }

    public static double[] obterNotasProvas() {
        double[] notas = new double[2];
        System.out.println("Digite as duas notas das provas (0 a 100):");
        for (int i = 0; i < 2; i++) {
            notas[i] = scanner.nextDouble();
        }
        return notas;
    }

    public static double obterNotaTrabalho() {
        System.out.println("Digite a nota do trabalho prático (0 a 20):");
        return scanner.nextDouble();
    }

    public static double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static double converteValorNaEscalaZeroAVinteParaZeroACem(double valor){
        return converteValorParaEscalaZeroACem(valor, 20);
    }

    public static double converteValorParaEscalaZeroACem(double valor, int novaEscala){
        return (valor / 20) * 100;
    }

    public static double calcularNotaFinal(double[] notasExercicios, double[] notasProvas, double notaTrabalho) {
        double mediaExercicios = calcularMedia(notasExercicios);
        double mediaProvas = calcularMedia(notasProvas);

        double notaTrabalhoNaEscalaZeroACem = converteValorNaEscalaZeroAVinteParaZeroACem(notaTrabalho);

        return (mediaExercicios * 0.2) + (mediaProvas * 0.6) + (notaTrabalhoNaEscalaZeroACem * 0.2);
    }

    public static void exibirNotaFinal(double notaFinal) {
        System.out.printf("A nota final do aluno é: %.2f\n", notaFinal);
    }
}