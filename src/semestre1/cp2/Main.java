package semestre1.cp2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX = 50;
        int[] codigos = new int[MAX];
        int[] estoques = new int[MAX];
        double[] precos = new double[MAX];

        int opt = -1;
        while (true) {
            while (opt < 0 || opt > 2) {
                System.out.println("\nMenu\n1 - Cadastrar produto\n2 - Buscar produto\n0 - Sair\n");
                System.out.print("Insira a opção desejada: ");
                opt = scanner.nextInt();
                if (opt < 0 || opt > 2) {
                    System.out.println("Valor inválido\n");
                } else if (opt == 0) {
                    break;
                } else if (opt == 1) {
                    String continuar = "S";
                    for (int i = 0; i < MAX && continuar.toUpperCase().charAt(0) == 'S'; i++) {
                        System.out.println("PRODUTO " + (i + 1));
                        System.out.print("Insira o código do produto: ");
                        codigos[i] = scanner.nextInt();
                        System.out.print("Insira a quantidade em estoque:");
                        estoques[i] = scanner.nextInt();
                        System.out.print("Insira o valor: R$");
                        precos[i] = scanner.nextDouble();
                        System.out.println("Deseja continuar? (S-sim | N-não): ");
                        scanner.nextLine();
                        continuar = scanner.nextLine();
                    }
                }
            }
        }
    }

    public static int menorEstoque(int[] estoques, int n) {
        return 0;
    }

    public static double mediaPrecos(double[] preco, int n) {
        return 0;
    }

    public static void buscaProduto(int[] codigos, int[] estoques, double[] precos, int n) {
    }
}
