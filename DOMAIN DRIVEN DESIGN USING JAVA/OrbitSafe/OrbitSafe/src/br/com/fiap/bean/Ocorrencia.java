package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ocorrencia extends Cadastro{
    //atributo
    private String queixaAtual;
    private LocalDate dataAtual;
    private String nivelGravidade;

    //construtores
    public Ocorrencia(){

    }

    public Ocorrencia(String nomeUsuario, String cpf, String email, String telefone, String cidade, String bairro, String rua, int numeroResidencia, String queixaAtual, LocalDate dataAtual, String nivelGravidade){

        super.setNomeUsuario(nomeUsuario);
        super.setCpf(cpf);
        super.setEmail(email);
        super.setTelefone(telefone);
        super.setCidade(cidade);
        super.setBairro(bairro);
        super.setRua(rua);
        super.setNumeroResidencia(numeroResidencia);

        setQueixaAtual(queixaAtual);
        setDataAtual(dataAtual);
        setNivelGravidade(nivelGravidade);

    }
    //getters/setters

    public String getQueixaAtual() {
        return queixaAtual;
    }

    public void setQueixaAtual(String queixaAtual) {
        this.queixaAtual = queixaAtual;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getNivelGravidade() {
        return nivelGravidade;
    }

    public void setNivelGravidade(String nivelGravidade) {
        this.nivelGravidade = nivelGravidade;
    }

    //métodos da classe
    public void fazerQueixa(){

        setDataAtual(LocalDate.now());
        DateTimeFormatter formatobr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Usuário "+ getNomeUsuario() + ", precisa de suporte! Queixa: " + getQueixaAtual() + ", Data: "+     getDataAtual().format(formatobr));
    }

    public void emitirAlerta(){
        String mensagem = "Alerta emitido! Risco selecionado: " + this.nivelGravidade.toUpperCase();
        JOptionPane.showMessageDialog(null, mensagem, "OrbitSafe", JOptionPane.WARNING_MESSAGE);

    }

    public String toString() {
        setDataAtual(LocalDate.now());
        DateTimeFormatter formatobr = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return super.toString() + "[Usuário " + getNomeUsuario() + ", Queixa: " + queixaAtual + ", Nível: " + nivelGravidade + ", Data: " + dataAtual.format(formatobr) + "]";
    }
}