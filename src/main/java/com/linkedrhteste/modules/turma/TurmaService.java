package com.linkedrhteste.modules.turma;

import com.linkedrhteste.modules.curso.errors.InternalErrorException;
import com.linkedrhteste.modules.curso.errors.NotFoundException;
import com.linkedrhteste.modules.curso.errors.RequiredFieldException;
import com.linkedrhteste.modules.turma.usecases.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TurmaService {
    private final Repository repository;

    public TurmaService(Repository repository) {
        this.repository = repository;
    }

    public void insertTurma(InsertTurmaRequest request) {
        validateFieldRequest("inicio", request.getInicio());
        validateFieldRequest("fim", request.getFim());
        validateFieldRequest("local", request.getLocal());
        validateFieldRequest("curso", request.getCursoId());
        Create create = new Create(repository);

        int result = create.execute(request);

        if(result != 1) {
            throw new InternalErrorException("Erro ao inserir turma na base de dados!");
        }
    }

    public void updateTurma(Integer code, UpdateTurmaRequest request) {
        Get get = new Get(repository);
        Update update = new Update(repository);

        Optional<TurmaResponse> turma = get.execute(code);

        if(turma.isEmpty()) {
            throw new NotFoundException("Turma não encontrada!");
        }

        if(request.getInicio() == null) {
            request.setInicio(turma.get().getInicio());
        }

        if(request.getFim() == null) {
            request.setFim(turma.get().getFim());
        }

        if (request.getLocal() == null || request.getLocal().isEmpty()) {
            request.setLocal(turma.get().getLocal());
        }

        int result = update.execute(code, request);

        if(result != 1) {
            throw new InternalErrorException("Erro ao atualizar turma na base de dados!");
        }
    }

    public void deleteTurma(Integer code) {
        Get get = new Get(repository);
        Delete delete = new Delete(repository);

        Optional<TurmaResponse> turma = get.execute(code);

        if(turma.isEmpty()) {
            throw new NotFoundException("Turma não encontrada!");
        }

        int result = delete.execute(code);

        if(result != 1) {
            throw new InternalErrorException("Erro ao excluir turma da base de dados!");
        }
    }

    public List<TurmaResponse> listarTurmasCurso(Integer code) {
        ListTurmasCurso list = new ListTurmasCurso(repository);

        return list.execute(code);
    }

    public void addParticipante(Integer turmaId, Integer funcionarioId) {
        AddParticipante add = new AddParticipante(repository);
        Get get = new Get(repository);

        Optional<TurmaResponse> turma = get.execute(turmaId);

        if(turma.isEmpty()) {
            throw new NotFoundException("Turma não encontrada!");
        }

        int result = add.execute(turmaId, funcionarioId);

        if(result != 1) {
            throw new InternalErrorException("Erro ao inserir participante da turma!");
        }
    }

    public void removeParticipante(Integer turmaId, Integer funcionarioId) {
        RemoveParticipante remove = new RemoveParticipante(repository);
        Get get = new Get(repository);

        Optional<TurmaResponse> turma = get.execute(turmaId);

        if(turma.isEmpty()) {
            throw new NotFoundException("Turma não encontrada!");
        }

        int result = remove.execute(turmaId, funcionarioId);

        if(result != 1) {
            throw new InternalErrorException("Erro ao remover participante da turma!");
        }
    }

    public List<ParticipanteResponse> listParticipantes(Integer code) {
        Get get = new Get(repository);
        ListParticipantes list = new ListParticipantes(repository);

        Optional<TurmaResponse> turma = get.execute(code);

        if(turma.isEmpty()) {
            throw new NotFoundException("Turma não encontrada!");
        }

        return list.execute(code);
    }

    private static void validateFieldRequest(String field, String value) {
        if(value == null || value.isEmpty()) {
            throw new RequiredFieldException("O campo " + field + " é obrigatório!");
        }
    }

    private static void validateFieldRequest(String field, Date value) {
        if(value == null) {
            throw new RequiredFieldException("O campo " + field + " é obrigatório!");
        }
    }

    private static void validateFieldRequest(String field, Integer value) {
        if(value == null) {
            throw new RequiredFieldException("O campo " + field + " é obrigatório!");
        }
    }
}
