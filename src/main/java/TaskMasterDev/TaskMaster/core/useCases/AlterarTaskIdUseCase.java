package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Task;

public interface AlterarTaskIdUseCase {

    Task execute(Task task, Long id);

}
