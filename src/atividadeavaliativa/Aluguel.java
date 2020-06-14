package atividadeavaliativa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Matheus Antonio da Silva
 */
public class Aluguel extends Caixa {

    private LocalDate dataFim;

    //CONSTRUTOR
    public Aluguel(Carro p) {
        super(p);
    }

    public void efetuarAluguel() {
        super.efetuarAluguel();
        Scanner sc = new Scanner(System.in);
        System.out.println("Infome a data para devolução do carro: (numeral) ");
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        dataFim = LocalDate.of(2020, mes, dia);
        long diferencaEmDias = ChronoUnit.DAYS.between(dataVenda, dataFim);
        valor = 126.8 * diferencaEmDias;
    }

    public void InfoAluguel() {
        super.info();
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------  INFORMAÇÕES DE ALUGUEL  -------------------");
        System.out.println("------------------------  CARRO VENDIDO  -----------------------");
        System.out.println(carro);
        System.out.println("Data de início do aluguel:  " + dataVenda);
        System.out.println("Data de término do aluguel: " + dataFim);
        System.out.println("Valor do Aluguel total: " + valor);
        System.out.println("Valor diário: " + 126.8);
        System.out.println("----------------------------------------------------------------");

    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
