package aula10_alocDinamica;

public class PilhaEncadeada {
    private static class NO {
        int dado;
        NO prox, topo;

        public void init() {
            topo = null;
        }

        public boolean isEmpty() {
            return topo == null;
        }

        public void push(int dado) {
            NO novo = new NO();
            novo.dado = dado;
            novo.prox = topo;
            topo = novo;
        }

        public int pop() {
            if(!isEmpty()) {
                int valor = topo.dado;
                topo = topo.prox;
                return valor;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        NO pilha =  new NO();
        pilha.init();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        System.out.println(pilha.pop());
        System.out.println(pilha.pop());
        System.out.println(pilha.pop());
    }
}
