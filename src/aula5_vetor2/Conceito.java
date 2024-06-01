package aula5_vetor2;

import java.util.Scanner;

public class Conceito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int qnt_alunos = 4;
        double n1, n2;
        double[] medias = new double[qnt_alunos];

        for (int i = 0; i < medias.length; i++) {
            System.out.printf("ALUNO %d:\n", i + 1);
            System.out.print("Insira a primeira nota: ");
            n1 = scanner.nextDouble();
            System.out.print("Insira a segunda nota: ");
            n2 = scanner.nextDouble();
            System.out.print("\n\n");
            medias[i] = media_com_pesos(n1, n2);
        }

        char[] conceitos = conceito(medias);

        for (int i = 0; i < medias.length; i++) {
            System.out.printf("Média do aluno %d: %.1f ---> Conceito: %c\n", i + 1, medias[i], conceitos[i]);
        }
    }

    public static double media_com_pesos(double n1, double n2) {
        return 0.4 * n1 + 0.6 * n2;
    }

    public static char[] conceito(double[] lista) {
        char[] conceitos = new char[lista.length];
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] < 5) {
                conceitos[i] = 'R';
            } else if (lista[i] >= 8.5) {
                conceitos[i] = 'E';
            } else {
                conceitos[i] = 'B';
            }
        }
        return conceitos;
    }
}
