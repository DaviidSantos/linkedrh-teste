package com.linkedrhteste.modules.curso.usecases;

import com.linkedrhteste.modules.curso.Repository;
import com.linkedrhteste.modules.curso.Request;

public class Create {
    private final Repository repository;

    public Create(Repository repository) {
        this.repository = repository;
    }

    public int execute(Request request) {
        return this.repository.insertCurso(request);
    }
}
