package TaskMasterDev.TaskMaster.infrastructure.mapper;


import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorEntityMapper {

    public ColaboradorEntity toEntity(Colaborador colaborador){


        return new ColaboradorEntity(

                colaborador.id(),
                colaborador.nome(),
                colaborador.cargo(),
                colaborador.matricula(),
                colaborador.dataCriado());

    }

    public Colaborador toDomain(ColaboradorEntity colaboradorEntity){


        return new Colaborador(

                colaboradorEntity.getId(),
                colaboradorEntity.getNome(),
                colaboradorEntity.getCargo(),
                colaboradorEntity.getMatricula(),
                colaboradorEntity.getDataCriado());

    }


}
