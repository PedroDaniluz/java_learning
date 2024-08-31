package aula9_pilhas;

import java.util.Scanner;

public class PilhasBinarios {
    public static int conversor(int decimal) {
        PilhaINT pilha = new PilhaINT();
        StringBuilder bin = new StringBuilder();
        while (decimal != 0) {
            pilha.push(decimal % 2);
            decimal = decimal / 2;
        }
        while (!pilha.isEmpty()) {
            bin.append(pilha.pop());
        }
        return Integer.parseInt(bin.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal;
        System.out.print("Insira o valor em decimal: ");
        decimal = scanner.nextInt();

        System.out.print("Valor em binário: " + conversor(decimal));
    }
}
