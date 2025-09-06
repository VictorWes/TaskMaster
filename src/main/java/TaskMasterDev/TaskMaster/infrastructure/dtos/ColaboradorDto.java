package TaskMasterDev.TaskMaster.infrastructure.dtos;

import TaskMasterDev.TaskMaster.core.enums.Cargo;

import java.time.LocalDateTime;

public record ColaboradorDto(

        Long id,

        String nome,

        Cargo cargo,

        String matricula,

        LocalDateTime dataCriado



) {
}
