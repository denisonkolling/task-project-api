package com.example.taskprojectapi.service;

import com.example.taskprojectapi.database.Database;
import com.example.taskprojectapi.model.StatusEnum;
import com.example.taskprojectapi.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    public List<Tarefa> listarTodas(StatusEnum status, String name) {

        List<Tarefa> tarefas = Database.listarTodasTarefas();

        if (status != null) {
            return tarefas.stream().filter(tarefa -> tarefa.getStatus().equals(status))
                    .collect(Collectors.toList());
        }

        if (name != null) {
            return tarefas.stream()
                    .filter(tarefa -> tarefa.getResponsavel().getNome().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }

        return tarefas;

    }

}

