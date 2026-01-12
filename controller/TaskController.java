/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.eva2.entity.TaskEntity;
import pe.edu.cibertec.eva2.service.TaskService;
import java.util.List;

@Controller
 
@SessionAttributes("usuarioLogueado")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @ModelAttribute("nuevaTarea")
    public TaskEntity busqueda_Modelo_tarea(){
        return new TaskEntity();
    }
    
    //Método que nos permitirá el listado de tareas
    @GetMapping("/tasks/list")
    public String listTasks(Model model){
        List<TaskEntity> lista = taskService.listarTareas();
        model.addAttribute("listaTareas", lista);
        return "tasks";
    }
    
    //Método que nos permitirá la creación de tareas
    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute("nuevaTarea") TaskEntity task) {
        taskService.crearTarea(task);
        return "redirect:/tasks/list";
    }
    
    //Método que nos permitirá la actualización de tareas
    @PostMapping("/tasks/update")
public String updateTask(@ModelAttribute("nuevaTarea") TaskEntity task) {
    taskService.actualizarTarea(task);
    return "redirect:/tasks/list";
}
    
@GetMapping("/tasks/edit/{id}")
public String editTask(@PathVariable("id") int id, Model model) {
    // 1. Buscamos la tarea por su ID usando el servicio
    TaskEntity tareaExistente = taskService.buscarPorId(id);
    
    // 2. La ponemos en el modelo con el nombre "nuevaTarea" 
    // para que aparezca en el formulario del lado izquierdo
    model.addAttribute("nuevaTarea", tareaExistente);
    
    // 3. Recargamos la misma página de tareas
    return "tasks"; 
}
    

//Opcion personalizada para eliminar
@GetMapping("/tasks/delete/{id}")
public String deleteTask(@PathVariable("id") int id) {
    taskService.eliminarTarea(id);
    return "redirect:/tasks/list";
}
    
}
