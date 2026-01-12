/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.cibertec.eva2.entity.userEntity;
import pe.edu.cibertec.eva2.service.UserService;


@Controller
@SessionAttributes("usuarioLogueado")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index() {
        
        return "redirect:/login";// Redirige al método al login de forma directa
    }
    
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        Model model) {
        
        userEntity usuario = userService.validarLogin(username, password);
        
        if (usuario != null) {
            // Se guarda en sesión gracias a @SessionAttributes
            model.addAttribute("usuarioLogueado", usuario);
            return "redirect:/tasks/list";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete(); // Limpia los @SessionAttributes
        return "redirect:/login";
    }
    
}
