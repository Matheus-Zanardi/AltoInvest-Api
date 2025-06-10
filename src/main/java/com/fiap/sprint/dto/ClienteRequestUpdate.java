package com.fiap.sprint.dto;

public class ClienteRequestUpdate {

    private String nome;
    private int valor_investido;
    private int numero_conta;
    private String perfil_investidor;
    private int idade;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
        
    }
    public int getValor_investido() {
        return valor_investido;
    }
    public void setValor_investido(int valor_investido) {
        this.valor_investido = valor_investido;
    }
    public int getNumero_conta() {
        return numero_conta;
    }
    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }
    public String getPerfil_investidor() {
        return perfil_investidor;
    }
    public void setPerfil_investidor(String perfil_investidor) {
        this.perfil_investidor = perfil_investidor;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    
}
