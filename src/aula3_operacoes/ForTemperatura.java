package aula3_operacoes;

public class ForTemperatura {
    public static void main(String[] args) {
        double celsius;

        for(int fahrenheit = 100; fahrenheit <= 150; fahrenheit++) {
            celsius = (double) 5 * (fahrenheit - 32) / 9;
            System.out.printf("Fahrenheit: %dº ===> Celsius: %.2fº\n", fahrenheit, celsius);
        }
    }
}
