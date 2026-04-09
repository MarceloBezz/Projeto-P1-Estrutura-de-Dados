public class TestesCentralAtendimento {
    public static void main(String[] args) {
        // Cada cenário é feito com uma Central de Atendimento com 9 Processos:
        // 3 Urgentes, 3 Normais e 3 Baixos
        // É gerado um de cada sequencialmente

        // Nota: O horário registrado de cada teste é referente ao horário em que
        // foram registrados, variando conforme novas execuções

        // Cadastro de processos fora de ordem em relação à urgência
        // Os processos mais urgentes são atendidos primeiro
        System.out.println("============================ CENÁRIO 1 ============================");
        cenario1();
        System.out.println("===================================================================");

        // Após atender alguns processo, cancelamento de atendimentos
        // Os processos mais urgentes são cancelados primeiro
        System.out.println("============================ CENÁRIO 2 ============================");
        cenario2();
        System.out.println("===================================================================");

        // Cancelamento de consulta sem haver histórico de processos
        // A exceção é tratada e apenas envia uma mensagem ao usuário
        System.out.println("============================ CENÁRIO 3 ============================");
        cenario3();
        System.out.println("===================================================================");

        // Listagem de histórico quando nenhum processo foi atendido
        // Uma mensagem é enviada ao usuário alertando a falta de processos no histórico
        // por urgência
        System.out.println("============================ CENÁRIO 4 ============================");
        cenario4();
        System.out.println("===================================================================");

        // Listagem de processos pendentes quando todos os processos já foram atendidos
        // Uma mensagem é enviada ao usuário alertando a falta de processos pendentes
        // por urgência
        System.out.println("============================ CENÁRIO 5 ============================");
        cenario5();
        System.out.println("===================================================================");
    }

    private static void cenario1() {
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        gerarProcessos(centralAtendimento);

        // SAÍDA:
        // Atendimentos urgentes:
        // [9] Solicitante 9 | SAÚDE | Urgente | 2026-04-09 09:55
        // [6] Solicitante 6 | SAÚDE | Urgente | 2026-04-09 09:55
        // [3] Solicitante 3 | SAÚDE | Urgente | 2026-04-09 09:55

        // Atendimentos normais:
        // [8] Solicitante 8 | SAÚDE | Normal | 2026-04-09 09:55
        // [5] Solicitante 5 | SAÚDE | Normal | 2026-04-09 09:55
        // [2] Solicitante 2 | SAÚDE | Normal | 2026-04-09 09:55

        // Atendimentos baixos:
        // [7] Solicitante 7 | SAÚDE | Baixa | 2026-04-09 09:55
        // [4] Solicitante 4 | SAÚDE | Baixa | 2026-04-09 09:55
        // [1] Solicitante 1 | SAÚDE | Baixa | 2026-04-09 09:55
        centralAtendimento.listarPendentes();

        // Atendimento apenas dos processos urgentes
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();

        // NOVA SAÍDA:
        // Atendimentos urgentes:
        // A pilha de urgentes não possui nenhum processo!

        // Atendimentos normais:
        // [8] Solicitante 8 | SAÚDE | Normal | 2026-04-09 09:57
        // [5] Solicitante 5 | SAÚDE | Normal | 2026-04-09 09:57
        // [2] Solicitante 2 | SAÚDE | Normal | 2026-04-09 09:57

        // Atendimentos baixos:
        // [7] Solicitante 7 | SAÚDE | Baixa | 2026-04-09 09:57
        // [4] Solicitante 4 | SAÚDE | Baixa | 2026-04-09 09:57
        // [1] Solicitante 1 | SAÚDE | Baixa | 2026-04-09 09:57
        centralAtendimento.listarPendentes();
    }

    private static void cenario2() {
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        gerarProcessos(centralAtendimento);

        // Atendendo todos os processos em ordem do mais urgente para o menos urgente
        // Como testado no cenário 1
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();

        // SAÍDA:
        // Atendimentos urgentes:
        // A pilha de urgentes não possui nenhum processo!
        //
        // Atendimentos normais:
        // A pilha de normais não possui nenhum processo!
        //
        // Atendimentos baixos:
        // A pilha de baixos não possui nenhum processo!
        centralAtendimento.listarPendentes();

        centralAtendimento.desfazerUltimoAtendimento();
        centralAtendimento.desfazerUltimoAtendimento();
        centralAtendimento.desfazerUltimoAtendimento();

        // SAÍDA:
        // Atendimentos urgentes:
        // [9] Solicitante 9 | SAÚDE | Urgente | 2026-04-09 10:47
        // [6] Solicitante 6 | SAÚDE | Urgente | 2026-04-09 10:47
        // [3] Solicitante 3 | SAÚDE | Urgente | 2026-04-09 10:47
        //
        // Atendimentos normais:
        // A pilha de normais não possui nenhum processo!
        //
        // Atendimentos baixos:
        // A pilha de baixos não possui nenhum processo!
        centralAtendimento.listarPendentes();
    }

    private static void cenario3() {
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        gerarProcessos(centralAtendimento);

        // SAÍDA:
        // Não há processos para desfazer!
        centralAtendimento.desfazerUltimoAtendimento();
    }

    private static void cenario4() {
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        gerarProcessos(centralAtendimento);

        // SAÍDA:
        // Atendimentos urgentes:
        // A pilha de urgentes não possui nenhum processo!
        //
        // Atendimentos normais:
        // A pilha de normais não possui nenhum processo!
        //
        // Atendimentos baixos:
        // A pilha de baixos não possui nenhum processo!
        centralAtendimento.listarHistorico();
    }

    private static void cenario5() {
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        gerarProcessos(centralAtendimento);

        // Atendendo todos os processos em ordem do mais urgente para o menos urgente
        // Como testado no cenário 1
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();
        centralAtendimento.atenderProximo();

        // SAÍDA:
        // Atendimentos urgentes:
        // A pilha de urgentes não possui nenhum processo!
        //
        // Atendimentos normais:
        // A pilha de normais não possui nenhum processo!
        //
        // Atendimentos baixos:
        // A pilha de baixos não possui nenhum processo!
        centralAtendimento.listarPendentes();
    }

    private static void gerarProcessos(CentralAtendimento centralAtendimento) {
        centralAtendimento.abrirProcesso(new Processo("Solicitante 1", "SAÚDE", 1));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 2", "SAÚDE", 2));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 3", "SAÚDE", 3));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 4", "SAÚDE", 1));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 5", "SAÚDE", 2));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 6", "SAÚDE", 3));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 7", "SAÚDE", 1));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 8", "SAÚDE", 2));
        centralAtendimento.abrirProcesso(new Processo("Solicitante 9", "SAÚDE", 3));
    }
}
