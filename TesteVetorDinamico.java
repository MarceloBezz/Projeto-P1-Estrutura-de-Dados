import java.time.LocalDateTime;

public class TesteVetorDinamico {
    public static void main(String[] args) {
        VetorDinamico vetorDinamico = new VetorDinamico(); // Iniciando com capacidade = 4
        for (int i = 0; i < 25; i++) {
            Processo processo = new Processo("Solicitante", "SAÚDE", i % 3);
            processo.setDataHora(LocalDateTime.now()
                    .toString()
                    .substring(0, 16)
                    .replace("T", " "));
            vetorDinamico.inserir(processo);
        }
        System.out.println("Capacidade atual do Vetor: " + vetorDinamico.getCapacidade());

        for (int i = 0; i < 20; i++) {
            vetorDinamico.remover();
        }
        System.out.println("Capacidade atual do Vetor: " + vetorDinamico.getCapacidade());
    }
}
