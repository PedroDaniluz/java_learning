package aula8_eficiencia.ordenacao;

import java.util.Random;


public class QuickSort {

    public static int comparacoes = 0;
    public static int trocas = 0;


    public static void main(String[] args) {

        final int N = 1000;
        /*cria a estrutura de dados (vetor) com N elementos  gera vetor fora de ordem*/
        int vetor[] = new int[N];
        int i;

        Random gerador = new Random();
        System.out.println("Criando vetor com " + N + " elementos: ");
        for (i = 0; i < N; i++) {
            vetor[i] = gerador.nextInt(50000);
            //	System.out.print(vetor[i]+"  ");
        }
        System.out.println();

        System.out.println("Ordenando o vetor com Quicksort... ");
        quickSort(vetor, 0, N - 1);
        System.out.println("\n\nComparações realizadas: " + comparacoes + "\n Trocas efetuadas: " + trocas);


        System.out.println("\n*********** Vetor Ordenado *********");
        System.out.println("Ordenando o vetor com Quicksort... ");
        quickSort(vetor, 0, N - 1);
        System.out.println("\n\nComparações realizadas: " + comparacoes + "\n Trocas efetuadas: " + trocas);

    }

    public static int particiona(int x[], int li, int ls) {
        int pivo, abaixo, temp, acima;
        pivo = x[ls];
        acima = ls;
        abaixo = li;
        while (abaixo < acima) {
            comparacoes++;
            while (x[abaixo] < pivo && abaixo < ls) {
                abaixo++;
                comparacoes++;
            }
            comparacoes++;
            while (x[acima] >= pivo && acima > abaixo) {
                comparacoes++;
                acima--;
            }
            if (abaixo < acima) {
                trocas++;
                temp = x[abaixo];
                x[abaixo] = x[acima];
                x[acima] = temp;
            }
        }
        trocas++;
        x[ls] = x[acima];
        x[acima] = pivo;
        return acima;
    }


    public static void quickSort(int x[], int li, int ls) {
        int j;
        if (li < ls) {
            j = particiona(x, li, ls);
            quickSort(x, li, j - 1);
            quickSort(x, j + 1, ls);
        }
    }

}
