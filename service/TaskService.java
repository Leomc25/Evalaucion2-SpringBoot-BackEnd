 
package pe.edu.cibertec.eva2.service;

import java.util.List;
import pe.edu.cibertec.eva2.entity.TaskEntity;

 
public interface TaskService {
    List<TaskEntity> listarTareas();
    void crearTarea(TaskEntity tarea);
    void actualizarTarea(TaskEntity tarea);
    
    TaskEntity buscarPorId(int id);
    void eliminarTarea(int id);
    
}
