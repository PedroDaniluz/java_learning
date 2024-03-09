package aula3;

import java.util.Scanner;

public class WhilePesquisa {
    public static void main(String[] args) {
        int qntFilho, totalFilhos = 0, mostFilhos = 0, cont = 0;
        double valorSalario, totalSalario = 0, mostSalario = 0, quinhentos = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Valor do Salário: R$");
        valorSalario = scanner.nextDouble();
        while (valorSalario > 0) {
            if (valorSalario <= 500) quinhentos ++;
            mostSalario = valorSalario > mostSalario ? valorSalario : mostSalario;
            totalSalario += valorSalario;

            do {
                System.out.print("Quantidade de filhos: ");
                qntFilho = scanner.nextInt();
            } while (qntFilho < 0);
            mostFilhos = qntFilho > mostFilhos ? qntFilho : mostFilhos;
            totalFilhos += qntFilho;

            cont++;

            System.out.print("Valor do Salário: R$");
            valorSalario = scanner.nextDouble();
        }
        if(cont != 0) {
            System.out.printf("Média Salarial: R$%.2f\n", totalSalario / cont);
            System.out.printf("Maior Salário: R$%.2f\n", mostSalario);
            System.out.printf("Salário até R$500,00: %.2f%%\n\n", quinhentos * 100.0 / cont);
            System.out.printf("Média de Filhos: %.2f\n", totalFilhos * 1.0 / cont);
            System.out.printf("Mais Filhos: %d\n\n", mostFilhos);
        } else System.out.println("Não foi possível realizar nenhuma entrevista");

        scanner.close();
    }
}
