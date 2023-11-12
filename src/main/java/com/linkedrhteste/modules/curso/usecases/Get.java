package com.linkedrhteste.modules.curso.usecases;

import com.linkedrhteste.modules.curso.Repository;
import com.linkedrhteste.modules.curso.Response;

import java.util.Optional;

public class Get {
    private final Repository repository;

    public Get(Repository repository) {
        this.repository = repository;
    }

    public Optional<Response> execute(Integer code) {
        return this.repository.getCurso(code);
    }
}
