package aula4;

import java.util.Scanner;

public class VetorMediaRm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ind1 = 0, ind2 = 0;
        int[] rm = new int[40];
        int[] aprovados = new int[40];
        double[] medias = new double[40];
        double[] notas1 = new double[40];
        double[] notas2 = new double[40];
        while (true) {
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

        System.out.println("Alunos aprovados: ");

        for (int i = 0; i < aprovados.length; i++) {
            if (aprovados[i] != 0) {
                System.out.println(aprovados[i]);
            }
        }
    }
}