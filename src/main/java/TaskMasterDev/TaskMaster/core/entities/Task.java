package TaskMasterDev.TaskMaster.core.entities;

import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;

public record Task(

        Long id,

        String nomeTask,

        String descricao,

        CriticidadeTask criticidade,

        String colaborador




){
}
