package aula8_eficiencia.busca;

import java.util.Scanner;

public class BuscaExaustiva {

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
			System.out.println("Nome aluno e nota (apenas inteiro)");
			novo.info = le.next();
			novo.chave = le.nextInt();

			baseDados[i] = novo;
		}

		System.out.println("Digite nota procurada: ");
		int chaveproc = le.nextInt();
		while (chaveproc >= 0) {
			Registro encontrados[] = new Registro[N];
			int ne = buscaSequencialExaustiva(baseDados, chaveproc, encontrados);
			if (ne == 0)
				System.out.println("Nota n�o encontrada\n");
			else {
				System.out.println("Nota encontrada no(s) registro(s)");
				for (i = 0; i < ne; i++)
					System.out.println(encontrados[i].info);
			}
			System.out.println("\n\n Digite outra nota a ser procurada: ");
			chaveproc = le.nextInt();
		}
		le.close();
	}

	public static int buscaSequencialExaustiva(Registro bd[], int chave, Registro encontrados[]) {
		int i, ne = 0;
		int num = bd.length;
		for (i = 0; i < num; i++) {
			if (bd[i].chave == chave) {
				encontrados[ne] = bd[i];
				/* armazena registro da posi��o em que a chave foi encontrada */
				ne++;
			}
		}
		return (ne); /* quantidade de registros com a chave procurada */
	}
}
