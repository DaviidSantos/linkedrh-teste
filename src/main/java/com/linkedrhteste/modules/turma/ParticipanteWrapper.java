package com.linkedrhteste.modules.turma;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipanteWrapper implements RowMapper<ParticipanteResponse> {
    @Override
    public ParticipanteResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ParticipanteResponse(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("nascimento"),
                rs.getString("cargo"),
                rs.getDate("admissao"),
                rs.getInt("status")
        );
    }
}
