package com.linkedrhteste.modules.turma;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/turmas")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    public void insertTurma(@RequestBody InsertTurmaRequest request) {
        this.service.insertTurma(request);
    }

    @PutMapping("{code}")
    public void updateTurma(@PathVariable("code") Integer code, @RequestBody UpdateTurmaRequest request) {
        this.service.updateTurma(code, request);
    }

    @DeleteMapping("{code}")
    public void deleteTurma(@PathVariable("code") Integer code) {
        this.service.deleteTurma(code);
    }

    @GetMapping("curso/{code}")
    public List<TurmaResponse> listTurmasCurso(@PathVariable("code") Integer code) {
        return this.service.listarTurmasCurso(code);
    }

    @PostMapping("{turmaId}/participante/{participanteId}")
    public void addParticipante(@PathVariable("turmaId") Integer turmaId, @PathVariable("participanteId") Integer participanteId) {
        this.service.addParticipante(turmaId, participanteId);
    }

    @DeleteMapping("{turmaId}/participante/{participanteId}")
    public void removeParticipante(@PathVariable("turmaId") Integer turmaId, @PathVariable("participanteId") Integer participanteId) {
        this.service.removeParticipante(turmaId, participanteId);
    }

    @GetMapping("{code}")
    public List<ParticipanteResponse> listParticipantes(@PathVariable("code") Integer code) {
        return this.service.listParticipantes(code);
    }
}
