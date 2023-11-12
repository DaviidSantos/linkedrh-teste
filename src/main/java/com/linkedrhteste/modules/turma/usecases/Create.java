package com.linkedrhteste.modules.turma.usecases;


import com.linkedrhteste.modules.turma.InsertTurmaRequest;
import com.linkedrhteste.modules.turma.Repository;

public class Create {
    private final Repository repository;

    public Create(Repository repository) {
        this.repository = repository;
    }

    public int execute(InsertTurmaRequest request) {
        return this.repository.insertTurma(request);
    }
}
