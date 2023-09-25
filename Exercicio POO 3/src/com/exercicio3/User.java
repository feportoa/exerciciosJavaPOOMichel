package com.exercicio3;

public class User {

    private String nome;
    private String cpf;
    private String email;
    private String passwd;
    private byte idade;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public byte getIdade() {
        return this.idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }
}
