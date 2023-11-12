package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.InsertTurmaRequest;
import com.linkedrhteste.modules.turma.Repository;
import com.linkedrhteste.modules.turma.UpdateTurmaRequest;

public class Update {
    private final Repository repository;

    public Update(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer code, UpdateTurmaRequest request) {
        return this.repository.updateTurma(code, request);
    }
}
