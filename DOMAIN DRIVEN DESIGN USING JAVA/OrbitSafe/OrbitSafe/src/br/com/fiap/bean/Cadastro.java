package br.com.fiap.bean;

public class Cadastro {
    //atributos
    private String nomeUsuario;
    private String cpf;
    private String email;
    private String telefone;
    private String cidade;
    private String bairro;
    private String rua;
    private int numeroResidencia;

    //construtores
    public Cadastro() {
    }

    public Cadastro(String nomeUsuario, String cpf, String email, String telefone, String cidade, String bairro, String rua, int numeroResidencia){
        setNomeUsuario(nomeUsuario);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumeroResidencia(numeroResidencia);
    }

    //getters/setters

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(int numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    //métodos da classe
    public void atualizarCadastro(String nomeUsuario, String cpf, String email, String telefone, String cidade, String bairro, String rua, int numeroResidencia) {
        setNomeUsuario(nomeUsuario);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumeroResidencia(numeroResidencia);
    }



    public String toString(){
        return "Cadastro [Nome: " + nomeUsuario+
                ", CPF: " + cpf +
                ", E-mail: " + email +
                ", Telefone: "+ telefone  +
                ", Cidade: " + cidade +
                ", Bairro: " + bairro +
                ", Rua: " + rua +
                "N°" + numeroResidencia+ "]";
    }
}
