package com.linkedrhteste.modules.curso;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wrapper implements RowMapper<Response> {

    @Override
    public Response mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Response(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getInt("duracao")
        );
    }
}
