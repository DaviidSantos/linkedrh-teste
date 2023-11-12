package com.linkedrhteste.modules.turma;

import com.linkedrhteste.modules.curso.Curso;

import java.util.Date;

public class TurmaResponse {
    private Integer codigo;
    private Date inicio;
    private Date fim;
    private String local;
    private String curso;
    private int qtdParticipantes;

    public TurmaResponse(Integer codigo, Date inicio, Date fim, String local, String curso, int qtdParticipantes) {
        this.codigo = codigo;
        this.inicio = inicio;
        this.fim = fim;
        this.local = local;
        this.curso = curso;
        this.qtdParticipantes = qtdParticipantes;
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

    public String getCurso() {
        return curso;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }
}
