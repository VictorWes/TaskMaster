package TaskMasterDev.TaskMaster.infrastructure.mapper;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import TaskMasterDev.TaskMaster.infrastructure.persitence.TaskEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class TaskEntityMapper {

    private final ColaboradorEntityMapper colaboradorEntityMapper;

    public TaskEntityMapper(@Lazy ColaboradorEntityMapper colaboradorEntityMapper) {
        this.colaboradorEntityMapper = colaboradorEntityMapper;
    }

    public TaskEntity toEntity(Task task) {
        if (task == null) {
            return null;
        }

        TaskEntity entity = new TaskEntity();
        entity.setId(task.id());
        entity.setNomeTask(task.nomeTask());
        entity.setDescricao(task.descricao());
        entity.setCriticidade(task.criticidade());
        entity.setStatus(task.status());
        entity.setDataCriado(task.dataCriado());
        entity.setDataFechado(task.dataFechado());

        // Aqui é o ponto importante: apenas setar o id do colaborador
        if (task.colaboradorTask() != null && task.colaboradorTask().id() != null) {
            ColaboradorEntity colaboradorEntity = new ColaboradorEntity();
            colaboradorEntity.setId(task.colaboradorTask().id());
            entity.setColaboradorId(colaboradorEntity);
        }

        return entity;
    }

    public Task toDomain(TaskEntity taskEntity){

        if (taskEntity == null) {
            return null;
        }

        // Criar um colaborador mínimo apenas com ID para evitar dependência circular
        Colaborador colaborador = null;
        if (taskEntity.getColaboradorId() != null) {
            colaborador = new Colaborador(
                    taskEntity.getColaboradorId().getId(),
                    taskEntity.getColaboradorId().getNome(),
                    taskEntity.getColaboradorId().getCargo(),
                    taskEntity.getColaboradorId().getMatricula(),
                    taskEntity.getColaboradorId().getDataCriado(),
                    null // Não carregamos as tasks aqui para evitar loop infinito
            );
        }

        return new Task(
                taskEntity.getId(),
                taskEntity.getNomeTask(),
                taskEntity.getDescricao(),
                taskEntity.getCriticidade(),
                taskEntity.getStatus(),
                taskEntity.getDataCriado(),
                taskEntity.getDataFechado(),
                colaborador
        );
    }


}
