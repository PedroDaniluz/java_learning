package aula4;

import java.util.Scanner;

public class VetorMediaRm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ind1 = 0, ind2 = 0;
        final int MAX = 40;
        int[] rm = new int[MAX];
        int[] aprovados = new int[MAX];
        double[] medias = new double[MAX];
        double[] notas1 = new double[MAX];
        double[] notas2 = new double[MAX];

        while (ind1 < MAX) {
            System.out.print("(0 para sair) Insira o rm do aluno: ");
            rm[ind1] = scanner.nextInt();
            if (rm[ind1] == 0) break;

            System.out.print("Insira a primeira nota: ");
            notas1[ind1] = scanner.nextDouble();

            System.out.print("Insira a segunda nota: ");
            notas2[ind1] = scanner.nextDouble();

            medias[ind1] = (notas1[ind1] + notas2[ind1]) / 2;

            if (medias[ind1] >= 6) {
                aprovados[ind2] = rm[ind1];
                ind2++;
            }

            ind1++;
        }

        scanner.close();

        System.out.println("\n************* *************\n");

        System.out.println("Alunos aprovados: ");

        for (int i = 0; i < MAX; i++) {
            if (aprovados[i] == 0) break;
            System.out.println(aprovados[i]);
        }
    }
}