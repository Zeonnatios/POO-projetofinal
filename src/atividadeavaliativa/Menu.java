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
    public static void listarTipoCarroceria(String carroceria) {
        if (banco.listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados no BANCO DE DADOS!");
        } else if (banco.listByCarroceria(carroceria).isEmpty()) {
            System.out.println("Não há carros com carroceria cadastrados no BANCO DE DADOS");
        } else {
            List<Carro> listaCarros = banco.listByCarroceria(carroceria);
            for (int i = 0; i < listaCarros.size(); i++) {
                Carro c = listaCarros.get(i);
                if (c.isDisponivel()) {
                    c.infoCarro();
                }
            }
        }
    }

    //pelo ID
    public static void listarId(int id) {
        if (banco.listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados no BANCO DE DADOS!");
        } else if (banco.listbyId(id).isEmpty()) {
            System.out.println("Carro pesquisado por ID: " + id + ", não encontrado no BANCO DE DADOS!");
        } else {
            List<Carro> listaCarros = banco.listbyId(id);
            for (int i = 0; i < listaCarros.size(); i++) {
                Carro c = listaCarros.get(i);
                c.infoCarro();
            }
        }
    }

    //Listar por preços
    public static void listarPreco(Double pInicial, Double pFinal) {
        if (banco.listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados no BANCO DE DADOS!");
        } else if (banco.listByPreco(pInicial, pFinal).isEmpty()) {
            System.out.println("Carro pesquisado por preço entre: " + pInicial + " e " + pFinal + " , não encontrado no BANCO DE DADOS!");
        } else {
            List<Carro> listaCarros = banco.listByPreco(pInicial, pFinal);
            for (Carro c : listaCarros) {
                c.infoCarro();
            }
        }

    }

    // menu com entrada de dados
    static int menuOpcoes() {
        System.out.println("\n\n");
        System.out.println("------------Escolha a opção desejada:--------"
                + "\n1 - COMPRAR CARRO" //ok
                + "\n2 - VENDER CARRO" //ok
                + "\n3 - ALUGAR CARRO" //ok
                + "\n4 - CONSULTAR POR MARCA" //ok
                + "\n5 - CONSULTAR POR MODELO" //ok
                + "\n6 - CONSULTAR POR TIPO DE CARROCERIA" //ok
                + "\n7 - CONSULTAR POR ID" //ok
                + "\n8 - CONSULTAR POR PREÇOS" //ok
                + "\n0 - SAIR DO SISTEMA" //ok
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
                    banco.addCarro(c);
                    break;

                case 2:
                    System.out.println("Vendendo Carro!");
                    System.out.println("Informe o ID do carro que deseja Vender: ");
                    System.out.print("IDENTIFICADOR: ");
                    int idCar = sc.nextInt();
                    Carro carroVenda = new Carro();
                    carroVenda = banco.findById(idCar);
                    if (carroVenda == null) {
                        System.out.println("Carro não encontrado no Banco de Dados");
                        break;
                    } else {
                        banco.addVenda(carroVenda);
                        break;
                    }
                case 3:
                    System.out.println("Aluguel de Carro!");
                    System.out.println("Informe o ID do carro que deseja Alugar");
                    int idAluguel = sc.nextInt();
                    Carro carroAluguel = new Carro();
                    carroAluguel = banco.findById(idAluguel);
                    if (carroAluguel == null) {
                        System.out.println("Carro não encontrado no Banco de Dados");
                        break;
                    } else {
                        banco.addAluguel(carroAluguel);
                        break;
                    }

                case 4:
                    System.out.println("Informe a marca de carro a ser pesquisada:");
                    System.out.print("Marca: ");
                    String marca = sc.next();
                    listarMarca(marca);
                    break;

                case 5:
                    System.out.println("Informe o modelo de carro a ser pesquisada:");
                    System.out.print("Modelo: ");
                    String modelo = sc.next();
                    listarModelo(modelo);
                    break;

                case 6:
                    System.out.println("Informe a carroceria de carro que deseja buscar:");
                    System.out.print("Carroceria: ");
                    String carroceria = sc.next();
                    listarTipoCarroceria(carroceria);
                    break;

                case 7:
                    System.out.println("Informe o ID do carro que deseja buscar: ");
                    System.out.print("IDENTIFICADOR: ");
                    int idCarro = sc.nextInt();
                    listarId(idCarro);
                    break;

                case 8:
                    System.out.println("Informe o Preço Inicial e o Preço Final para realização da consulta:");
                    System.out.print("Preço Inicial:");
                    double pInicial = sc.nextDouble();
                    System.out.print("Preço Final:");
                    double pFinal = sc.nextDouble();
                    listarPreco(pInicial, pFinal);
                    break;

                case 0:
                    sair = true;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        }

    }

}
