package TaskMasterDev.TaskMaster.infrastructure.gateway;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;
import TaskMasterDev.TaskMaster.infrastructure.mapper.ColaboradorEntityMapper;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorRepository;
import org.springframework.stereotype.Component;


@Component
public class ColaboradorRepositoryGateway implements ColaboradorGateway {

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorEntityMapper colaboradorEntityMapper;


    public ColaboradorRepositoryGateway(ColaboradorRepository colaboradorRepository, ColaboradorEntityMapper colaboradorEntityMapper) {
        this.colaboradorRepository = colaboradorRepository;
        this.colaboradorEntityMapper = colaboradorEntityMapper;
    }

    @Override
    public Colaborador criarColaborador(Colaborador colaborador) {
        ColaboradorEntity entity = colaboradorEntityMapper.toEntity(colaborador);
        ColaboradorEntity novoColaborador = colaboradorRepository.save(entity);
        return colaboradorEntityMapper.toDomain(novoColaborador);
    }
}
