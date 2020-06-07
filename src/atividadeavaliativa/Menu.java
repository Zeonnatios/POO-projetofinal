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
                + "\n1 - COMPRAR CARRO"
                + "\n2 - VENDER CARRO"
                + "\n3 - RETIRADA DE CARRO"
                + "\n4 - DEVOLUÇÃO DE CARRO"
                + "\n5 - CONSULTAR POR MARCA E MODELO"
                + "\n6 - CONSULTAR POR TIPO DE CARROCERIA"
                + "\n7 - CONSULTAR POR PREÇO"
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
                    System.out.println("Cadastrando Carro!");
                    banco.addCarro();
                    break;

                case 2:
                    System.out.println("Vender Carro!");
                    break;

                case 3:
                    System.out.println("Retirada de Carro!");
                    break;

                case 4:
                    System.out.println("Devolução de Carro!");
                    break;

                case 5:
                    System.out.println("Informe a marca e modelo de carro que deseja procurar:");
                    System.out.print("Marca: ");
                    String marca = sc.next();
                    System.out.print("Modelo: ");
                    String modelo = sc.next();
                    banco.listByMarcaModelo(marca, modelo);
                    break;

                case 6:
                    System.out.println("Informe a carroceria de carro que deseja buscar:");
                    System.out.print("Carroceria: ");
                    String carroceria = sc.next();
                    banco.listByCarroceria(carroceria);
                    break;

                case 7:
                    break;

                case 0:
                    sair = true;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        }

    }

}
