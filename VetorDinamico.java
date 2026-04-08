public class VetorDinamico {
    private Processo[] vetor;
    private int capacidade;
    private int ocupacao;
    

    public VetorDinamico(int capacidade) {
        this.capacidade = capacidade;
        ocupacao = 0;
        vetor = new Processo[capacidade];
    }

    public VetorDinamico() {
        this(4);
    }

    public String listar() {
        StringBuilder resultado = new StringBuilder();
        for (Processo processo : vetor) {
            if (processo != null)
                resultado.append(processo.toString()).append("\n");
        }
        return resultado.toString();
    }

    public void inserir(Processo processo) {
        vetor[ocupacao++] = processo;
        if (ocupacao == capacidade)
            redimensiona(capacidade * 2);
    }

    public void remover() {
        vetor[ocupacao--] = null;
        if ((capacidade / 4) > ocupacao)
            redimensiona(capacidade / 2);
    }

    public int buscarPorProtocolo(int protocolo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getProtocolo() == protocolo)
                return i;
        }
        return -1;
    }

    private void redimensiona(int novaCapacidade) {
        Processo[] temp = new Processo[novaCapacidade];
        for (int i = 0; i < ocupacao; i++) {
            temp[i] = vetor[i];
        }
        vetor = temp;
        capacidade = novaCapacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
