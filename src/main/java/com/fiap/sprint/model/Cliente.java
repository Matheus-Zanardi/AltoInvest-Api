package com.fiap.sprint.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private int valor_investido;
    private int numero_conta;
    private String perfil_investidor;
    private int idade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
