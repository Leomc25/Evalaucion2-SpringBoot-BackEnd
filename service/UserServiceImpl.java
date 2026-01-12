/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.eva2.entity.userEntity;
import pe.edu.cibertec.eva2.repository.UserRepository;

import pe.edu.cibertec.eva2.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public userEntity validarLogin(String username, String password) {
         return userRepository.findByUsernameAndPassword(username, password);
    }
    
    
    
}
