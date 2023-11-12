package com.linkedrhteste.modules.curso.usecases;

import com.linkedrhteste.modules.curso.Repository;
import com.linkedrhteste.modules.curso.Request;

public class Update {
    private final Repository repository;

    public Update(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer code, Request request) {
        return this.repository.updateCurso(code, request);
    }
}
