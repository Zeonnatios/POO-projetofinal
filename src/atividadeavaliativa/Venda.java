package atividadeavaliativa;

import java.time.LocalDate;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Venda extends Caixa {

    //CONSTRUTOR
    public Venda(Carro p, Double valor) {
        super(p, valor + valor * 0.23);
    }

    public void info() {
        super.info();
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------  INFORMAÇÕES DE VENDA  --------------------");
        System.out.println("------------------------  CARRO VENDIDO  -----------------------");
        System.out.println(carro);
        System.out.println("Data de Venda: " + dataVenda);
        System.out.println("Valor da Venda: " + valor);
        System.out.println("Lucro adquirido: " + carro.getPreco() * 0.23);
        System.out.println("----------------------------------------------------------------");
    }
}
