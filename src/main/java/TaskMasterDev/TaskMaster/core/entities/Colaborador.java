package TaskMasterDev.TaskMaster.core.entities;

import TaskMasterDev.TaskMaster.core.enums.Cargo;

import java.time.LocalDateTime;
import java.util.List;

public record Colaborador (

        Long id,

        String nome,

        Cargo cargo,

        String matricula,

        LocalDateTime dataCriado,
        List<Task> task




){
}
