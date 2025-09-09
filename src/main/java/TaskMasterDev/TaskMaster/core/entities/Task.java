package TaskMasterDev.TaskMaster.core.entities;

import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;

import java.time.LocalDateTime;

public record Task(

        Long id,

        String nomeTask,

        String descricao,

        CriticidadeTask criticidade,

        StatusTask status,

        LocalDateTime dataCriado,

        LocalDateTime dataFechado,

        Colaborador colaboradorTask





){
}
