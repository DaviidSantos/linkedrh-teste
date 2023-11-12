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
}
