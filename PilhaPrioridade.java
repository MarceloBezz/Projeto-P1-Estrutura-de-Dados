public class PilhaPrioridade {
    private PilhaProcesso baixa;
    private PilhaProcesso normal;
    private PilhaProcesso urgente;

    public PilhaPrioridade() {
        baixa = new PilhaProcesso();
        normal = new PilhaProcesso();
        urgente = new PilhaProcesso();
    }

    public void push(Processo processo) {
        switch (processo.getPrioridade()) {
            case 1:
                baixa.push(processo);
                break;

            case 2:
                normal.push(processo);
                break;

            default:
                urgente.push(processo);
                break;
        }
    }

    public void pop() {
        if (urgente.ocupacaoVetor() > 0)
            urgente.pop();
        else if (normal.ocupacaoVetor() > 0)
            normal.pop();
        else if (baixa.ocupacaoVetor() > 0)
            baixa.pop();
        else
            throw new PilhaVaziaException("Não há processos em nenhuma pilha!");
    }

    public Processo peek() {
        if (urgente.ocupacaoVetor() > 0)
            return urgente.peek();
        else if (normal.ocupacaoVetor() > 0)
            return normal.peek();
        else if (baixa.ocupacaoVetor() > 0)
            return baixa.peek();
        else
            throw new PilhaVaziaException("Não há processos em nenhuma pilha!");
    }

    public int tamanho() {
        return urgente.ocupacaoVetor() + normal.ocupacaoVetor() + baixa.ocupacaoVetor();
    }

    public void listar() {
        try {
            System.out.println("Atendimentos urgentes:");
            urgente.imprimir();
        } catch (PilhaVaziaException e) {
            System.out.println("A pilha de urgentes não possui nenhum processo!");
        }

        try {
            System.out.println("Atendimentos normais:");
            normal.imprimir();
        } catch (PilhaVaziaException e) {
            System.out.println("A pilha de normais não possui nenhum processo!");
        }

        try {
            System.out.println("Atendimentos baixos:");
            baixa.imprimir();
        } catch (PilhaVaziaException e) {
            System.out.println("A pilha de baixos não possui nenhum processo!");
        }
    }

    public void clear() {
        while (tamanho() > 0)
            pop();
    }
}
