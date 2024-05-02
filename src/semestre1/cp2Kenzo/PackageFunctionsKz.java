package semestre1.cp2Kenzo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PackageFunctionsKz {

    public static int menorEstoque(int[] estoque, int n) {

        int menorEstoque = estoque[0];
        int indiceMenorEstoque = 0;

        for (int i = 1; i < n; i++) {
            if (estoque[i] < menorEstoque) {
                menorEstoque = estoque[i];
                indiceMenorEstoque = i;
            }
        }
        return indiceMenorEstoque;
    }


    public static void buscaProduto(int codigoProcurado, int n, int[] codigos, int[] estoque, double[] precos) {
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;
        char resp;
        while (!encontrado) {
            for (int i = 0; i < n; i++) {
                if (codigoProcurado == codigos[i]) {
                    System.out.println("PRODUTO ENCONTRADO:");
                    System.out.println("Código: " + codigos[i]);
                    System.out.println("Quantidade em estoque: " + estoque[i]);
                    System.out.println("Preço: R$" + precos[i]);
                    encontrado = true;
                    i = n;
                } else {
                    System.out.print("Produto não encontrado, deseja tentar novamente (S-sim / N-não): ");
                    resp = scanner.nextLine().toUpperCase().charAt(0);
                    if (resp == 'S') {
                        do {
                            try {
                                System.out.print("Código do produto a ser buscado: ");
                                codigoProcurado = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Digite um número inteiro válido para o código.\n");
                                scanner.next();
                            }
                        } while (true);
                    } else {
                        i = n;
                        encontrado = true;
                    }
                }
            }
        }
        scanner.close();
    }


    public static double mediaPrecos(double[] precos, int n) {

        double somaPrecos = 0;
        for (int i = 0; i < n; i++) {
            somaPrecos += precos[i];
        }
        return somaPrecos / n;
    }


    public static boolean codigoJaExiste(int codigo, int[] codigos, int n) {
        for (int i = 0; i < n; i++) {
            if (codigos[i] == codigo) {
                return true;
            }
        }
        return false;
    }
}
