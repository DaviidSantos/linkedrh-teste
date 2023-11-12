package com.linkedrhteste.modules.turma;

import java.util.Date;

public class Request {
    private Date inicio;
    private Date fim;
    private String local;
    private Integer cursoId;

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

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer curso_id) {
        this.cursoId = curso_id;
    }
}
