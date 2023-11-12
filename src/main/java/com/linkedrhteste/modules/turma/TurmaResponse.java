package com.linkedrhteste.modules.turma;

import com.linkedrhteste.modules.curso.Curso;

import java.util.Date;

public class TurmaResponse {
    private Integer codigo;
    private Date inicio;
    private Date fim;
    private String local;
    private Curso curso;

    public TurmaResponse(Integer codigo, Date inicio, Date fim, String local, Curso curso) {
        this.codigo = codigo;
        this.inicio = inicio;
        this.fim = fim;
        this.local = local;
        this.curso = curso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    public String getLocal() {
        return local;
    }

    public Curso getCurso() {
        return curso;
    }
}
