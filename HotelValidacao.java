package exerciciosApostila;

import java.util.Scanner;

public class HotelValidacao {

    static String vetCidades[] = {"BELO HORIZONTE", "SAO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"};

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        String nomeDoHospede[] = new String[100];
        float valorDaContaHospede[] = new float [100];
        float contValor = 0;
        String tipoDeQuarto="", cidadeDoHotel;
        byte diaDeEntrada=0, diaDeSaida=0, contPessoas = 0;
        int i;

        for (i = 0; i < 100; i++) {

            System.out.print("Nome do hospede(SAIR para finalizar): ");
            nomeDoHospede[i] = leia.next();
            if (nomeDoHospede[i].equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Dia de entrada no hotel: ");
            diaDeEntrada = leia.nextByte();

            do {
                System.out.print("Dia de saída do hotel: ");
                diaDeSaida = leia.nextByte();
                if (diaDeEntrada > diaDeSaida) {
                    System.out.println("\nO dia de saída deve ser maior que o dia de entrada!\n");
                }
            } while (diaDeEntrada > diaDeSaida);


            do {
                System.out.print("Tipo de quarto (STANDARD, LUXO ou SUPER-LUXO): ");
                tipoDeQuarto = leia.next();
                if ((!(tipoDeQuarto.equalsIgnoreCase("standard")))
                        && (!(tipoDeQuarto.equalsIgnoreCase("luxo")))
                        && (!(tipoDeQuarto.equalsIgnoreCase("super-luxo")))) {
                    System.out.println("\nAs opções são STANDARD, LUXO ou SUPER-LUXO...\n");
                }
            } while ((!(tipoDeQuarto.equalsIgnoreCase("standard")))
                    && (!(tipoDeQuarto.equalsIgnoreCase("luxo")))
                    && (!(tipoDeQuarto.equalsIgnoreCase("super-luxo"))));

            do {
                System.out.println("Digite a cidade do hotel");
                //ERRO CORRIGIDO: BUFFER
                leia.nextLine();
                cidadeDoHotel = leia.nextLine();


                if (cidadeEhValida(cidadeDoHotel) == false) {
                    System.out.println("Cidade Inválida!");
                }

            } while (cidadeEhValida(cidadeDoHotel) == false);

            valorDaContaHospede[i] = calcularConta(diaDeEntrada, diaDeSaida, tipoDeQuarto);
            contValor += valorDaContaHospede[i];
            contPessoas++;

            System.out.println("Valor da conta: " + valorDaContaHospede[i]);

            System.out.println("\n");
        }

        float media = contValor / contPessoas;

        System.out.println("====================================\n");
        System.out.println("Relatório de contas acima da média");
        System.out.println("-------------------------------------");
        System.out.println("Nome do hópede         Vlr conta    |");
        System.out.println("-------------------------------------");

        for (int x = 0; x < i; x++) {
            if (valorDaContaHospede[x] > media) {
                System.out.println(nomeDoHospede[x] + "                " + valorDaContaHospede[x]);
            }
        }

    }

    public static float calcularConta(byte diaEntrada, byte diaSaida, String tipoQuarto) {
        float valorDaConta;
        float valorDiaria;

        if (tipoQuarto.equalsIgnoreCase("standard")) {
            valorDiaria = 120;
        }else if(tipoQuarto.equalsIgnoreCase("luxo")) {
            valorDiaria = 150;
        }else {
            valorDiaria = 180;
        }

        valorDaConta = (diaSaida - diaEntrada) * valorDiaria;
        return valorDaConta;
    }



    public static boolean cidadeEhValida(String cidadeDigitada) {


//		for (int i = 0; i < vetCidades.length; i++) {
//			if (cidadeDigitada.equalsIgnoreCase(vetCidades[i])) {
//
//				return true;
//
//				//ERRO CORRIGIDO 2: NÃO TAVA FUNCIONANDO COM ==
//
//			}
//		}

        for (String cidade: vetCidades) {
            if (cidadeDigitada.equalsIgnoreCase(cidade)) {
                return true;
                //ERRO CORRIGIDO 2: NÃO TAVA FUNCIONANDO COM ==
            }
        }
        return false;

    }
}
