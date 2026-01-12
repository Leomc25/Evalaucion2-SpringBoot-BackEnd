/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogginAspect {
    @AfterReturning("execution(* pe.edu.cibertec.eva2.service.TaskService.crearTarea(..)) || " +
                    "execution(* pe.edu.cibertec.eva2.service.TaskService.actualizarTarea(..))")
    public void registro_de_actividades(JoinPoint joinPoint){
        String metodo = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        System.out.println("\t\t====== ASPECT LOGGING ======");
        System.out.println("\t\tActividad detectada: " + metodo);
        System.out.println("\t\tDetalle: Se procesó una tarea en el sistema.");
        System.out.println("\t\t=============================");
        
    }
    
}
