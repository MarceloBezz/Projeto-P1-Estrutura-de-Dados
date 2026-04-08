import java.time.LocalDateTime;

public class Processo {
    private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;
    public static int contador = 0;

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        this.protocolo = ++contador;
        this.dataHora = LocalDateTime.now()
                    .toString()
                    .substring(0, 16)
                    .replace("T", " ");
    }

    public int getProtocolo() {
        return protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "[%d] %s | %s | %s | %s".formatted(protocolo, solicitante, tipoServico, valorPrioridade(), dataHora);
    }

    private String valorPrioridade() {
        switch (prioridade) {
            case 1:
                return "Baixa";

            case 2:
                return "Normal";

            default:
                return "Urgente";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Processo other = (Processo) obj;
        if (protocolo != other.protocolo)
            return false;
        return true;
    }

}