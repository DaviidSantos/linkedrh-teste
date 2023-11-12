package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.Repository;

public class RemoveParticipante {
    private final Repository repository;

    public RemoveParticipante(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer turmaId, Integer funcionarioId) {
        return this.repository.removeParticipante(turmaId, funcionarioId);
    }
}
