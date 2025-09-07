package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;


import java.util.Optional;

public interface ProcurarTaskIdUseCase {

    Optional<Colaborador> execute(Long id);

}
