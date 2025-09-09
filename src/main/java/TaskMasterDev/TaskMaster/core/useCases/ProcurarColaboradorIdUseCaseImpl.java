package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;

import java.util.Optional;

public class ProcurarColaboradorIdUseCaseImpl implements ProcurarColaboradorIdUseCase {

    private final ColaboradorGateway colaboradorGateway;

    public ProcurarColaboradorIdUseCaseImpl(ColaboradorGateway colaboradorGateway) {
        this.colaboradorGateway = colaboradorGateway;
    }

    @Override
    public Optional<Colaborador> execute(Long id) {
        return colaboradorGateway.findIdColaborador(id);
    }
}
