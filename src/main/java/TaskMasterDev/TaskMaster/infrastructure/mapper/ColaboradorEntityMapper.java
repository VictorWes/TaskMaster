package TaskMasterDev.TaskMaster.infrastructure.mapper;


import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ColaboradorEntityMapper {

    private final TaskEntityMapper taskEntityMapper;


    public ColaboradorEntityMapper(TaskEntityMapper taskEntityMapper) {
        this.taskEntityMapper = taskEntityMapper;
    }

    public ColaboradorEntity toEntity(Colaborador colaborador){

        if (colaborador == null) {
            return null;
        }

        ColaboradorEntity entity = new ColaboradorEntity(
                colaborador.id(),
                colaborador.nome(),
                colaborador.cargo(),
                colaborador.matricula(),
                colaborador.dataCriado()
        );

        return entity;
    }

    public Colaborador toDomain(ColaboradorEntity colaboradorEntity) {

        if (colaboradorEntity == null) {
            return null;
        }


        List<Task> tasks = null;
        if (colaboradorEntity.getTasks() != null && !colaboradorEntity.getTasks().isEmpty()) {
            tasks = colaboradorEntity.getTasks().stream()
                    .map(taskEntity -> new Task(
                            taskEntity.getId(),
                            taskEntity.getNomeTask(),
                            taskEntity.getDescricao(),
                            taskEntity.getCriticidade(),
                            taskEntity.getStatus(),
                            taskEntity.getDataCriado(),
                            taskEntity.getDataFechado(),
                            null // Não incluímos o colaborador na task para evitar referência circular
                    ))
                    .collect(Collectors.toList());
        }

        return new Colaborador(
                colaboradorEntity.getId(),
                colaboradorEntity.getNome(),
                colaboradorEntity.getCargo(),
                colaboradorEntity.getMatricula(),
                colaboradorEntity.getDataCriado(),
                tasks
        );
    }
}
