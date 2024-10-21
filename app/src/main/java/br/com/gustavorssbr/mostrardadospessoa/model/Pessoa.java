package br.com.gustavorssbr.mostrardadospessoa.model;

public class Pessoa {
    private String nome;
    private String cpf;


    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String capturarNonoDigito(){
        return String.valueOf(cpf.charAt(8));
    }
}
