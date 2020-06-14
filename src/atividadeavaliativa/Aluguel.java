package atividadeavaliativa;

import java.time.LocalDate;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Aluguel extends Caixa {

    private LocalDate dataFim;
    private boolean ativo;

    //CONSTRUTOR
    public Aluguel(Carro p) {
        super(p);
    }

    public void InfoAluguel() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------  INFORMAÇÕES DE ALUGUEL  -------------------");
        System.out.println("------------------------  CARRO VENDIDO  -----------------------");
        System.out.println(carro);
        System.out.println("Data de Início: " + dataVenda);
        System.out.println("Valor do Aluguel: " + valor);
        System.out.println("----------------------------------------------------------------");

    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isDisp() {
        return ativo;
    }

    public void setDisp(boolean disp) {
        this.ativo = disp;
    }

}
