package TaskMasterDev.TaskMaster.infrastructure.persitence;


import TaskMasterDev.TaskMaster.core.enums.CriticidadeTask;
import TaskMasterDev.TaskMaster.core.enums.StatusTask;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTask;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private CriticidadeTask criticidade;

    private String colaborador;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private ColaboradorEntity colaboradorEntity;

    private LocalDateTime dataCriado;

    private LocalDateTime dataFechado;

}
