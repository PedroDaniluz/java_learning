package aula2_inOut;

public class SystemInOut {
    public static void main(String[] args) {
        double valor;
        int desconto;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Insira o valor do produto: R$");
        valor = sc.nextDouble();

        System.out.print("Insira a porcentagem de desconto: ");
        desconto = sc.nextInt();

        System.out.printf("O valor final do produto é: R$%.2f", valor * (1 - desconto / 100.0));
    }
}