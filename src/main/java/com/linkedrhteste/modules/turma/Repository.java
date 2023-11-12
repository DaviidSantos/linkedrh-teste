package com.linkedrhteste.modules.turma;

import java.util.List;

public interface Repository {
    int insertTurma(InsertTurmaRequest request);
    int updateTurma(Integer code, UpdateTurmaRequest request);
    int deleteTurma(Integer code);
    List<TurmaResponse> listTurmasCurso(Integer curso_id);
    int addParticipante(Integer turma_id, Integer funcionario_id);
    int removeParticipante(Integer turma_id, Integer funcionario_id);
    List<ParticipanteResponse> listParticipantes(Integer turma_id);
}
