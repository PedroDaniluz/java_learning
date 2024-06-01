package aula8_eficiencia.ordenacao;

import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        Random gerador = new Random();
        int N = 100;
        // cria a estrutura de dados (vetor) com N elementos gera vetor fora de ordem
        int vetor[] = new int[N];
        int i;

        System.out.println("Criando vetor com " + N + " elementos: ");
        for (i = 0; i < N; i++) {
            vetor[i] = gerador.nextInt(50000);
            //System.out.print(vetor[i] + "\t");
        }


        insertionSort(vetor);
        System.out.println("\nVetor ordenando com Insertionsort ");
        //	for (i = 0; i < N; i++)
        //	System.out.println(i + "\t" + vetor[i]);

        System.out.println("\n*********** Aplicando InsertionSort ao Vetor Ordenado *********");
        insertionSort(vetor);

    }

    public static void insertionSort(int vetor[]) {
        int comparacoes = 0, trocas = 0;
        int n = vetor.length;
        int eleito, j, i;
        for (i = 1; i < n; i++) {
            eleito = vetor[i];
            j = i - 1;
            comparacoes++;
            while (j >= 0 && vetor[j] > eleito) {
                trocas++;
                comparacoes++;
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = eleito;
        }

        System.out.println("\nNumero de Trocas: " + trocas);
        System.out.println("Numero de Comparacoes: " + comparacoes);
    }

}
