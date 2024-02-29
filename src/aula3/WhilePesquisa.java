package aula3;

import java.util.Scanner;

public class WhilePesquisa {
    public static void main(String[] args) {
        int qntFilho;
        double valorSalario;

        int totalFilhos = 0;
        double totalSalario = 0;

        int mostFilhos = 0;
        double mostSalario = 0;

        int cont = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Valor do Salário: R$");
            valorSalario = scanner.nextDouble();
            mostSalario = valorSalario > mostSalario ? valorSalario : mostSalario;
            totalSalario += valorSalario;

            if (valorSalario <= 0) break;

            System.out.print("Quantidade de filhos: ");
            qntFilho = scanner.nextInt();
            mostFilhos = qntFilho > mostFilhos ? qntFilho : mostFilhos;
            totalFilhos += qntFilho;

            cont++;
        }
        System.out.printf("Média Salarial: R$%.2f\n", totalSalario / cont);
        System.out.printf("Média de Filhos: %.2f\n\n", totalFilhos * 1.0/ cont);
        System.out.printf("Maior Salário: R$%.2f\n", mostSalario);
        System.out.printf("Mais Filhos: %d\n\n", mostFilhos);
    }
}
