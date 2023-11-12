package com.linkedrhteste.modules.turma;

import java.util.Date;

public class UpdateTurmaRequest {
    private Date inicio;
    private Date fim;
    private String local;

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
}
