package aula7_classes;

import java.time.LocalDateTime;
import java.util.Scanner;

public class VetorClasse {
    public static class Cliente {
        String nome, endereco, cpf;
        int numConta, anoConta;
        double saldo;

        public boolean negativado() {
            return saldo < 0;
        }

        public boolean maisAnos() {
            return anoConta <= (LocalDateTime.now().getYear() - 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 3;
        Cliente[] clientes = new Cliente[N];
        int ind = 0;
        char continuar = 'S';
        int negativos = 0;
        int[] maisAnos = new int[N];
        int aux = 0;
        while (ind < N && continuar == 'S') {
            Cliente cliente = new Cliente();
            System.out.printf("\n===== CLIENTE %d =====\n", ind + 1);
            System.out.print("Nome: ");
            cliente.nome = scanner.nextLine();
            System.out.print("Endereço: ");
            cliente.endereco = scanner.nextLine();
            System.out.print("CPF: ");
            cliente.cpf = scanner.nextLine();
            System.out.print("Número da conta: ");
            cliente.numConta = scanner.nextInt();
            System.out.print("Ano da conta: ");
            cliente.anoConta = scanner.nextInt();
            System.out.print("Saldo: R$");
            cliente.saldo = scanner.nextDouble();
            scanner.nextLine();
            clientes[ind] = cliente;
            ind++;
            System.out.print("Deseja continuar (S-sim / N-não): ");
            continuar = scanner.nextLine().toUpperCase().charAt(0);
        }

        scanner.close();

        for (int i = 0; i < ind; i++) {
            if (clientes[i].negativado()) {
                negativos++;
            }
            if (clientes[i].maisAnos()) {
                maisAnos[aux] = clientes[i].numConta;
                aux++;
            }
        }
        System.out.println("\n=============||==== DADOS ====||=============\n");
        System.out.printf("Total de clientes negativados: %d\n\n", negativos);
        System.out.println("Clientes com mais de 10 anos:");
        for (int i = 0; i < aux; i++) {
            System.out.printf("-> %d\n", maisAnos[i]);
        }
    }
}
