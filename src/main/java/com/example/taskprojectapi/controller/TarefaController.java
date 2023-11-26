package com.example.taskprojectapi.controller;

import com.example.taskprojectapi.database.Database;
import com.example.taskprojectapi.model.Tarefa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {


    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa response = Database.adicionarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity <List<Tarefa>> listarTarefas() {
        List<Tarefa> response = Database.listarTodasTarefas();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
