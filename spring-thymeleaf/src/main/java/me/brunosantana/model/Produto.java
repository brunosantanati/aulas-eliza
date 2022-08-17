package me.brunosantana.model;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private BigDecimal preco;
    private String url;

    public Produto(String nome, BigDecimal preco, String url) {
        this.nome = nome;
        this.preco = preco;
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
