package TaskMasterDev.TaskMaster.core.useCases;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;

public class CriarColaboradorUseCaseImpl implements CriarColaboradorUseCase{

    private final ColaboradorGateway colaboradorGateway;

    public CriarColaboradorUseCaseImpl(ColaboradorGateway colaboradorGateway) {
        this.colaboradorGateway = colaboradorGateway;
    }

    @Override
    public Colaborador execute(Colaborador colaborador) {
        return colaboradorGateway.criarColaborador(colaborador);
    }
}
