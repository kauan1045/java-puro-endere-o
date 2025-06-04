public class Main {
    public static void Main(String[] args) {
        CepApi api = CepApi.getInstancia();

        System.out.println(api.recuperarCidade("14800000")); // Araraquara
        System.out.println(api.recuperarEstado("14800000")); // SP

        System.out.println(api.recuperarCidade("01001000")); // São Paulo
        System.out.println(api.recuperarEstado("99999999")); // Estado Desconhecido

        api.exibirHistoricoConsultas();
    }
}
