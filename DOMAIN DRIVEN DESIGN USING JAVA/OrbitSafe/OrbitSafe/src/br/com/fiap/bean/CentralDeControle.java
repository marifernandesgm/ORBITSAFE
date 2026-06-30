package br.com.fiap.bean;

public class CentralDeControle implements Operador {
    //atributos
    private String nomeCentral;
    private String statusOperacao;
    private String nivelGravidade;

    //construtores
    public CentralDeControle(){
        this.nomeCentral = "Central Principal";
    }

    public CentralDeControle(String nomeCentral, String statusOperacao, String nivelGravidade){
         setNomeCentral(nomeCentral);
         setStatusOperacao(statusOperacao);
         setNivelGravidade(nivelGravidade);
    }

    public String getNomeCentral() {
        return nomeCentral;
    }

    public void setNomeCentral(String nomeCentral) {
        this.nomeCentral = nomeCentral;
    }

    public String getStatusOperacao() {
        return statusOperacao;
    }

    public void setStatusOperacao(String statusOperacao) {
        this.statusOperacao = statusOperacao;
    }

    public String getNivelGravidade() {
        return nivelGravidade;
    }

    public void setNivelGravidade(String nivelGravidade) {
        this.nivelGravidade = nivelGravidade;
    }

    //métodos da classe

    public void analisarDados(String nivelGravidade) {
        System.out.println( this.nomeCentral + " Iniciando análise de dados");

        if (nivelGravidade.equalsIgnoreCase("Gravíssimo")) {
            this.statusOperacao = "ALERTA MÁXIMO";
        } else if (nivelGravidade.equalsIgnoreCase("Grave")) {
            this.statusOperacao = "ALERTA MODERADO";
        } else if (nivelGravidade.equalsIgnoreCase("Médio")) {
            this.statusOperacao = "MONITORAMENTO";
        } else {
            this.statusOperacao = "NORMAL";
        }

        System.out.println("Análise concluída. Novo status da Central: " + this.statusOperacao);

    }

    public String enviarSocorro(Ocorrencia ocorrencia) {
        String nivel = ocorrencia.getNivelGravidade();
        String mensagem;

        if (nivel.equalsIgnoreCase("Gravíssimo")) {
            mensagem = ("Bombeiro e Ambulância  foram enviados!");

        } else if (nivel.equalsIgnoreCase("Grave")) {
            mensagem = ("Carro de suporte enviado!");

        } else if (nivel.equalsIgnoreCase("Médio")) {
            mensagem = ("Drone enviado para inspeção!");

        } else {
            this.statusOperacao = "NORMAL";
            mensagem = ("Inspeção está sendo realizada pela central de contole");
        }
        return mensagem;
    }


    public void receberQueixaUsuario(Ocorrencia ocorrencia) {
        System.out.println(getNomeCentral() + " Recebendo queixa de: " + ocorrencia.getNomeUsuario());
        System.out.println("Detalhes da Queixa: " + ocorrencia.getQueixaAtual());

        // Pega o nível de gravidade que o usuário selecionou
        String nivel = ocorrencia.getNivelGravidade();

        // Analisa o nível para determinar o status
        if (nivel.equalsIgnoreCase("Gravíssimo")) {
            this.statusOperacao = "ALERTA MÁXIMO";

        } else if (nivel.equalsIgnoreCase("Grave")) {
            this.statusOperacao = "ALERTA MODERADO";

        } else if (nivel.equalsIgnoreCase("Médio")) {
            this.statusOperacao = "MONITORAMENTO";

        } else {
            this.statusOperacao = "NORMAL";
        }
    }

    @Override
    public String toString() {
        return "CentralControle [Nome da Central de Controle: " + getNomeCentral()+
                ", Status da operação: " + getStatusOperacao()+
                ", Nível da gravidade: " + getNivelGravidade()+ "]";
    }
}
