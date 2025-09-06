package TaskMasterDev.TaskMaster.infrastructure.beans;

import TaskMasterDev.TaskMaster.core.gateway.ColaboradorGateway;
import TaskMasterDev.TaskMaster.core.useCases.CriarColaboradorUseCase;
import TaskMasterDev.TaskMaster.core.useCases.CriarColaboradorUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beancofinguration {


    @Bean
    public CriarColaboradorUseCase criarColaborador(ColaboradorGateway colaboradorGateway){
        return new CriarColaboradorUseCaseImpl(colaboradorGateway);
    }


}
