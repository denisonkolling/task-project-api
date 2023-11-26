package com.example.taskprojectapi.model;

public class Tarefa {

    private Integer id;
    private String descricao;
    private StatusEnum status;
    private PrioridadeEnum prioridade;
    private Responsavel responsavel;

    public Tarefa(Integer id, String descricao, StatusEnum status, PrioridadeEnum prioridade, Responsavel responsavel) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
