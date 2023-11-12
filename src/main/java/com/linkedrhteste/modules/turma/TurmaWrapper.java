package com.linkedrhteste.modules.turma;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaWrapper implements RowMapper<TurmaResponse> {

    @Override
    public TurmaResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TurmaResponse(
                rs.getInt("codigo"),
                rs.getDate("inicio"),
                rs.getDate("fim"),
                rs.getString("local"),
                rs.getString("curso"),
                rs.getInt("qtdeParticipantes")
        );
    }
}
