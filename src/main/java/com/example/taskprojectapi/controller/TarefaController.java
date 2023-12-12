package com.example.taskprojectapi.controller;

import com.example.taskprojectapi.database.Database;
import com.example.taskprojectapi.model.StatusEnum;
import com.example.taskprojectapi.model.Tarefa;
import com.example.taskprojectapi.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa response = Database.adicionarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity <List<Tarefa>> listarTarefas(@RequestParam(name = "status", required = false) StatusEnum status, @RequestParam(name = "responsavel", required = false) String responsavel) {
        List<Tarefa> response = this.tarefaService.listarTodas(status, responsavel);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
