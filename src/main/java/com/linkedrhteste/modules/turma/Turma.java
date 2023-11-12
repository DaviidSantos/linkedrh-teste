package com.linkedrhteste.modules.turma;

import com.linkedrhteste.modules.curso.Curso;

import java.util.Date;

public class Turma {
    private Integer codigo;
    private Date inicio;
    private Date fim;
    private String local;
    private Curso curso;

    public Turma() {
    }

    public Turma(Integer codigo, Date inicio, Date fim, String local, Curso curso) {
        this.codigo = codigo;
        this.inicio = inicio;
        this.fim = fim;
        this.local = local;
        this.curso = curso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
