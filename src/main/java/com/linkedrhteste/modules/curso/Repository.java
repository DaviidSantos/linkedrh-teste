package com.linkedrhteste.modules.curso;

import java.util.List;

public interface Repository {
    int insertCurso(Request request);
    int updateCurso(Integer code, Request request);
    int deleteCurso(Integer code);
    List<Response> listCursos();
}
