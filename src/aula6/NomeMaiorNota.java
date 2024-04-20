package aula6;

import java.util.Scanner;

public class NomeMaiorNota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int QUANTIDADE = 50;
        String[] nomes = new String[QUANTIDADE];
        double[] notas = new double[QUANTIDADE];
        int ind = 0, maior = 0;
        String opc = "S";

        while (ind < QUANTIDADE && opc.toUpperCase().charAt(0) != 'N') {
            System.out.print("Insira o nome do aluno: ");
            nomes[ind] = scanner.nextLine();

            System.out.print("Insira a nota: ");
            notas[ind] = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Deseja continuar? (S-sim || N-não)? ");
            opc = scanner.nextLine();

            ind++;
        }

        scanner.close();

        for (int i = 0; i < ind; i++) {
            if (notas[i] > notas[maior]) {
                maior = i;
            }
        }

        System.out.printf("Aluno com maior nota: %s ----> Nota: %.1f", nomes[maior], notas[maior]);
    }
}
