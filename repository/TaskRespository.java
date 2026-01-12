/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.cibertec.eva2.repository;

import java.util.List;
import pe.edu.cibertec.eva2.entity.TaskEntity;


public interface TaskRespository {
    List<TaskEntity> findAll();
    void save(TaskEntity tarea);
    void update(TaskEntity tarea);
    TaskEntity findById(int id);
    
    //Plus, hecho por mi:
    void eliminar(int id);
}
