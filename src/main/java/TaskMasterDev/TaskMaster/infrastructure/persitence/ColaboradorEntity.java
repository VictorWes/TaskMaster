package TaskMasterDev.TaskMaster.infrastructure.persitence;


import TaskMasterDev.TaskMaster.core.enums.Cargo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private String matricula;

    private LocalDateTime dataCriado;

    @OneToMany(mappedBy = "colaboradorId", fetch = FetchType.LAZY)
    List<TaskEntity> tasks = new ArrayList<>();


    public ColaboradorEntity(Long id, String nome, Cargo cargo, String matricula, LocalDateTime dataCriado) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
        this.dataCriado = dataCriado;
    }


}
