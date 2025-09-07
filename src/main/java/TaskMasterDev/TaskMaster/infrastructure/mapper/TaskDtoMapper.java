package TaskMasterDev.TaskMaster.infrastructure.mapper;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDtoMapper {

    private final ColaboradorDtoMapper colaboradorDtoMapper;


    public TaskDtoMapper(@Lazy ColaboradorDtoMapper colaboradorDtoMapper) {
        this.colaboradorDtoMapper = colaboradorDtoMapper;
    }

    public TaskDto toDto(Task task){
        if (task == null) {
            return null;
        }

        Long colaboradorId = task.colaboradorTask() != null ?
                task.colaboradorTask().id() : null;

        return new TaskDto(
                task.id(),
                task.nomeTask(),
                task.descricao(),
                task.criticidade(),
                task.status(),
                task.dataCriado(),
                task.dataFechado(),
                colaboradorId
        );
    }

    public Task toEntity(TaskDto taskDto) {

        if (taskDto == null) {
            return null;
        }

        // Criar colaborador apenas com ID se fornecido
        Colaborador colaborador = null;
        if (taskDto.colaboradorId() != null) {
            colaborador = new Colaborador(
                    taskDto.colaboradorId(),
                    null, null, null, null, null
            );
        }

        return new Task(
                taskDto.id(),
                taskDto.nomeTask(),
                taskDto.descricao(),
                taskDto.criticidade(),
                taskDto.status(),
                taskDto.dataCriado(),
                taskDto.dataFechado(),
                colaborador
        );
    }
}
