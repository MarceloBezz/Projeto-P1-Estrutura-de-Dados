import java.util.Scanner;

public class MenuCentralAtendimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CentralAtendimento centralAtendimento = new CentralAtendimento();
        System.out.println("""
            ##############################################
            ##### Bem vindo à Central de atendimento #####
            ##############################################
        """);
        
        int opcao = 6;
        while (opcao > 0) {
            System.out.println("""
                    Selecione a opção desejada:
                    1: Gerar Processo
                    2: Atender Próximo
                    3: Desfazer Último Atendimento
                    4: Listar Próximos
                    5: Listar Histórico

                    0: Sair""");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerarProcesso(scanner, centralAtendimento);
                    break;

                case 2:
                    atenderProximo(centralAtendimento);
                    break;

                case 3:
                    desfazerUltimoAtendimento(centralAtendimento);
                    break;

                case 4:
                    listarProximos(centralAtendimento);
                    break;

                case 5:
                    listarHistorico(centralAtendimento);
                    break;

                default:
                    System.out.println("Até a Próxima!");
                    break;
            }
        }
    }

    private static void listarHistorico(CentralAtendimento centralAtendimento) {
        try {
            System.out.println("Últimos atendimentos:");
            centralAtendimento.listarHistorico();
        } catch (Exception e) {
            System.out.println("Nenhum atendimento foi feito!");
        }
    }

    private static void listarProximos(CentralAtendimento centralAtendimento) {
        try {
            System.out.println("Próximos atendimentos:");
            centralAtendimento.listarPendentes();
        } catch (Exception e) {
            System.out.println("Não há próximos processos!");
        }
    }

    private static void desfazerUltimoAtendimento(CentralAtendimento centralAtendimento) {
        try {
            Processo ultimo = centralAtendimento.historico.peek();
            centralAtendimento.desfazerUltimoAtendimento();
            System.out.println("Desfazendo atendimento de Processo:\n" + ultimo.toString());
        } catch (Exception e) {
            System.out.println("Nenhum atendimento foi feito!");
        }
    }

    private static void atenderProximo(CentralAtendimento centralAtendimento) {
        try {
            Processo proximo = centralAtendimento.atendimentosPendentes.peek();
            centralAtendimento.atenderProximo();
            System.out.println("Atendendo Processo:\n" + proximo.toString());
        } catch (PilhaVaziaException e) {
            System.out.println("Não há próximos processos!");
        }
    }

    private static void gerarProcesso(Scanner scanner, CentralAtendimento centralAtendimento) {
        try {
            System.out.println("Informe os seguintes dados: ");
            System.out.print("Solicitante: ");
            String solicitante = scanner.nextLine();
    
            System.out.print("Tipo de Serviço: ");
            String tipoServico = scanner.nextLine();
    
            System.out.print("Prioridade (1 = Baixa; 2 = Normal; 3 = Urgente): ");
            int prioridade = scanner.nextInt();
            scanner.nextLine();
    
            Processo processo = new Processo(solicitante, tipoServico, prioridade);
            centralAtendimento.abrirProcesso(processo);
            System.out.println("Processo aberto com sucesso!\n" + processo.toString());
        } catch (Exception e) {
            System.out.println("Informe os dados corretamente!");
        }
    }
}
