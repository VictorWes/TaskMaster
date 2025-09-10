package TaskMasterDev.TaskMaster.infrastructure.presentation;


import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.useCases.CriarTaskUseCase;
import TaskMasterDev.TaskMaster.core.useCases.ProcurarTaskIdUseCase;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskCreateRequest;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskDto;
import TaskMasterDev.TaskMaster.infrastructure.mapper.TaskDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("task/")
public class TaskController {

    private final CriarTaskUseCase criarTaskUseCase;
    private final ProcurarTaskIdUseCase procurarTaskIdUseCase;
    private final TaskDtoMapper taskDtoMapper;

    public TaskController(CriarTaskUseCase criarTaskUseCase, ProcurarTaskIdUseCase procurarTaskIdUseCase, TaskDtoMapper taskDtoMapper) {
        this.criarTaskUseCase = criarTaskUseCase;
        this.procurarTaskIdUseCase = procurarTaskIdUseCase;
        this.taskDtoMapper = taskDtoMapper;
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarTask(@RequestBody TaskCreateRequest request) {

        TaskDto taskDto = new TaskDto(
                null, // ID será gerado
                request.nomeTask(),
                request.descricao(),
                request.criticidade(),
                request.status(),
                null, // Data será definida no gateway
                null,
                request.colaboradorId()
        );

        Task criarTask = criarTaskUseCase.execute(taskDtoMapper.toEntity(taskDto));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Task criada com sucesso");
        response.put("task", taskDtoMapper.toDto(criarTask));

        return ResponseEntity.ok(response);
    }


    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> findIdTask(@PathVariable Long id){

        Optional<Task> idTask = procurarTaskIdUseCase.execute(id);


        if (idTask.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Task localizada com sucesso");
            response.put("task", taskDtoMapper.toDto(idTask.get()));

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();

    }
}

