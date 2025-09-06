package TaskMasterDev.TaskMaster.infrastructure.persitence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
