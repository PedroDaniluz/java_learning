package semestre1.cp2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX = 50;
        int[] codigos = new int[MAX];
        int[] estoques = new int[MAX];
        double[] precos = new double[MAX];
        int n = 0;

        while (true) {
            int opt = -1;
            while (opt < 0 || opt > 2) {
                System.out.println("\nMenu\n1 - Cadastrar produto\n2 - Buscar produto\n0 - Sair\n");
                System.out.print("Insira a opção desejada: ");
                opt = scanner.nextInt();
                if (opt < 0 || opt > 2) {
                    System.out.println("\nValor inválido, tente novamente: ");
                }
            }
            if (opt == 0) {
                break;
            } else if (opt == 1) {
                String continuar = "S";
                while (n < MAX && continuar.toUpperCase().charAt(0) == 'S') {
                    System.out.println("\n\nPRODUTO " + (n + 1));
                    System.out.print("Insira o código do produto: ");
                    codigos[n] = scanner.nextInt();
                    System.out.print("Insira a quantidade em estoque: ");
                    estoques[n] = scanner.nextInt();
                    System.out.print("Insira o valor: R$");
                    precos[n] = scanner.nextDouble();
                    System.out.print("Deseja continuar? (S-sim | N-não): ");
                    scanner.nextLine();
                    continuar = scanner.nextLine();
                    n++;
                    if (continuar.toUpperCase().charAt(0) != 'S') {
                        System.out.println("\n\n\nINFORMAÇÕES:");
                        System.out.printf(" -> Índice do produto com menor estoque: %d\n", menorEstoque(estoques, n));
                        System.out.printf(" -> Preço médio dos produtos: R$%.2f\n\n", mediaPrecos(precos, n));
                    }
                }
            } else {
                int codigo;
                System.out.print("Insira o código para buscar: ");
                codigo = scanner.nextInt();
                buscaProduto(codigos, estoques, precos, codigo, n);
            }
        }
    }

    // =================||=================||        FUNÇÕES        ||=================||=================

    public static int menorEstoque(int[] estoques, int n) {
        int index = 0;
        int min = estoques[0];
        for (int i = 1; i < n; i++) {
            if (estoques[i] < min) {
                min = estoques[i];
                index = i;
            }
        }
        return index;
    }

    public static double mediaPrecos(double[] preco, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += preco[i];
        }
        return total / n;
    }

    public static void buscaProduto(int[] codigos, int[] estoques, double[] precos, int procura, int n) {
        boolean achou = false;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (procura == codigos[i]) {
                achou = true;
                index = i;
                i = n;
            }
        }
        if (achou) {
            System.out.println("\n\nPRODUTO ENCONTRADO:");
            System.out.printf(" -> Índice do produto: %d\n", index);
            System.out.printf(" -> Código do produto: %d\n", codigos[index]);
            System.out.printf(" -> Quantidade em estoque: %d\n", estoques[index]);
            System.out.printf(" -> Valor do produto: R$%.2f\n\n", precos[index]);

        } else {
            System.out.println("\n\nO produto não foi encontrado!\n");

        }
    }
}