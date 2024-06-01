package aula6_strings;

public class ExConcat {
    public static void main(String[] args) {
        String str1 = "Linguagem";
        String str2 = " JAVA";
        str1 = str1.concat(str2);
        System.out.printf("A frase final é '%s'.\nEla possui %d caracteres.", str1, str1.length());
    }
}
