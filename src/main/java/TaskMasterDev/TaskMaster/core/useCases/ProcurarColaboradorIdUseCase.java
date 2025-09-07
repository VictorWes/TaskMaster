package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;


import java.util.Optional;

public interface ProcurarColaboradorIdUseCase {

    Optional<Colaborador> execute(Long id);

}
