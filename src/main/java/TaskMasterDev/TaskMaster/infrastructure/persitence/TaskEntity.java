package TaskMasterDev.TaskMaster.infrastructure.persitence;


import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")

public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTask;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private CriticidadeTask criticidade;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    private LocalDateTime dataCriado;

    private LocalDateTime dataFechado;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ColaboradorEntity colaboradorId;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String nomeTask, String descricao, CriticidadeTask criticidade, StatusTask status, LocalDateTime dataCriado, LocalDateTime dataFechado) {
        this.id = id;
        this.nomeTask = nomeTask;
        this.descricao = descricao;
        this.criticidade = criticidade;
        this.status = status;
        this.dataCriado = dataCriado;
        this.dataFechado = dataFechado;
    }

    public TaskEntity(Long id, String nomeTask, String descricao, CriticidadeTask criticidade, StatusTask status, LocalDateTime dataCriado, LocalDateTime dataFechado, ColaboradorEntity colaboradorId) {
        this.id = id;
        this.nomeTask = nomeTask;
        this.descricao = descricao;
        this.criticidade = criticidade;
        this.status = status;
        this.dataCriado = dataCriado;
        this.dataFechado = dataFechado;
        this.colaboradorId = colaboradorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTask() {
        return nomeTask;
    }

    public void setNomeTask(String nomeTask) {
        this.nomeTask = nomeTask;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CriticidadeTask getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(CriticidadeTask criticidade) {
        this.criticidade = criticidade;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(LocalDateTime dataCriado) {
        this.dataCriado = dataCriado;
    }

    public LocalDateTime getDataFechado() {
        return dataFechado;
    }

    public void setDataFechado(LocalDateTime dataFechado) {
        this.dataFechado = dataFechado;
    }

    public ColaboradorEntity getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(ColaboradorEntity colaboradorId) {
        this.colaboradorId = colaboradorId;
    }
}
