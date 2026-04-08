public class CentralAtendimento {
    public PilhaProcesso atendimentosPendentes;
    public PilhaProcesso historico;

    public CentralAtendimento() {
        atendimentosPendentes = new PilhaProcesso();
        historico = new PilhaProcesso();
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
        atendimentosPendentes.imprimir();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}
