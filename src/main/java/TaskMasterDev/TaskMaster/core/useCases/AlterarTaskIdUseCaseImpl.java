package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.gateway.TaskGateway;

public class AlterarTaskIdUseCaseImpl implements AlterarTaskIdUseCase{

    private final TaskGateway taskGateway;

    public AlterarTaskIdUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @Override
    public Task execute(Task task, Long id) {
        return taskGateway.alterarTask(task, id);
    }
}
