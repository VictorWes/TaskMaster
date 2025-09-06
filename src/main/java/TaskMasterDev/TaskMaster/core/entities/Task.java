package TaskMasterDev.TaskMaster.core.entities;

import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Task(

        Long id,

        String nomeTask,

        String descricao,

        CriticidadeTask criticidade,

        String colaborador,

        StatusTask status,

        LocalDateTime dataCriado,

        LocalDateTime dataFechado





){
}
