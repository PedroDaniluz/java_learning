package aula3;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        double celsius, farenheit, ap;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o valor em Farenheit: ");
        farenheit = scanner.nextDouble();
        scanner.close();

        celsius = 5 * (farenheit - 32) / 9;

        System.out.printf("%.2fºF equivale à %.2fºC\n", farenheit, celsius);
        ap = celsius > 1 ? 1 : 0;
        System.out.println(ap);
    }
}
