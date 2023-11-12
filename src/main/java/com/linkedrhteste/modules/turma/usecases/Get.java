package com.linkedrhteste.modules.turma.usecases;

import com.linkedrhteste.modules.turma.Repository;
import com.linkedrhteste.modules.turma.TurmaResponse;

import java.util.Optional;

public class Get {
    private final Repository repository;

    public Get(Repository repository) {
        this.repository = repository;
    }

    public Optional<TurmaResponse> execute(Integer code) {
        return this.repository.getTurma(code);
    }
}
