package TaskMasterDev.TaskMaster.infrastructure.gateway;

import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.gateway.TaskGateway;
import TaskMasterDev.TaskMaster.infrastructure.mapper.TaskEntityMapper;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorRepository;
import TaskMasterDev.TaskMaster.infrastructure.persitence.TaskEntity;
import TaskMasterDev.TaskMaster.infrastructure.persitence.TaskRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TaskRepositoryGateway implements TaskGateway {

    private final TaskRepository taskRepository;
    private final TaskEntityMapper taskEntityMapper;
    private final ColaboradorRepository colaboradorRepository;

    public TaskRepositoryGateway(TaskRepository taskRepository, TaskEntityMapper taskEntityMapper, ColaboradorRepository colaboradorRepository) {
        this.taskRepository = taskRepository;
        this.taskEntityMapper = taskEntityMapper;
        this.colaboradorRepository = colaboradorRepository;
    }

    @Override
    public Task criarTask(Task task) {
        if (task.colaboradorTask() != null && task.colaboradorTask().id() != null) {
            Optional<ColaboradorEntity> colaborador = colaboradorRepository
                    .findById(task.colaboradorTask().id());

            if (colaborador.isEmpty()) {
                throw new RuntimeException("Colaborador não encontrado com ID: " +
                        task.colaboradorTask().id());
            }


            Task taskComData = new Task(
                    task.id(),
                    task.nomeTask(),
                    task.descricao(),
                    task.criticidade(),
                    task.status(),
                    LocalDateTime.now(),
                    task.dataFechado(),
                    task.colaboradorTask()
            );

            TaskEntity entity = taskEntityMapper.toEntity(taskComData);
            entity.setColaboradorId(colaborador.get());

            TaskEntity savedEntity = taskRepository.save(entity);
            return taskEntityMapper.toDomain(savedEntity);
        }

        throw new RuntimeException("ID do colaborador é obrigatório");
    }

    @Override
    public Optional<Task> findTaskId(Long id) {
        Optional<TaskEntity> idLocalizado = taskRepository.findById(id);
        return idLocalizado.map(taskEntityMapper::toDomain) ;
    }

    @Override
    public Task alterarTask(Task task, Long id) {
        Optional<TaskEntity> idLocalizado = taskRepository.findById(id);
        idLocalizado.map(taskEntityMapper::toDomain);

        if (task.colaboradorTask() != null && task.colaboradorTask().id() != null) {
            Optional<ColaboradorEntity> colaborador = colaboradorRepository
                    .findById(task.colaboradorTask().id());

            if (colaborador.isEmpty()) {
                throw new RuntimeException("Colaborador não encontrado com ID: " +
                        task.colaboradorTask().id());
            }


            Task taskComData = new Task(
                    task.id(),
                    task.nomeTask(),
                    task.descricao(),
                    task.criticidade(),
                    task.status(),
                    LocalDateTime.now(),
                    task.dataFechado(),
                    task.colaboradorTask()
            );

            TaskEntity entity = taskEntityMapper.toEntity(taskComData);
            entity.setColaboradorId(colaborador.get());

            TaskEntity savedEntity = taskRepository.save(entity);



    }


}
