package aula8_eficiencia.busca;

import java.util.Scanner;

public class BuscaSequencial {
	static public class Registro {
		String info;
		int chave;
	}

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		final int N = 4;
		int i;

		/* cria a estrutura de dados (vetor) com N elementos */
		Registro basededados[] = new Registro[N];

		System.out.println("Criando vetor com " + N + " elementos: ");
		for (i = 0; i < N; i++) {
			Registro novo = new Registro();
			System.out.println("Nome aluno e RM");
			novo.info = le.next();
			novo.chave = le.nextInt();

			basededados[i] = novo;
		}

		System.out.println("Digite RM a ser procurado: ");
		int chaveproc = le.nextInt();
		while (chaveproc > 0) {
			int pos = buscaSequencial(basededados, chaveproc);
			if (pos == -1)
				System.out.println("RM não encontrado");
			else {
				System.out.println(basededados[pos].info);
			}
			System.out.println("\n\n Digite outro RM a ser procurado (0 ou negativo para sair): ");
			chaveproc = le.nextInt();
		}
		le.close();
	}

	public static int buscaSequencial(Registro baseDados[], int chaveproc) {
		int pos = -1;
		for (int i = 0; i < baseDados.length && pos == -1; i++)
			if ((baseDados[i].chave == chaveproc))
				pos = i;

		return pos;
	}
}
