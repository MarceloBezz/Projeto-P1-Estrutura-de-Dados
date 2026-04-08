public class PilhaProcesso {
    private VetorDinamico vetor;

    public PilhaProcesso() {
        vetor = new VetorDinamico();
    }

    public void push(Processo processo) {
        vetor.inserir(processo);
    }

    public void pop() {
        if (vetor.getOcupacao() == 0)
            throw new PilhaVaziaException("Pilha vazia! Não há o que remover!");

        vetor.remover();
    }

    public Processo peek() {
        if (vetor.getOcupacao() == 0)
            throw new PilhaVaziaException("Pilha vazia! Não há o que retornar!");

        return vetor.getVetor()[vetor.getOcupacao() - 1];
    }

    public void imprimir() {
        if (vetor.getOcupacao() == 0)
            throw new PilhaVaziaException("Pilha vazia! Não há o que imprimir!");

        StringBuilder sb = new StringBuilder();
        for (int i = vetor.getOcupacao() - 1; i >= 0; i--) {
            sb.append(vetor.getVetor()[i].toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
