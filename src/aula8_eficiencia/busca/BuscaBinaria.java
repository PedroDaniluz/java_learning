package aula8_eficiencia.busca;

import java.util.Scanner;

public class BuscaBinaria {

	static public class Registro {
		String info;
		int chave;
	}

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);

		final int N = 4;
		int i;

		/* cria a estrutura de dados (vetor) com N elementos */
		Registro baseDados[] = new Registro[N];

		System.out.println("Criando vetor com " + N + " elementos: ");
		for (i = 0; i < N; i++) {
			Registro novo = new Registro();
			System.out.println("Nome aluno e RM");
			novo.info = le.next();
			novo.chave = le.nextInt();

			baseDados[i] = novo;
		}

		System.out.println("\n\n*********** Vetor ordenado para busca binaria**********");
		bubblesort(baseDados);
		for (i = 0; i < baseDados.length; i++) {
			System.out.println(baseDados[i].info + "\t" + baseDados[i].chave);
		}

		System.out.println("Digite RM procurado: ");
		int chaveproc = le.nextInt();
		while (chaveproc > 0) {
			int pos = buscaBinaria(baseDados, chaveproc);
			if (pos == -1)
				System.out.println("RM nao encontrado");
			else {
				System.out.println(baseDados[pos].info);
			}
			System.out.println("Digite outro RM a ser procurado (negativo para sair): ");
			chaveproc = le.nextInt();
		}
		le.close();

	}

	public static int buscaBinaria(Registro baseDados[], int chaveproc) {
		/* Pesquisa na estrutura de dados o valor solicitado */
		System.out.println("Procurando o chave solicitada...");
		int i_baixo = 0;
		int i_medio = 0;
		int i_alto = baseDados.length - 1;
		boolean achou = false;
		int posicao = -1;
		while (!achou && i_baixo <= i_alto) {
			i_medio = (i_baixo + i_alto) / 2;
			if (chaveproc == baseDados[i_medio].chave) {
				posicao = i_medio;
				achou = true;
			} else {
				if (chaveproc < baseDados[i_medio].chave)
					i_alto = i_medio - 1;
				else
					i_baixo = i_medio + 1;
			}
		}
		return posicao;
	}

	public static void bubblesort(Registro vetor[]) {
		int n = vetor.length;
		boolean troca = true; /* supõe realizar troca */
		for (int i = 0; (i < n - 1) && (troca); i++) {
			Registro aux;
			troca = false; /* supõe não realizar troca */
			for (int j = 0; j < n - i - 1; j++) {
				if (vetor[j].chave > vetor[j + 1].chave) {
					aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
					troca = true; // registra que houve troca na iteração
				}
			}
		}
	}

}
