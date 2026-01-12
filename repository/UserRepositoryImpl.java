/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cibertec.eva2.repository;

import pe.edu.cibertec.eva2.entity.userEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leofr
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
private List<userEntity> usuarios = new ArrayList<>();
    public UserRepositoryImpl() {
        //usuarios.add(new userEntity(ID, "user", "email", "clave")); 
        usuarios.add(new userEntity(1, "admin", "admin.privilegiado@cibertec.edu", "Administrador"));// Usuario de prueba
    }
    
    @Override
    public userEntity findByUsernameAndPassword(String username, String password) {
       for (userEntity u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    
}
