package com.example.taskprojectapi.database;

import com.example.taskprojectapi.model.Responsavel;
import com.example.taskprojectapi.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Database {

    private static Integer nextId = 0;

    private static List<Tarefa> tarefas = new ArrayList<>();

    public static Tarefa adicionarTarefa(Tarefa tarefa) {
        Integer idTarefa = setId();
        tarefa.setId(idTarefa);
        Database.tarefas.add(tarefa);
        return tarefa;
    }

    public static void removerTarefa(Integer id) {
        Database.tarefas.removeIf(task -> task.getId().equals(id));
    }

    public static List<Tarefa> listarTodasTarefas() {
        return Database.tarefas;
    }

    public static Tarefa consultar(Integer id) {
        return Database.tarefas.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("A tarefa não foi encontrada"));
    }

    public static Integer setId() {
        Database.nextId = Database.nextId + 1;
        return Database.nextId;
    }



}
