package aula10_alocDinamica;

import java.util.Scanner;

public class ListaEncadeada {

    private static class NO {
        int dado;
        NO prox;
    }

    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        NO lista = new NO();

        //Primeiro NÓ
        System.out.print("Informe dado: ");
        lista.dado = le.nextInt();
        lista.prox = null;

        //Segundo NÓ
        NO novo = new NO();
        System.out.print("Informe dado: ");
        novo.dado = le.nextInt();
        novo.prox = null;

        //Conectando os 2 NÓS
        lista.prox = novo;

        NO novo2 = new NO();
        System.out.print("Informe dado: ");
        novo2.dado = le.nextInt();
        novo2.prox = null;

        novo.prox = novo2;

        NO aux = lista;

        while(aux!= null) {
            System.out.println(aux.dado);
            aux = aux.prox;
        }

        le.close();
    }
}