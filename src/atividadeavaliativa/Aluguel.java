package atividadeavaliativa;

import java.time.LocalDate;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Aluguel {

    private static int qtdAluguel;

    private int idAluguel;
    private Carro carro;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double precoAluguel;

    public Aluguel() {
        qtdAluguel++;
        this.idAluguel = qtdAluguel;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

}
