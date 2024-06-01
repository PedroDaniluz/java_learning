package aula4_vetor1;

import java.util.Scanner;

public class BubbleFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];
        int auxValue = 0, auxInd = 0;

        for (int i = 0; i < valores.length; i++) {
            System.out.print("Insira o valor: ");
            valores[i] = scanner.nextInt();
        }

        for (int i = 0; i < valores.length; i++) {
            if (auxValue < valores[i]) {
                auxValue = valores[i];
                auxInd = i;
            }
        }

        System.out.printf("O calor máximo é: '%d' e ele está na posição '%d'", auxValue, auxInd);
    }
}
