package aula5;

import java.util.Scanner;

public class MediaPesos {
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
        for (int i = 0; i < medias.length; i++) {
            System.out.printf("Média do aluno %d: %.2f\n", i + 1, medias[i]);
        }
    }

    public static double media_com_pesos(double n1, double n2) {
        return 0.4 * n1 + 0.6 * n2;
    }
}
