package TaskMasterDev.TaskMaster.core.gateway;

import TaskMasterDev.TaskMaster.core.entities.Task;

import java.util.Optional;


public interface TaskGateway {

     Task criarTask(Task task);
     Optional<Task> findTaskId(Long id);
     Task alterarTask(Task task, Long id);


}
