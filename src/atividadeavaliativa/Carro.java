package atividadeavaliativa;

import java.util.Scanner;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Carro {

    private int idCarro;
    private String modelo;
    private String marca;
    private int ano;
    private String placa;
    private String carroceria;
    private int kilometragem;
    private String tanque;
    private double preco;
    private boolean disponivel;

    //Função cadastrar carro
    public void cadastrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Qual é a marca do carro ?");
        marca = s.next();
        System.out.println("Qual o modelo do carro ?");
        modelo = s.next();
        System.out.println("Ano de fabricação ?");
        ano = s.nextInt();
        System.out.println("Informe a placa do carro: ");
        placa = s.next();
        System.out.println("Tipo de carroceria ?");
        carroceria = s.next();
        System.out.println("Kilometros rodados totais ?");
        kilometragem = s.nextInt();
        System.out.println("Quantidade de combustivel atual ? (Vazio, cheio, metade, 1/4, 3/4)");
        tanque = s.next();
        System.out.println("Preço do carro ?");
        preco = s.nextDouble();
        disponivel = true;
    }

    //Informação do carro
    public void infoCarro() {
        System.out.println("-------------------------------------------------");
        System.out.println("--------------------  CARRO  --------------------");
        System.out.println("ID: " + idCarro + "\n"
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Ano: " + ano + "\n"
                + "Placa: " + placa + "\n"
                + "Carroceria: " + carroceria + "\n"
                + "Kilometragem: " + kilometragem + "\n"
                + "Tanque: " + tanque + "\n"
                + "Preço: " + preco + "\n");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

    }

    //ToSting imprimir obj carro
    @Override
    public String toString() {
        String s = "--------------------  CARRO  --------------------\n"
                + "ID: " + idCarro + "\n"
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Ano: " + ano + "\n"
                + "Placa: " + placa + "\n"
                + "Carroceria: " + carroceria + "\n"
                + "Kilometragem: " + kilometragem + "\n"
                + "Tanque: " + tanque + "\n"
                + "Preço: " + preco + "\n"
                + "-------------------------------------------------\n";
        return s;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
