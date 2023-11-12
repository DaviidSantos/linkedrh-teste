package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.Repository;

public class AddParticipante {
    private final Repository repository;

    public AddParticipante(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer turmaId, Integer funcionarioId) {
        return this.repository.addParticipante(turmaId, funcionarioId);
    }
}
