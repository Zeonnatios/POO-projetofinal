package atividadeavaliativa;

/**
 *
 * @author Matheus Antonio da Silva
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDeDados {

    //Usar MAP
    ArrayList<Carro> listaCarro = new ArrayList<>();

    public void addCarro() {

        Carro c = new Carro();
        c.cadastrar();
        System.out.println("-----------------------------");
        System.out.println("Carro cadastrado com sucesso!");
        c.infoCarro();
    }

    public void listByMarcaModelo(String marca, String modelo) {
        if (listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados!");
        } else {
            Carro c = new Carro();
            for (int i = 0; i < listaCarro.size(); i++) {
                if (listaCarro.get(i).getModelo().equals(modelo) && listaCarro.get(i).getMarca().equals(marca)) {
                    c = listaCarro.get(i);
                    c.infoCarro();
                }
            }
        }
    }

    public void listByCarroceria(String carroceria) {
        if (listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados!");
        } else {
            for (Carro c : listaCarro) {
                if (c.getCarroceria().equals(carroceria)) {
                    System.out.println(c.getMarca());
                }
            }
        }
    }

    public void listByPreco(String carroceria) {
        if (listaCarro.isEmpty()) {
            System.out.println("Não há carros cadastrados!");
        } else {
        }
    }

}
