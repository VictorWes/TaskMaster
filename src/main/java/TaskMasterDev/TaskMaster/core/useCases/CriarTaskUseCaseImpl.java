package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.gateway.TaskGateway;

public class CriarTaskUseCaseImpl implements CriarTaskUseCase{

    private final TaskGateway taskGateway;

    public CriarTaskUseCaseImpl(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }
    @Override
    public Task execute(Task task) {
     return taskGateway.criarTask(task);
    }


}
