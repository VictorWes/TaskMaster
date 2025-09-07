package TaskMasterDev.TaskMaster.infrastructure.dtos;

import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public record TaskCreateRequest(
        String nomeTask,
        String descricao,
        CriticidadeTask criticidade,
        StatusTask status,

        Long colaboradorId

) { }
