package semestre1.cp2Kenzo;

//RM551842| João Lourenço de Camargo Sardinha
//RM99890 | Kenzo Schiavone Inoue dos Santos
//RM552276| Maria Eduarda de Carvalho Goda
//RM97697 | Pedro Daniluz

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainKz {
    public static void main(String[] args) {

        int[] codigos = new int[50];
        int[] estoque = new int[50];
        double[] precos = new double[50];
        int nProdutos = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("CADASTRO DE PRODUTOS:");
            System.out.print("Quantidade de produtos a cadastrar (máx 50): ");
            try {
                nProdutos = scanner.nextInt();
                if (nProdutos < 1 || nProdutos > 50) {
                    System.out.println("Digite um número entre 1 e 50.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro válido.\n");
                scanner.next();
            }
        } while (nProdutos < 1 || nProdutos > 50);

        for (int i = 0; i < nProdutos; i++) {
            System.out.println((i + 1) + "º Produto:");

            int codigo;

            do {
                try {
                    System.out.print("Código: ");
                    codigo = scanner.nextInt();
                    if (PackageFunctionsKz.codigoJaExiste(codigo, codigos, i)) {
                        System.out.println("Erro: Este código já está em uso. Por favor, escolha outro.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite um número inteiro válido para o código.");
                    scanner.next();

                }
            } while (true);

            codigos[i] = codigo;

            do {
                try {
                    System.out.print("Quantidade em estoque: ");
                    estoque[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Digite um número inteiro válido para a quantidade em estoque.\n");
                    scanner.next();
                }
            } while (true);

            do {
                try {
                    System.out.print("Preço: R$");
                    precos[i] = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Digite um valor numérico válido para o preço.\n");
                    scanner.next();
                }
            } while (true);

            System.out.println();
        }

        double mediaPrecosProdutos = PackageFunctionsKz.mediaPrecos(precos, nProdutos);
        System.out.printf("PREÇO MÉDIO DOS PRODUTOS: R$%.2f", mediaPrecosProdutos);

        int indiceMenorEstoque = PackageFunctionsKz.menorEstoque(estoque, nProdutos);

        System.out.println("\nPRODUTO COM O MENOR ESTOQUE:");
        System.out.println("Código: " + codigos[indiceMenorEstoque]);
        System.out.println("Quantidade em estoque: " + estoque[indiceMenorEstoque]);
        System.out.println("Preço: R$" + precos[indiceMenorEstoque]);

        System.out.println("\nFUNÇÃO BUSCA PRODUTO: ");

        int codigoProcurado;

        do {
            try {
                System.out.print("Código do produto a ser buscado: ");
                codigoProcurado = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro válido para o código.\n");
                scanner.next();
            }
        } while (true);

        System.out.println();

        PackageFunctionsKz.buscaProduto(codigoProcurado, nProdutos, codigos, estoque, precos);

    }
}
