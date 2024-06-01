package aula4_vetor1;
/*
Escreva um programa que leia um vetor os  saldos das contas de 10 pessoas e mostre na tela de saída:
- Os valores dos saldos  positivos
- O número de pessoas que estão com o saldo negativo.
*/

import java.util.Scanner;

public class NotasVetor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] saldo = new double[10];
        int negativos = 0;

        for (int i = 0; i < saldo.length; i++) {
            System.out.println("Insira o saldo: R$");
            saldo[i]= scanner.nextDouble();
            if (saldo[i] < 0) {
                negativos++;
            }
        }

        scanner.close();

        for (int i = 0; i < saldo.length; i++) {
            if (saldo[i] > 0){
                System.out.printf("Saldo positivo: R$%.2f\n", saldo[i]);
            }
        }

        System.out.printf("\n\nExistem %d pessoas com saldo negativo", negativos);

    }
}
