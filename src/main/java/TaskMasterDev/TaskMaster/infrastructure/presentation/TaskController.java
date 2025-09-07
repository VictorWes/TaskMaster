package TaskMasterDev.TaskMaster.infrastructure.presentation;


import TaskMasterDev.TaskMaster.core.entities.Task;
import TaskMasterDev.TaskMaster.core.useCases.CriarTaskUseCase;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskCreateRequest;
import TaskMasterDev.TaskMaster.infrastructure.dtos.TaskDto;
import TaskMasterDev.TaskMaster.infrastructure.mapper.TaskDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("task/")
public class TaskController {

    private final CriarTaskUseCase criarTaskUseCase;
    private final TaskDtoMapper taskDtoMapper;

    public TaskController(CriarTaskUseCase criarTaskUseCase, TaskDtoMapper taskDtoMapper) {
        this.criarTaskUseCase = criarTaskUseCase;
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
}

