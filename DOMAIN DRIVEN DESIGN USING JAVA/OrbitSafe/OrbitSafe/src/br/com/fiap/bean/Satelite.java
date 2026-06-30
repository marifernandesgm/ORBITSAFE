package br.com.fiap.bean;

public class Satelite {
    //atributos
    private String nomeSatelite;
    private double localizacao;
    private String statusRede;

    //construtores
    public Satelite(){
        this.nomeSatelite = "OrbitSafe";
    }

    public Satelite(String nomeSatelite, double localizacao, String statusRede){

        setNomeSatelite(nomeSatelite);
        setLocalizacao(localizacao);
        setStatusRede(statusRede);

    }

    //getters/setters


    public String getNomeSatelite() {
        return nomeSatelite;
    }

    public void setNomeSatelite(String nomeSatelite) {
        this.nomeSatelite = nomeSatelite;
    }

    public double getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(double localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatusRede() {
        return statusRede;
    }

    public void setStatusRede(String statusRede) {
        this.statusRede = statusRede;
    }

    //métodos da classe
    public void localizacaoReaL(double latitude, double longitude){
          this.localizacao = latitude + longitude;
    }

    public void determinarStatusRede(String gravidade){

        if (gravidade.equalsIgnoreCase("Grave") || gravidade.equalsIgnoreCase("Gravíssimo")) {
            this.statusRede = "Desconectado!";
            System.out.println("Desconectado!");
        } else {
            this.statusRede = "Conectado";
            System.out.println("Conectado");
        }
    }


    public String toString() {
        return "Satélite [Nome: " + getNomeSatelite() +
                " | Localização: " + getLocalizacao() +
                " | Status de Rede: " + getStatusRede()+ "]";
    }
}
