package semestre1.cp1;

import java.util.Scanner;

public class ONG {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double totalArrecadado, valorSolicitado, valorEmCaixa;
		int quantidadeEntidades = 0;
		
		System.out.print("Digite o valor arrecadado: R$");
		totalArrecadado = scanner.nextDouble();
		valorEmCaixa = totalArrecadado;
		
		System.out.println("(Digite 0 para sair) => Digite o valor solicitado: R$");
		valorSolicitado = scanner.nextDouble();
		
		while(valorSolicitado > 0 && valorEmCaixa > 0) {
			if(valorSolicitado > valorEmCaixa) {
				System.out.println("Não há valor em caixa para realizar a doação.");
			}
			else if(valorSolicitado > 0.2 * valorEmCaixa) {
				System.out.println("Limitado à 20% do valor em caixa");
				System.out.printf("O máximo permitido é R$%.2f\n", valorEmCaixa * 0.2);
			}
			else {
				valorEmCaixa -= valorSolicitado;
				quantidadeEntidades += 1;
			}
			
			System.out.println("Digite o valor solicitado: R$");
			valorSolicitado = scanner.nextDouble();
		}
		scanner.close();
		System.out.printf("Restaram R$%.2f em caixa.\n", valorEmCaixa);
		System.out.printf("%d entidade(s) foram beneficiadas.\n\n", quantidadeEntidades);
	}
}
