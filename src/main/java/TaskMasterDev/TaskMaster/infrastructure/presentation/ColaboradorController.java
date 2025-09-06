package TaskMasterDev.TaskMaster.infrastructure.presentation;

import TaskMasterDev.TaskMaster.core.entities.Colaborador;
import TaskMasterDev.TaskMaster.core.useCases.CriarColaboradorUseCase;
import TaskMasterDev.TaskMaster.infrastructure.dtos.ColaboradorDto;
import TaskMasterDev.TaskMaster.infrastructure.mapper.ColaboradorDtoMapper;
import TaskMasterDev.TaskMaster.infrastructure.persitence.ColaboradorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("colaborador/")
public class ColaboradorController {


   private final CriarColaboradorUseCase criarColaboradorUseCase;
   private final ColaboradorDtoMapper colaboradorDtoMapper;


    public ColaboradorController(CriarColaboradorUseCase criarColaboradorUseCase, ColaboradorDtoMapper colaboradorDtoMapper) {
        this.criarColaboradorUseCase = criarColaboradorUseCase;
        this.colaboradorDtoMapper = colaboradorDtoMapper;
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarColaborador(@RequestBody ColaboradorDto colaborador){

        Colaborador novoColaborador = criarColaboradorUseCase.execute(colaboradorDtoMapper.toEntity(colaborador));

        Map<String, Object> response = new HashMap<>();

        response.put("Message: ", "Colaborador cadastrado com sucesso");
        response.put("Dados do colaborador:", colaboradorDtoMapper.toDto(novoColaborador));

        return ResponseEntity.ok(response);

    }
}
