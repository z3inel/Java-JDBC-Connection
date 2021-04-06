/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot3.springboot3.Controller;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import springboot3.springboot3.Controller.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
 
    
    
}