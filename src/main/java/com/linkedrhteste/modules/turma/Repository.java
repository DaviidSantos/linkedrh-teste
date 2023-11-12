package com.linkedrhteste.modules.turma;

import java.util.List;

public interface Repository {
    int insertTurma(InsertTurmaRequest request);
    int updateTurma(Integer code, UpdateTurmaRequest request);
    int deleteTurma(Integer code);
    List<TurmaResponse> listTurmasCurso(Integer cursoId);
    int addParticipante(Integer turmaId, Integer funcionarioId);
    int removeParticipante(Integer turmaId, Integer funcionarioId);
    List<ParticipanteResponse> listParticipantes(Integer turmaId);
}
