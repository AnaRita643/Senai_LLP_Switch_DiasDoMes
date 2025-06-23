package Atividade;

import java.util.Scanner;

public class DiasDoMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome ou número do mês: ");
        String entradaMes = scanner.nextLine().trim().toLowerCase();

        int mes = converterMes(entradaMes);

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido.");
            return;
        }

        int dias;

        if (mes == 2) {
            System.out.print("Informe o ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            dias = isBissexto(ano) ? 29 : 28;
        } else {
            dias = diasNoMes(mes);
        }

        System.out.printf("O mês possui %d dias.%n", dias);
        scanner.close();
    }

    private static int converterMes(String entrada) {
        try {
            // Se for número
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            // Se for nome
            return switch (entrada) {
                case "janeiro" -> 1;
                case "fevereiro" -> 2;
                case "março", "marco" -> 3;
                case "abril" -> 4;
                case "maio" -> 5;
                case "junho" -> 6;
                case "julho" -> 7;
                case "agosto" -> 8;
                case "setembro" -> 9;
                case "outubro" -> 10;
                case "novembro" -> 11;
                case "dezembro" -> 12;
                default -> -1;
            };
        }
    }

    private static int diasNoMes(int mes) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        };
    }

    private static boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
