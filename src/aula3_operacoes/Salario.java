package aula3_operacoes;

import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        double salario;
        int tempo, porc;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Valor do salário: ");
        salario = scanner.nextDouble();
        System.out.print("Tempo de empresa em anos: ");
        tempo = scanner.nextInt();
        scanner.close();

        porc = tempo > 10 ? 9 : tempo > 5 ? 7 : tempo > 2 ? 5 : 2;

        System.out.printf("O novo salário será: R$%.2f", salario * (100 + porc) / 100);
    }
}
