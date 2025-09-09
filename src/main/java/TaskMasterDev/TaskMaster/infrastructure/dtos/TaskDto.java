package TaskMasterDev.TaskMaster.infrastructure.dtos;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public record TaskDto(

        Long id,
        String nomeTask,
        String descricao,
        CriticidadeTask criticidade,
        StatusTask status,
        LocalDateTime dataCriado,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        LocalDateTime dataFechado,


        @JsonIgnore
        Long colaboradorId
) {
}
