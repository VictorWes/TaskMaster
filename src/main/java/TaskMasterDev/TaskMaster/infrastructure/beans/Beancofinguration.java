package TaskMasterDev.TaskMaster.infrastructure.beans;

import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;
import TaskMasterDev.TaskMaster.core.gateway.TaskGateway;
import TaskMasterDev.TaskMaster.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beancofinguration {


    @Bean
    public CriarColaboradorUseCase criarColaborador(ColaboradorGateway colaboradorGateway){
        return new CriarColaboradorUseCaseImpl(colaboradorGateway);
    }

    @Bean
    public CriarTaskUseCase criarTask(TaskGateway taskGateway){
        return new CriarTaskUseCaseImpl(taskGateway);
    }

    @Bean
    public ProcurarColaboradorIdUseCase findId(ColaboradorGateway colaboradorGateway){
        return new ProcurarColaboradorIdUseCaseImpl(colaboradorGateway);
    }


}
