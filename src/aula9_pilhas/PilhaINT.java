package aula9_pilhas;

public class PilhaINT {
    final int N = 6;
    int dados[] = new int[N];
    int topo;

    public void init() {
        topo = 0;
    }

    public boolean isEmpty() {
        return topo == 0;
    }

    public boolean isFull() {
        return topo == N;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            dados[topo] = value;
            topo++;
        }
    }

    public int pop() {
        topo--;
        return dados[topo];
    }

    public int top() {
        return dados[topo - 1];
    }
}
