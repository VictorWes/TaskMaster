package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.gateway.TaskGateway;

import java.util.Optional;

public class ProcurarTaskIdUseCaseImpl implements ProcurarTaskIdUseCase {


    private final TaskGateway taskGateway;

    public ProcurarTaskIdUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public Optional<Task> execute(Long id) {
        return taskGateway.findTaskId(id);
    }
}
