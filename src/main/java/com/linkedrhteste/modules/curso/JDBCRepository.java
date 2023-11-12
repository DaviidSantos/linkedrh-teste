package com.linkedrhteste.modules.curso;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class JDBCRepository implements Repository {
    private final JdbcTemplate jdbc;

    public JDBCRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insertCurso(Request request) {
        String statement = """
                INSERT INTO curso(nome, descricao, duracao)
                VALUES(?, ?, ?);
                """;
        return jdbc.update(statement, request.getNome(), request.getDescricao(), request.getDuracao());
    }

    @Override
    public int updateCurso(Integer code, Request request) {
        String statement = """
                UPDATE curso
                SET nome = ?, descricao = ?, duracao = ?
                WHERE codigo = ?;
                """;
        return jdbc.update(statement, request.getNome(), request.getDescricao(), request.getDuracao(), code);
    }

    @Override
    public int deleteCurso(Integer code) {
        String statement = """
               DELETE FROM curso
               WHERE codigo = ?;
                """;
        return jdbc.update(statement, code);
    }

    @Override
    public List<Response> listCursos() {
        String query = """
                SELECT * 
                FROM curso;
                """;
        return jdbc.query(query, new Wrapper());
    }

    public Optional<Response> getCurso(Integer code) {
        String query = """
                SELECT * 
                FROM curso
                WHERE codigo = ?;
                """;
        return jdbc.query(query, new Wrapper(), code)
                .stream()
                .findFirst();
    }
}
