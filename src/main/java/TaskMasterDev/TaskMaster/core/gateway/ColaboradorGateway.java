package TaskMasterDev.TaskMaster.core.gateway;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;

import java.util.Optional;

public interface ColaboradorGateway {

  Colaborador criarColaborador(Colaborador colaborador);
  Optional<Colaborador> findIdColaborador(Long id);
}
