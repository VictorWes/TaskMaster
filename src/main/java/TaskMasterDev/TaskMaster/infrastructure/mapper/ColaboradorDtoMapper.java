package TaskMasterDev.TaskMaster.infrastructure.mapper;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.infrastructure.dtos.ColaboradorDto;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorDtoMapper {


    public ColaboradorDto toDto(Colaborador colaborador){

        return new ColaboradorDto(
                colaborador.id(),
                colaborador.nome(),
                colaborador.cargo(),
                colaborador.matricula(),
                colaborador.dataCriado());
    }

    public Colaborador toEntity(ColaboradorDto colaboradorDto){

        return new Colaborador(

                colaboradorDto.id(),
                colaboradorDto.nome(),
                colaboradorDto.cargo(),
                colaboradorDto.matricula(),
                colaboradorDto.dataCriado());

    }



}
