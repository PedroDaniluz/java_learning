package aula6_strings;

import java.util.Scanner;

public class SearchNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opt;
        final int MAX = 200;
        String[] nomes = new String[200];
        boolean encontrou;
        while (true) {
            opt = menu(scanner);
            if (opt == 0) {
                break;
            } else if (opt == 1) {
                registrar(nomes, MAX, scanner);
            } else {
                encontrou = buscar(nomes, scanner);
                if (encontrou) System.out.print("Esse(a) aluno(a) estava na reunião!\n\n");
                else System.out.print("Não encontrado!\n\n");
            }
        }
        scanner.close();
    }

    public static int menu(Scanner scanner) {
        int opt = -1;
        while (opt < 0 || opt > 2) {
            System.out.println("\nMenu\n1 - Registrar aluno\n2 - Buscar aluno\n0 - Sair\n");
            System.out.print("Insira a opção desejada: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            if (opt < 0 | opt > 2) {
                System.out.println("Valor inválido\n");
            }
        }
        return opt;
    }

    public static void registrar(String[] nomes, int max, Scanner scanner) {
        String opt = "S";
        int ind = 0;
        while (ind < max && opt.toUpperCase().charAt(0) == 'S') {
            System.out.print("Insira o nome do aluno: ");
            nomes[ind] = scanner.nextLine();
            System.out.print("Deseja continuar? (S-sim / N-não): ");
            opt = scanner.nextLine();
            ind++;
        }
    }

    public static boolean buscar(String[] nome, Scanner scanner) {
        System.out.print("Insira o nome do aluno para buscar: ");
        String busca = scanner.nextLine();
        boolean aux = false;
        for (int i = 0; i < nome.length && !aux; i++) {
            if (nome[i].equalsIgnoreCase(busca)) {
                aux = true;
            } else if (nome[i] == null) {
                break;
            }
        }
        return aux;
    }
}