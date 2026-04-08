public class CentralAtendimento {
    public PilhaPrioridade atendimentosPendentes;
    public PilhaPrioridade historico;

    public CentralAtendimento() {
        atendimentosPendentes = new PilhaPrioridade();
        historico = new PilhaPrioridade();
    }

    public void abrirProcesso(Processo processo) {
        atendimentosPendentes.push(processo);
    }

    public void atenderProximo() {
        Processo processo = atendimentosPendentes.peek();
        atendimentosPendentes.pop();
        historico.push(processo);
    }

    public void desfazerUltimoAtendimento() {
        Processo processo = historico.peek();
        historico.pop();
        atendimentosPendentes.push(processo);
    }

    public void listarPendentes() {
        atendimentosPendentes.listar();
    }

    public void listarHistorico() {
        historico.listar();
    }
}
