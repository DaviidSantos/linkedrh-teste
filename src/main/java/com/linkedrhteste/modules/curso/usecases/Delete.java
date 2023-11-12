package com.linkedrhteste.modules.curso.usecases;

import com.linkedrhteste.modules.curso.Repository;

public class Delete {
    private final Repository repository;

    public Delete(Repository repository) {
        this.repository = repository;
    }

    public int execute(Integer code) {
        return this.repository.deleteCurso(code);
    }
}
