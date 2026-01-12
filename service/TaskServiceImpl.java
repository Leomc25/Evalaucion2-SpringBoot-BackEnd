/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.eva2.entity.TaskEntity;
import pe.edu.cibertec.eva2.repository.TaskRespository;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRespository taskRepository; //Permite llamar a la implementación 

    @Override
    public List<TaskEntity> listarTareas() {
         return taskRepository.findAll();
    }

    @Override
    public void crearTarea(TaskEntity tarea) {
         taskRepository.save(tarea);
    }

    @Override
    public void actualizarTarea(TaskEntity tarea) {
         taskRepository.update(tarea);
    }

    @Override
    public TaskEntity buscarPorId(int id) {
         return taskRepository.findById(id);
    }
    
    @Override
public void eliminarTarea(int id) {
    taskRepository.eliminar(id);
}

}
