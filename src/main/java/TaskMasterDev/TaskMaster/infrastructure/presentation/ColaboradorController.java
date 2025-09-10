package TaskMasterDev.TaskMaster.infrastructure.presentation;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.useCases.CriarColaboradorUseCase;
import TaskMasterDev.TaskMaster.core.useCases.ProcurarColaboradorIdUseCase;
import TaskMasterDev.TaskMaster.infrastructure.dtos.ColaboradorDto;
import TaskMasterDev.TaskMaster.infrastructure.mapper.ColaboradorDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("colaborador/")
public class ColaboradorController {


   private final CriarColaboradorUseCase criarColaboradorUseCase;
   private final ColaboradorDtoMapper colaboradorDtoMapper;
   private final ProcurarColaboradorIdUseCase procurarColaboradorIdUseCase;


    public ColaboradorController(CriarColaboradorUseCase criarColaboradorUseCase, ColaboradorDtoMapper colaboradorDtoMapper, ProcurarColaboradorIdUseCase procurarColaboradorIdUseCase) {
        this.criarColaboradorUseCase = criarColaboradorUseCase;
        this.colaboradorDtoMapper = colaboradorDtoMapper;
        this.procurarColaboradorIdUseCase = procurarColaboradorIdUseCase;
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarColaborador(@RequestBody ColaboradorDto colaborador){

        Colaborador novoColaborador = criarColaboradorUseCase.execute(
                colaboradorDtoMapper.toEntity(colaborador));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Colaborador cadastrado com sucesso");
        response.put("colaborador", colaboradorDtoMapper.toDto(novoColaborador));

        return ResponseEntity.ok(response);

    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> buscarColaborador(@PathVariable Long id) {
        Optional<Colaborador> colaborador = procurarColaboradorIdUseCase.execute(id);

        if (colaborador.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Colaborador localizado com sucesso");
            response.put("colaborador", colaboradorDtoMapper.toDto(colaborador.get()));
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }
}
