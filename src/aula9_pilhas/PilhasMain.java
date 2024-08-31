package aula9_pilhas;

public class PilhasMain {
    public static void main(String[] args) {
        PilhaINT pilha = new PilhaINT();

        pilha.init();

        pilha.push(5);
        pilha.push(11);
        pilha.push(35);
        pilha.push(62);
        pilha.push(39);
        pilha.push(40);
        pilha.push(83);

        // verificação necessária para evitar exceptions
        if (!pilha.isEmpty()) {
            System.out.println(pilha.top());
        }

        // verificação necessária para evitar exceptions
        while (!pilha.isEmpty()) {
            System.out.println("Elemento removido da pilha: " + pilha.pop());
        }
    }
}