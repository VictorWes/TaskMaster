package TaskMasterDev.TaskMaster.infrastructure.gateway;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;
import TaskMasterDev.TaskMaster.infrastructure.mapper.ColaboradorEntityMapper;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;


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
        Colaborador colaboradorComData = new Colaborador(
                colaborador.id(),
                colaborador.nome(),
                colaborador.cargo(),
                colaborador.matricula(),
                LocalDateTime.now(),
                colaborador.task()
        );

        ColaboradorEntity entity = colaboradorEntityMapper.toEntity(colaboradorComData);
        ColaboradorEntity savedEntity = colaboradorRepository.save(entity);
        return colaboradorEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Colaborador> findIdColaborador(Long id) {
        Optional<ColaboradorEntity> entity = colaboradorRepository.findById(id);
        return entity.map(colaboradorEntityMapper::toDomain);
    }


}
