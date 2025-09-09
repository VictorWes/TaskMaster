package TaskMasterDev.TaskMaster.infrastructure.dtos;

import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;

public record TaskCreateRequest(
        String nomeTask,
        String descricao,
        CriticidadeTask criticidade,
        StatusTask status,

        Long colaboradorId

) { }
