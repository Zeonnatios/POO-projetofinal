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

    Set<Carro> listaCarro = new HashSet<>();
    SortedMap<String, List<Carro>> byCarroceria = new TreeMap<>();
    Map<String, Carro> byMarca = new HashMap<>();
    Map<String, Carro> byModelo = new HashMap<>();
    Map<Integer, Carro> byId = new HashMap<>();
    Map<Double, Carro> byPreco = new HashMap<>();
    Set<Caixa> operadorCaixa = new HashSet<>();
    private int contador = 1;

    //Função salvar carro na lista e nos Maps
    public void addCarro(Carro c) {
        c.cadastrar();
        c.setIdCarro(contador);
        contador++;
        listaCarro.add(c);
        byId.put(c.getIdCarro(), c);
        byMarca.put(c.getMarca(), c);
        byModelo.put(c.getModelo(), c);
        byPreco.put(c.getPreco(), c);
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

    //Criar venda e salvar na lista
    public void addVenda(Carro c) {
        Caixa venda = new Venda(c, c.getPreco());
        inativarCarro(c.getIdCarro());
        operadorCaixa.add(venda);
        System.out.println("---------------------------");
        System.out.println("Venda efetuada com sucesso!");
        venda.info();
    }

    //Criar aluguel e salvar na lista
    public void addAluguel(Carro c) {
        Caixa aluguel = new Aluguel(c);
        aluguel.efetuarAluguel();
        inativarCarro(c.getIdCarro());
        operadorCaixa.add(aluguel);
        System.out.println("---------------------------");
        System.out.println("Aluguel efetuado com sucesso!");
        aluguel.info();
    }

    //Achar carro pelo ID e que esteja disponivel
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

    //Criar lista pelo id do carro
    public List<Carro> listbyId(int id) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<Integer, Carro> e : byId.entrySet()) {
            if (e.getValue().getIdCarro() == id && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

        }
        return lista;
    }

    //Criar lista pela marca do carro
    public List<Carro> listByMarca(String marca) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byMarca.entrySet()) {
            if (e.getValue().getMarca().equals(marca) && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

        }
        return lista;
    }

    //Criar lista pelo modelo do carro
    public List<Carro> listByModelo(String modelo) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<String, Carro> e : byModelo.entrySet()) {
            if (e.getValue().getModelo().equals(modelo) && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }

        }
        return lista;
    }

    //Criar lista pelo preço do carro
    public List<Carro> listByPreco(Double pInicial, Double pFinal) {
        List<Carro> lista = new ArrayList<>();
        for (Map.Entry<Double, Carro> e : byPreco.entrySet()) {
            if (e.getValue().getPreco() >= pInicial && e.getValue().getPreco() <= pFinal && e.getValue().isDisponivel()) {
                lista.add(e.getValue());
            }
        }
        return lista;
    }

    //Criar lista pelo tipo de carroceria do carro
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

    //remove carro da lista de buscas
    public void removerCarro(Carro c) {
        List<Carro> lista = byCarroceria.get(c.getCarroceria());
        if (lista != null) {
            lista.remove(c);
        }
        byId.remove(c.getIdCarro());
        byMarca.remove(c.getMarca());
        byModelo.remove(c.getModelo());
        byPreco.remove(c.getPreco());
        listaCarro.remove(c);

    }

    //inativa carro
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
