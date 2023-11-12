package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.ParticipanteResponse;
import com.linkedrhteste.modules.turma.Repository;

import java.util.List;

public class ListParticipantes {
    private final Repository repository;

    public ListParticipantes(Repository repository) {
        this.repository = repository;
    }

    public List<ParticipanteResponse> execute(Integer turmaId) {
        return this.repository.listParticipantes(turmaId);
    }
}
