/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.repository;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.eva2.entity.TaskEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRespository{
    
    private List<TaskEntity> listaTareas = new ArrayList<>();
    private int idAutoIncrementable = 1;

    @Override
    public List<TaskEntity> findAll() {
         return listaTareas;
    }

    @Override
    public void save(TaskEntity tarea) {
        tarea.setId(idAutoIncrementable++);
        listaTareas.add(tarea);
    }

    @Override
    public void update(TaskEntity tarea) {
         for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == tarea.getId()) {
                listaTareas.set(i, tarea);
                break;
            }
        }
    }

    @Override
    public TaskEntity findById(int id) {
       for (TaskEntity tarea : listaTareas) {
        if (tarea.getId() == id) {
            return tarea; // Retorna la tarea si la encuentra
        }
    }
    return null;
    }

    @Override
    public void eliminar(int id) {
        listaTareas.removeIf(t -> t.getId() == id);
    }
    
}
