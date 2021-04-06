/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot3.springboot3.Controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String pass;
  
  private String description;
 
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public void removeId(Integer id) {
    this.id = id;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getDescription() {
  return description;
  }
    
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPass() {
    return pass;
  }

  public void setPassword(String pass) {
    this.pass = pass;
  }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", pass=" + pass + ", description=" + description + '}';
    }
  
  
}