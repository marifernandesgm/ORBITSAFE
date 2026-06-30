package br.com.fiap.bean;


public class Emergencia {
    //atributo
    private String nivelEmergencia;
    private String tempoEspera;

    //construtor
    public Emergencia() {

    }

    public Emergencia(String nivelEmergencia, String tempoEspera) {
        setNivelEmergencia(nivelEmergencia);
        setTempoEspera(tempoEspera);
    }

    public String getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(String nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }

    public String getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    //métodos da classe
    public void calcularTempoEspera(String nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;

        switch (nivelEmergencia.toUpperCase()) {
            case "GRAVÍSSIMO":
                this.tempoEspera = "Até 5 minutos";
                break;
            case "GRAVE":
                this.tempoEspera = "Até 15 minutos";
                break;
            case "MÉDIO":
                this.tempoEspera = "Até 30 minutos";
                break;
            case "NORMAL":
                this.tempoEspera = "Até 24 horas ";
                break;
            default:
                this.tempoEspera = "Erro!";
                break;

        }
    }

    public String toString(){
        return "Nivel de emergencia: " + nivelEmergencia + ", tempo de espera: " + tempoEspera;
    }
}