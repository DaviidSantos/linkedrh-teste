package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.InsertTurmaRequest;
import com.linkedrhteste.modules.turma.Repository;
import com.linkedrhteste.modules.turma.TurmaResponse;

import java.util.List;

public class ListTurmasCurso {
    private final Repository repository;

    public ListTurmasCurso(Repository repository) {
        this.repository = repository;
    }

    public List<TurmaResponse> execute(Integer cursoId) {
        return this.repository.listTurmasCurso(cursoId);
    }
}
