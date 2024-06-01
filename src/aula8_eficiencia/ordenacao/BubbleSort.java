package aula8_eficiencia.ordenacao;

import java.util.Random;

public class BubbleSort {


    public static void main(String[] args) {

        Random gerador = new Random();

        final int N = 10;    // define o tamanho do vetor a ser ordenado


        //cria a estrutura de dados (vetor) com N elementos   gera vetor fora de ordem
        int vetor[] = new int[N];
        int i;
        System.out.println("Criando vetor com " + N + " elementos: ");
        for (i = 0; i < N; i++) {
            vetor[i] = gerador.nextInt(50000);
            System.out.print(vetor[i] + "\t");
        }

        bubbleSort(vetor);
        System.out.println("\n***** Vetor ordenado com Bubblesort **** ");
        for (i = 0; i < N; i++) {
            System.out.print(vetor[i] + "\t");
        }

        System.out.println("\n*********** Aplicando o BubbleSort ao Vetor Ordenado *********");
        bubbleSort(vetor);


    }

    public static void bubbleSort(int vetor[]) {
        int comparacoes = 0, trocas = 0; //contadores de operacoes essenciais
        int n = vetor.length;
        boolean troca = true; /* supõe realizar troca */
        for (int i = 0; (i < n - 1) && (troca); i++) {
            int aux;
            int nt = 0;
            troca = false; /* supõe não realizar troca */
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) { //operação essencial comparacao entre 2 elementos do vetor
                    trocas++;               //operação essencial troca entre 2 elementos do vetor
                    nt++;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    troca = true;  //registra que houve troca na iteração
                }
            }
        }
        System.out.println("\nNumero de Trocas: " + trocas);
        System.out.println("Numero de Comparacoes: " + comparacoes);
    }


}
