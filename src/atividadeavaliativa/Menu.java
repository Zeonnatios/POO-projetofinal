package atividadeavaliativa;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Menu {

    static Scanner sc = new Scanner(System.in);
    private static BancoDeDados banco = new BancoDeDados();

    // menu com entrada de dados
    static int menuOpcoes() {
        System.out.println("\n\n");
        System.out.println("------------Escolha a opção desejada:--------"
                + "\n1 - "
                + "\n2 - "
                + "\n3 - "
                + "\n4 - "
                + "\n0 - SAIR DO SISTEMA"
                + "\n---------------------------------------------");
        System.out.print("Digite a opção -->>");
        int opcao = sc.nextInt();
        System.out.println("\n\n");
        return opcao;
    }

    public static void main(String[] args) {

        // looping do menu
        boolean sair = false;
        while (!sair) {
            switch (menuOpcoes()) {
                case 1:
                    break;

                case 0:
                    sair = true;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        }

    }

}
