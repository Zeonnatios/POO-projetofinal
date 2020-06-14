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

    //Listagem por marca
    public static void listarMarca(String marca) {
        if (banco.listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados no BANCO DE DADOS!");
        } else if (banco.listByMarca(marca).isEmpty()) {
            System.out.println("Não há essa marca de carros no sistema!");
        } else {
            List<Carro> listaCarros = banco.listByMarca(marca);
            for (Carro c : listaCarros) {
                c.infoCarro();
            }
        }
    }

    //Listagem por modelo
    public static void listarModelo(String modelo) {
        if (banco.listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados no BANCO DE DADOS!");
        } else if (banco.listByModelo(modelo).isEmpty()) {
            System.out.println("Não há esse modelo cadastrados no BANCO DE DADOS!");
        } else {
            List<Carro> listaCarros = banco.listByModelo(modelo);
            for (Carro c : listaCarros) {
                c.infoCarro();
            }
        }
    }

    //Listagem por Carroceria
    public static void listarTipoCarroceria(String c) {
        if (banco.listByCarroceria(c).isEmpty()) {
            System.out.println("Não há carros com essas especificações cadastrados no BANCO DE DADOS");
        } else {
            List<Carro> listaCarros = banco.listByCarroceria(c);
            for (int i = 0; i < listaCarros.size(); i++) {
                Carro l = listaCarros.get(i);
                l.infoCarro();
            }
        }
    }

    // menu com entrada de dados
    static int menuOpcoes() {
        System.out.println("\n\n");
        System.out.println("------------Escolha a opção desejada:--------"
                + "\n1 - COMPRAR CARRO"
                + "\n2 - VENDER CARRO"
                + "\n3 - RETIRADA DE CARRO"
                + "\n4 - DEVOLUÇÃO DE CARRO"
                + "\n5 - CONSULTAR POR MARCA"
                + "\n6 - CONSULTAR POR MODELO"
                + "\n7 - CONSULTAR POR TIPO DE CARROCERIA"
                + "\n8 - CONSULTAR POR ID"
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
                    Carro c = new Carro();
                    c.cadastrar();
                    banco.addCarro(c);
                    break;

                case 2:
                    System.out.println("Vendendo Carro!");
                    System.out.println("Informe o ID do carro que deseja buscar: ");
                    System.out.print("IDENTIFICADOR: ");
                    int idCar = sc.nextInt();
                    Carro busca = new Carro();
                    busca = banco.findById(idCar);
                    banco.addVenda(busca);
                    break;

                case 3:
                    System.out.println("Aluguel de Carro!");
                    break;

                case 4:
                    System.out.println("Devolução de Carro!");
                    break;

                case 5:
                    System.out.println("Informe a marca de carro a ser pesquisada:");
                    System.out.print("Marca: ");
                    String marca = sc.next();
                    listarMarca(marca);
                    break;

                case 6:
                    System.out.println("Informe o modelo de carro a ser pesquisada:");
                    System.out.print("Modelo: ");
                    String modelo = sc.next();
                    listarModelo(modelo);
                    break;

                case 7:
                    System.out.println("Informe a carroceria de carro que deseja buscar:");
                    System.out.print("Carroceria: ");
                    String carroceria = sc.next();
                    listarTipoCarroceria(carroceria);
                    break;

                case 8:
                    System.out.println("Informe o ID do carro que deseja buscar: ");
                    System.out.print("IDENTIFICADOR: ");
                    int idCarro = sc.nextInt();
                    Carro find = new Carro();
                    System.out.println(find = banco.findById(idCarro));
                    break;

                case 0:
                    sair = true;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        }

    }

}
