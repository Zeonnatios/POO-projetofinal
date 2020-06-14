package atividadeavaliativa;

import java.time.LocalDate;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Caixa {

    protected Carro carro;
    protected LocalDate dataVenda;
    protected double valor;

    //CONSTRUTOR VENDAS
    public Caixa(Carro c, double valor) {
        this.carro = c;
        this.dataVenda = LocalDate.now();
        this.valor = valor;
    }

    //CONSTRUTOR PARA ALUGUEL
    public Caixa(Carro c) {
        this.carro = c;
    }

    public void info() {

    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
