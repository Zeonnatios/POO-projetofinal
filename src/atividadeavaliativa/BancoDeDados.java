package atividadeavaliativa;

/**
 *
 * @author Matheus Antonio da Silva
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class BancoDeDados {

    //Usar MAP
    Set<Carro> listaCarro = new HashSet<>();
    SortedMap<String, List<Carro>> byCarroceria = new TreeMap<>();
    Map<String, Carro> byMarca = new HashMap<>();
    Map<String, Carro> byModelo = new HashMap<>();

    public void addCarro(Carro c) {
        listaCarro.add(c);

        byMarca.put(c.getMarca(), c);
        byModelo.put(c.getModelo(), c);
        List<Carro> lista = byCarroceria.get(c.getCarroceria());
        if (lista == null) {
            lista = new ArrayList<>();
            byCarroceria.put(c.getCarroceria(), lista);
        }
        lista.add(c);
        System.out.println("-----------------------------");
        System.out.println("Carro cadastrado com sucesso!");
        c.infoCarro();
    }

    public Carro findByMarca(String marca) {
        return byMarca.get(marca);
    }

    public Carro findByModelo(String modelo) {
        return byModelo.get(modelo);
    }

    public void listByPreco(String carroceria) {

    }

    public List<Carro> listByMarca() {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byMarca.entrySet()) {
            lista.add(e.getValue());
        }
        return lista;
    }

    public List<Carro> listByModelo() {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byModelo.entrySet()) {
            lista.add(e.getValue());
        }
        return lista;
    }

    public List<Carro> listByCarroceria(String carroceria) {
        List<Carro> lista = new ArrayList<>();
        SortedMap<String, List<Carro>> submapa = byCarroceria.tailMap(carroceria);
        for (Map.Entry<String, List<Carro>> mapEntry : submapa.entrySet()) {
            String aux = mapEntry.getKey();
            if (aux.startsWith(carroceria)) {
                List<Carro> p = mapEntry.getValue();
                lista.addAll(p);
            } else {
                break;
            }
        }
        return lista;
    }

    public void removerCarro(Carro c) {
        listaCarro.remove(c);
        byMarca.remove(c.getMarca());
        byModelo.remove(c.getModelo());
        List<Carro> lista = byCarroceria.get(c.getCarroceria());
        if (lista != null) {
            lista.remove(c);
        }
    }

}
