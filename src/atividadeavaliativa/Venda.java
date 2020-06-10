package atividadeavaliativa;

import java.time.LocalDate;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Venda {

    private static int qtdVendas;

    private int idVenda;
    private Carro carro;
    private LocalDate dataVenda;

    public Venda() {
        qtdVendas++;
        this.idVenda = qtdVendas;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
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

}
