package aula7_classes;

import java.util.Scanner;

public class ClasseBanco {
    public static class Cliente {
        String nome, endereco, cpf;
        int conta, anoAbertura;
        double saldo;

        public void apresenta() {
            System.out.println("\n\n\n");
            System.out.printf("Nome: %s\n", nome);
            System.out.printf("Endereço: %s\n", endereco);
            System.out.printf("CPF: %s\n", cpf);
            System.out.printf("Nº Conta: %d\n", conta);
            System.out.printf("Ano de Abertura: %d\n", anoAbertura);
            System.out.printf("Saldo: R$%.2f\n", saldo);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.print("Insira o nome: ");
        cliente.nome = scanner.nextLine();
        System.out.print("Insira o endereço: ");
        cliente.endereco = scanner.nextLine();
        System.out.print("Insira o CPF: ");
        cliente.cpf = scanner.nextLine();
        System.out.print("Insira o nº da conta: ");
        cliente.conta = scanner.nextInt();
        System.out.print("Insira o ano de abertura da conta: ");
        cliente.anoAbertura = scanner.nextInt();
        System.out.print("Insira o saldo: R$");
        cliente.saldo = scanner.nextDouble();

        cliente.apresenta();
    }
}
