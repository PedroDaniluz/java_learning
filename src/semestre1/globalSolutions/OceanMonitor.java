/*

* CARACTERES ESPECIAIS REMOVIDOS PARA EVITAR QUEBRA DE CODIFICACAO UTF-8
* SIMBOLO DE GRAU (º) -> LINHAS 37, 74, 211, 217, 220

==================== GRUPO ====================
 -> Pedro Daniluz - 97697
 -> Maria Eduarda de Carvalho Goda - 552276
 -> Roberto Tetsuo Tagashira - 551838
===============================================

*/

package semestre1.globalSolutions;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class OceanMonitor {

    // Objeto da classe Scanner deve ser global para poder ser usado em varios metodos
    public static Scanner le = new Scanner(System.in);

    // Classe Boia, que implementa o registro
    public static class Boia {
        int hashCode;
        String coordenandas;
        double salinidade, temperatura;

        // Metodo para exibir os dados de maneira mais simples ao decorrer do codigo
        public void exibir() {
            System.out.printf("Código Hash: %d\n", hashCode);
            System.out.printf("Coordenadas: %s\n", coordenandas);
            System.out.printf("Salinidade: %.3f\n", salinidade);
            System.out.printf("Temperatura: %.2fºC\n", temperatura);
        }
    }

    // Funcao para gerar o hascode a partir das coordenadas
    public static int geraHash(String linha) {
        String hash = "";
        // Como a linha tera apenas numeros, os indices foram modificados
        int[] indices = {0, 1, 4, 5};
        for (int indice : indices) {
            hash += linha.charAt(indice);
        }
        return Integer.parseInt(hash);
    }

    // A funcao geraVetorBoias utiliza o arquivo Coordenadas.txt para gerar um registro inical de boias
    // O retorno da funcao e essencial para delimitar o tamanho do registro
    public static int geraVetorBoias(Boia[] boias) {
        // Caminho do arquivo
        String caminhoDoArquivo = "C:\\Users\\pedro\\Documents\\FIAP\\2º Ano\\Algoritmos de Alta Performance\\java_learning\\src\\semestre1\\globalSolutions\\Coordenadas.txt";
        int n = 0;
        try {
            // Criar um objeto File com o caminho do arquivo
            File arquivo = new File(caminhoDoArquivo);

            // Criar um Scanner para ler o arquivo
            Scanner leArq = new Scanner(arquivo);

            // Loop para ler linha por linha ate o final do arquivo
            while (leArq.hasNextLine()) {
                // Cria um objeto Boia temporaria para adicao no registro
                Boia boiaTemp = new Boia();

                // Ler a proxima linha
                String linha = leArq.nextLine().replaceAll("[^0-9]", "");

                // Adiciona as coordenadas ao objeto boia, gerando e adicionando tambem o hashCode
                boiaTemp.coordenandas = String.format("Lat: -%s.%sº; Long: -%s.%sº", linha.substring(0, 2), linha.substring(2, 4), linha.substring(4, 6), linha.substring(6, 8));
                boiaTemp.hashCode = geraHash(linha);

                // Adiciona o objeto boiaTemp ao registro
                boias[n] = boiaTemp;
                n++;
            }
        } catch (FileNotFoundException e) {
            // Caso o arquivo nao seja encontrado
            System.out.println("Arquivo nao encontrado: " + e.getMessage());
        }
        return n;
    }

    // Funcao que percorre o registro completo, atualizando os valores de salinidade e temperatura
    public static void inserirSalTemp(Boia[] boias, int qntBoias) {
        for (int i = 0; i < qntBoias; i++) {
            // Solicita o valor de salinidade e valida a entrada (evitar quebra de execucao)
            System.out.printf("Insira o nivel de salinidade na boia %d: ", i + 1);
            do {
                try {
                    boias[i].salinidade = le.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.print("Insira um numero valido: ");
                    le.nextLine();
                }
            } while (true);
            // Solicita o valor de temperatura e valida a entrada (evitar quebra de execucao)
            System.out.printf("Insira a temperatura na boia %d: ", i + 1);
            do {
                try {
                    boias[i].temperatura = le.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.print("Insira um numero valido: ");
                    le.nextLine();
                }
            } while (true);
        }
    }


    // InsertionSort adaptado para ordenar o registro de boias
    public static void insertionSort(Boia[] boias, int qntBoias) {
        int j, i;
        Boia eleito;
        for (i = 1; i < qntBoias; i++) {
            eleito = boias[i];
            j = i - 1;
            while (j >= 0 && boias[j].hashCode > eleito.hashCode) {
                boias[j + 1] = boias[j];
                j = j - 1;
            }
            boias[j + 1] = eleito;
        }
    }


    // Busca binaria adaptado para encontrar um hashcode no registro de boias ordenado
    public static int buscaBinaria(Boia[] baseDados, int qntBoias, int hashProcurado) {
        int i_baixo = 0;
        int i_medio;
        int i_alto = qntBoias - 1;
        boolean achou = false;
        int posicao = -1;
        while (!achou && i_baixo <= i_alto) {
            i_medio = (i_baixo + i_alto) / 2;
            if (hashProcurado == baseDados[i_medio].hashCode) {
                posicao = i_medio;
                achou = true;
            } else {
                if (hashProcurado < baseDados[i_medio].hashCode)
                    i_alto = i_medio - 1;
                else
                    i_baixo = i_medio + 1;
            }
        }
        return posicao;
    }


    public static void main(String[] args) {
        // Tamanho maximo do registro de boias
        final int N = 20;

        // Declaracao do vetor de registro
        Boia[] boias = new Boia[N];

        // Iniciar vetor de registro a partir do arquivo txt, retornando o tamanho do registro para usos futuros
        int lenBoias = geraVetorBoias(boias);

        // Como solicitado, ao inicio do programa, a funcao inserirSalTemp percorre o registro solicitando
        // a insercao de temperatura e salinidade de cada objeto Boia
        inserirSalTemp(boias, lenBoias);

        // Finalmente o vetor e ordenado
        insertionSort(boias, lenBoias);

        // Criacao do Menu
        int opcao;

        do {
            System.out.println("0 - Sair");
            System.out.println("1 - Apresentacao das boias");
            System.out.println("2 - Insere mais 1 boia:");
            System.out.println("3 - Atualiza medidas");
            System.out.println("4 - Pesquisa medidas ");
            // Valida entrada numerica (evita quebra de execucao)
            do {
                try {
                    opcao = le.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.print("Insira um numero valido: ");
                    le.nextLine();
                }
            } while (true);

            switch (opcao) {
                case 0:
                    System.out.println("\n\n Fechando o sistema.... ");
                    break;
                case 1:
                    // Exibe todos os dados de cada boia, a partir do metodo 'exibir' do objeto Boia
                    System.out.println("=============== REGISTRO DE BOIAS ===============");
                    for (int i = 0; i < lenBoias; i++) {
                        System.out.printf("\n================== Boia %d ==================\n", i + 1);
                        boias[i].exibir();
                        System.out.println("============================================");
                    }
                    System.out.println();
                    break;
                case 2:
                    // Nao permite que o limite de registro seja superado
                    if (lenBoias < N) {
                        le.nextLine();
                        System.out.print("Insira as coordenadas no formato (-25.10°-44.17°): ");
                        Boia nova = new Boia();
                        String leitura = le.nextLine().replaceAll("[^0-9]", "");
                        // Validar entrada de coordenadas com base no formato do arquivo Coordenadas.txt:
                        do {
                            try {
                                nova.coordenandas = String.format("Lat: -%s.%sº; Long: -%s.%sº", leitura.substring(0, 2), leitura.substring(2, 4), leitura.substring(4, 6), leitura.substring(6, 8));
                                nova.hashCode = geraHash(leitura);
                            } catch (Exception e) {
                                System.out.print("Formato invalido tente novamente (-25 10°-44 17°):");
                                nova.coordenandas = le.nextLine();
                            }
                        } while (nova.hashCode == 0);

                        if (buscaBinaria(boias, lenBoias, nova.hashCode) != -1) {
                            System.out.println("\n --> A boia ja foi cadastrada anteriormente!\n");
                        } else {
                            System.out.print("Insira o nivel de salinidade na boia: ");
                            // Valida entrada numerica (evita quebra de execucao)
                            do {
                                try {
                                    nova.salinidade = le.nextDouble();
                                    break;
                                } catch (Exception e) {
                                    System.out.print("Insira um numero valido: ");
                                    le.nextLine();
                                }
                            } while (true);
                            System.out.print("Insira a temperatura na boia: ");
                            // Valida entrada numerica (evita quebra de execucao)
                            do {
                                try {
                                    nova.temperatura = le.nextDouble();
                                    break;
                                } catch (Exception e) {
                                    System.out.print("Insira um numero valido: ");
                                    le.nextLine();
                                }
                            } while (true);

                            boias[lenBoias] = nova;
                            lenBoias++;

                            insertionSort(boias, lenBoias);
                        }

                    } else {
                        System.out.println("\n --> O numero maximo de registros foi alcancado\n");
                    }
                    break;
                case 3:
                    // Atualiza medicoes de salinidade e temperatura
                    inserirSalTemp(boias, lenBoias);
                    break;
                case 4:
                    // Para a pesquisa binaria funcionar, o vetor deve ser ordenado. Como esse processo
                    // já foi realizado anteriormente (e apos adicao de novas boias), nao precisamos reordenar o vetor
                    // ***** insertionSort(boias, lenBoias) *****;

                    int hashBuscado;

                    System.out.print("Insira o codigo hash buscado: ");
                    // Valida entrada numerica (evita quebra de execucao)
                    do {
                        try {
                            hashBuscado = le.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.print("Insira um numero valido: ");
                            le.nextLine();
                        }
                    } while (true);

                    // Retorna a posicao do objeto no registro, ou -1 caso nao seja encontrado
                    int pos = buscaBinaria(boias, lenBoias, hashBuscado);
                    if (pos == -1) {
                        System.out.println("\nBoia nao encontrada!\n");
                    } else {
                        System.out.printf("\n================== Boia %d ==================\n", pos + 1);
                        boias[pos].exibir();
                        System.out.println("============================================\n");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao != 0);
        // Fecha o objeto da classe Scanner le
        le.close();
    }
}
