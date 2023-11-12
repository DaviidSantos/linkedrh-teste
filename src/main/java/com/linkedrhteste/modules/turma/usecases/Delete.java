package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.InsertTurmaRequest;
import com.linkedrhteste.modules.turma.Repository;

public class Delete {
    private final Repository repository;

    public Delete(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer code) {
        return this.repository.deleteTurma(code);
    }
}
