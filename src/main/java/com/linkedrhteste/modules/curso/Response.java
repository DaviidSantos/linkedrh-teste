package com.linkedrhteste.modules.curso;

public class Response {
    private Integer codigo;
    private String nome;
    private String descricao;
    private Integer duracao;

    public Response(Integer codigo, String nome, String descricao, Integer duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }
}
