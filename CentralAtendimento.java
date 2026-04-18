public class CentralAtendimento {
    public PilhaPrioridade atendimentosPendentes;
    public PilhaPrioridade historico;

    public CentralAtendimento() {
        atendimentosPendentes = new PilhaPrioridade();
        historico = new PilhaPrioridade();
    }

    public void abrirProcesso(Processo processo) {
        atendimentosPendentes.push(processo);
        historico.clear();
    }

    public void atenderProximo() {
        try {
            Processo processo = atendimentosPendentes.peek();
            atendimentosPendentes.pop();
            historico.push(processo);
        } catch (PilhaVaziaException e) {
            System.out.println("Não há processos para atender!");
        }
    }

    public void desfazerUltimoAtendimento() {
        try {
            Processo processo = historico.peek();
            historico.pop();
            atendimentosPendentes.push(processo);
        } catch (PilhaVaziaException e) {
            System.out.println("Não há processos para desfazer!");
        }
    }

    public void listarPendentes() {
        atendimentosPendentes.listar();
    }

    public void listarHistorico() {
        historico.listar();
    }
}
