package com.linkedrhteste.modules.curso;

import com.linkedrhteste.modules.curso.errors.InternalErrorException;
import com.linkedrhteste.modules.curso.errors.NotFoundException;
import com.linkedrhteste.modules.curso.errors.RequiredFieldException;
import com.linkedrhteste.modules.curso.usecases.*;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void insertCurso(Request request) {
        validateFieldRequest("Nome", request.getNome());
        validateFieldRequest("Descrição", request.getDescricao());
        validateFieldRequest("Duração", request.getDuracao());

        Create create  = new Create(repository);
        int result = create.execute(request);

        if (result != 1) {
            throw new InternalErrorException("Erro ao inserir curso na base de dados!");
        }
    }

    public void updateCurso(Integer code, Request request) {
        Get get = new Get(repository);
        Update update = new Update(repository);

        Optional<Response> curso = get.execute(code);

        if(curso.isEmpty()) {
            throw new NotFoundException("Curso não encontrado!");
        }

        if(request.getNome() == null || request.getNome().isEmpty()) {
            request.setNome(curso.get().getNome());
        }

        if(request.getDescricao() == null || request.getDescricao().isEmpty()) {
            request.setDescricao(curso.get().getDescricao());
        }

        if(request.getDuracao() == null) {
            request.setDuracao(curso.get().getDuracao());
        }

        int result = update.execute(code, request);

        if(result != 1) {
            throw new InternalErrorException("Erro ao atualizar curso na base de dados!");
        }
    }

    public void deleteCurso(Integer code) {
        Get get = new Get(repository);
        Delete delete = new Delete(repository);

        Optional<Response> curso = get.execute(code);

        if(curso.isEmpty()) {
            throw new NotFoundException("Curso não encontrado!");
        }

        int result = delete.execute(code);

        if(result != 1) {
            throw new InternalErrorException("Erro ao excluir curso da base de dados!");
        }
    }

    public java.util.List<Response> listCursos() {
        List list = new List(repository);

        return list.execute();
    }

    private static void validateFieldRequest(String field, String value) {
        if(value == null || value.isEmpty()) {
            throw new RequiredFieldException("O campo " + field + " é obrigatório!");
        }
    }

    private static void validateFieldRequest(String field, Integer value) {
        if(value == null) {
            throw new RequiredFieldException("O campo " + field + " é obrigatório!");
        }
    }
}
