package TaskMasterDev.TaskMaster.infrastructure.mapper;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.infrastructure.dtos.ColaboradorDto;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ColaboradorDtoMapper {

    private final TaskDtoMapper taskDtoMapper;

    public ColaboradorDtoMapper(TaskDtoMapper taskDtoMapper) {
        this.taskDtoMapper = taskDtoMapper;
    }

    public ColaboradorDto toDto(Colaborador colaborador){

        if (colaborador == null) {
            return null;
        }

        List<TaskDto> taskDtos = null;
        if (colaborador.task() != null) {
            taskDtos = colaborador.task().stream()
                    .map(taskDtoMapper::toDto)
                    .collect(Collectors.toList());
        }

        return new ColaboradorDto(
                colaborador.id(),
                colaborador.nome(),
                colaborador.cargo(),
                colaborador.matricula(),
                colaborador.dataCriado(),
                taskDtos
        );
    }

    public Colaborador toEntity(ColaboradorDto colaboradorDto){

        if (colaboradorDto == null) {
            return null;
        }

        return new Colaborador(
                colaboradorDto.id(),
                colaboradorDto.nome(),
                colaboradorDto.cargo(),
                colaboradorDto.matricula(),
                colaboradorDto.dataCriado(),
                null // Não incluímos tasks na criação
        );
    }



}
