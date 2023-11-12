package com.linkedrhteste.modules.curso;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cursos")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void insertCurso(@RequestBody Request request) {
        this.service.insertCurso(request);
    }

    @PutMapping("{code}")
    public void updateCurso(@PathVariable("code") Integer code, @RequestBody Request request) {
        this.service.updateCurso(code, request);
    }

    @DeleteMapping("{code}")
    public void deleteCurso(@PathVariable("code") Integer code) {
        this.service.deleteCurso(code);
    }

    @GetMapping
    public List<Response> listCursos() {
        return this.service.listCursos();
    }
}
