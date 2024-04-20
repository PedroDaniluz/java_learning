package aula6;

public class ConcatString {
    public static void main(String[] args) {
        String a = "Pedro", b = "Daniluz";
        // python = f"Nome: {a}\n Sobrenome: {b}"
        String java = String.format("Nome: %s\nSobrenome: %s", a, b);
        System.out.println(java);
    }
}
