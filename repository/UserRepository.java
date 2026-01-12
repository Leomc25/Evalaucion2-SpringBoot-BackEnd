/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.cibertec.eva2.repository;

import pe.edu.cibertec.eva2.entity.userEntity;

public interface UserRepository {
    userEntity findByUsernameAndPassword(String username, String password);
}
