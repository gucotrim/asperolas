package com.asperolas.asperolas.controller;

import com.asperolas.asperolas.dto.JoiaDto;
import com.asperolas.asperolas.model.JoiaEntity;
import com.asperolas.asperolas.service.JoiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class JoiaController {

    private final JoiaService joiaService;

    public JoiaController(JoiaService joiaService) {
        this.joiaService = joiaService;
    }

    @PostMapping("/joia/inserir")
    public ResponseEntity<JoiaEntity> save(@RequestBody JoiaDto joiaDto) {
        return new ResponseEntity<>(joiaService.save(joiaDto), HttpStatus.CREATED);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<JoiaEntity>> findAll() {
        return ResponseEntity.ok(joiaService.findAll());
    }

    @GetMapping("/joia/buscar-por-id/{id}")
    public ResponseEntity<JoiaEntity> findById(@PathVariable Long id) {
        return joiaService.findById(id)
                .map(joia -> ResponseEntity.ok().body(joia))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<?> delete(@RequestParam("numero-identificacao") Long id) {
        return joiaService.findById(id)
                .map(joia -> {
                    joiaService.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/joia/atualizar")
    public ResponseEntity<JoiaEntity> update(@RequestParam("numero-identificacao") Long id, @RequestBody JoiaDto joiaDto) {
        return joiaService.findById(id)
                .map(joia -> ResponseEntity.ok(joiaService.update(joiaDto, id)))
                .orElse(ResponseEntity.notFound().build());
    }
}
