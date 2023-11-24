package com.example.taskprojectapi.controller;

import com.example.taskprojectapi.database.Database;
import com.example.taskprojectapi.model.Tarefa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {


    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa response = Database.adicionarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
