package com.linkedrhteste.modules.turma;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class JDBCRepository implements Repository{
    private final JdbcTemplate jdbc;

    public JDBCRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insertTurma(InsertTurmaRequest request) {
        String statement = """
                INSERT INTO turma(inicio, fim, local, curso)
                VALUES(?, ?, ?, ?);
                """;
        return jdbc.update(statement, request.getInicio(), request.getFim(), request.getLocal(), request.getCursoId());
    }

    @Override
    public int updateTurma(Integer code, UpdateTurmaRequest request) {
        String statement = """
                UPDATE turma
                SET inicio = ?, fim = ?, local = ?
                WHERE codigo = ?;
                """;
        return jdbc.update(statement, request.getInicio(), request.getFim(), request.getLocal(), code);
    }

    @Override
    public int deleteTurma(Integer code) {
        String statement = """
                DELETE FROM turma
                WHERE codigo = ?;
                """;
        return jdbc.update(statement, code);
    }

    @Override
    public List<TurmaResponse> listTurmasCurso(Integer cursoId) {
        String query = """
                SELECT t.codigo, t.inicio, t.fim, t.local, c.nome
                FROM turma t
                INNER JOIN curso c
                ON t.curso = c.codigo
                WHERE t.curso = ?;
                """;
        return jdbc.query(query, new TurmaWrapper(), cursoId);
    }

    @Override
    public int addParticipante(Integer turmaId, Integer funcionarioId) {
        String statement = """
                INSERT INTO turma_participante(turma, funcionario)
                VALUES(?, ?);
                """;
        return jdbc.update(statement, turmaId, funcionarioId);
    }

    @Override
    public int removeParticipante(Integer turmaId, Integer funcionarioId) {
        String statement = """
                DELETE FROM turma_participante
                WHERE turma = ? AND funcionario = ?;
                """;
        return jdbc.update(statement, turmaId, funcionarioId);
    }

    @Override
    public List<ParticipanteResponse> listParticipantes(Integer turmaId) {
        String query = """
                SELECT f.codigo, f.nome, f.cpf, f.nascimento,
                       f.cargo, f.admissao, f.status
                FROM turma_participante tp
                INNER JOIN funcionario f ON tp.funcionario = f.codigo
                WHERE tp.turma = ?;
                """;
        return jdbc.query(query, new ParticipanteWrapper(), turmaId);
    }
}
