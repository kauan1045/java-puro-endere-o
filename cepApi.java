package subsistema.cep;

import java.util.HashMap;
import java.util.Map;

public class CepApi {

    private static final CepApi instancia = new CepApi();

    private final Map<String, String[]> baseCep;
    private final Map<String, Integer> historicoConsultas;

    private CepApi() {
        baseCep = new HashMap<>();
        historicoConsultas = new HashMap<>();

        // Dados simulados
        baseCep.put("14800000", new String[]{"Araraquara", "SP"});
        baseCep.put("01001000", new String[]{"São Paulo", "SP"});
        baseCep.put("20040002", new String[]{"Rio de Janeiro", "RJ"});
    }

    public static CepApi getInstancia() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        simularDemora();
        registrarConsulta(cep);

        if (baseCep.containsKey(cep)) {
            return baseCep.get(cep)[0];
        }
        return "Cidade Desconhecida";
    }

    public String recuperarEstado(String cep) {
        simularDemora();
        registrarConsulta(cep);

        if (baseCep.containsKey(cep)) {
            return baseCep.get(cep)[1];
        }
        return "Estado Desconhecido";
    }

    private void simularDemora() {
        try {
            Thread.sleep(500); // simula delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void registrarConsulta(String cep) {
        historicoConsultas.put(cep, historicoConsultas.getOrDefault(cep, 0) + 1);
        System.out.println("[CepApi] Consulta registrada para o CEP: " + cep);
    }

    public void exibirHistoricoConsultas() {
        System.out.println("\n📊 Histórico de Consultas:");
        for (Map.Entry<String, Integer> entry : historicoConsultas.entrySet()) {
            System.out.println("CEP " + entry.getKey() + " consultado " + entry.getValue() + " vez(es)");
        }
    }
}
