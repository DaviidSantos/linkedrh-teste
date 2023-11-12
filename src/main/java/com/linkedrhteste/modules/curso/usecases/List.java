package com.linkedrhteste.modules.curso.usecases;

import com.linkedrhteste.modules.curso.Repository;
import com.linkedrhteste.modules.curso.Request;
import com.linkedrhteste.modules.curso.Response;

public class List {
    private final Repository repository;

    public List(Repository repository) {
        this.repository = repository;
    }

    public java.util.List<Response> execute() {
        return this.repository.listCursos();
    }
}
