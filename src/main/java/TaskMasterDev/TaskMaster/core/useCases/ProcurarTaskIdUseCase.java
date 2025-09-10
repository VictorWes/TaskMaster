package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Task;

import java.util.Optional;

public interface ProcurarTaskIdUseCase {

    Optional<Task> execute(Long id);

}
