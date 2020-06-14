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
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class BancoDeDados {

    //Usar MAP
    Set<Carro> listaCarro = new HashSet<>();
    SortedMap<String, List<Carro>> byCarroceria = new TreeMap<>();
    Map<String, Carro> byMarca = new HashMap<>();
    Map<String, Carro> byModelo = new HashMap<>();
    Map<Integer, Carro> byId = new HashMap<>();

    Set<Caixa> operadorCaixa = new HashSet<>();

    public void addCarro(Carro c) {
        listaCarro.add(c);

        byId.put(c.getIdCarro(), c);
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

    public void addVenda(Carro c) {
        Caixa venda = new Venda(c, c.getPreco());
        inativarCarro(c.getIdCarro());
        operadorCaixa.add(venda);
        System.out.println("---------------------------");
        System.out.println("Venda efetuada com sucesso!");
        venda.info();
    }

    public void addAluguel(Carro c) {
        Caixa aluguel = new Aluguel(c);
        aluguel.efetuarAluguel();
        inativarCarro(c.getIdCarro());
        operadorCaixa.add(aluguel);
        System.out.println("---------------------------");
        System.out.println("Aluguel efetuad com sucesso!");
    }

    public Carro findById(int idCarro) {
        if (this.byId.isEmpty()) {
            return null;
        } else {
            Carro c = byId.get(idCarro);
            if (c.isDisponivel()) {
                return byId.get(idCarro);
            } else {
                return null;
            }

        }
    }

    public List<Carro> listbyId(int id) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<Integer, Carro> e : byId.entrySet()) {
            if (e.getValue().getIdCarro() == id && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

        }
        return lista;
    }

    public List<Carro> listByMarca(String marca) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byMarca.entrySet()) {
            if (e.getValue().getMarca().equals(marca) && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

        }
        return lista;
    }

    public List<Carro> listByModelo(String modelo) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byModelo.entrySet()) {
            if (e.getValue().getModelo().equals(modelo) && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

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

        List<Carro> lista = byCarroceria.get(c.getCarroceria());
        if (lista != null) {
            lista.remove(c);
        }
        byId.remove(c.getIdCarro());
        byMarca.remove(c.getMarca());
        byModelo.remove(c.getModelo());
        listaCarro.remove(c);

    }

    public void inativarCarro(int id) {
        for (Carro objCarro : listaCarro) {
            if (objCarro.getIdCarro() == id) {
                objCarro.setDisponivel(false);
            }
        }
    }

    public void reativarCarro(int id) {
        for (Carro objCarro : listaCarro) {
            if (objCarro.getIdCarro() == id) {
                objCarro.setDisponivel(true);
            }
        }
    }

}
