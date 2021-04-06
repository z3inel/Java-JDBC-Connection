package springboot3.springboot3.Controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerMap {
    @Autowired
        private UserRepository userRepository;
        public boolean isNowRegistered = false;
        
        /*
        DEPRECATED, BECAUSE OF NEW MAPPING
        */
	@GetMapping("/main")
	public String main(@RequestParam(required=false, defaultValue="none") String name, Model model) throws Exception {
               //DBConnection.register(name, name)
               // model.addAttribute("id", name);
		return "main"; //not using
        }
        
        @RequestMapping("/register")
	public String register(boolean registerStatus) throws Exception {
               //DBConnection.register(name, name)
               // model.addAttribute("id", name);
		return "register";
        }   
        
       @PostMapping(value = "/registration")
        public String registration(@RequestParam(name="user_name",required=true,defaultValue="") String login ,@RequestParam(name="password",required=true,defaultValue="") String password,@RequestParam(name="descrip",required=true,defaultValue="") String descrip) throws SQLException, ClassNotFoundException{
            System.out.println(login + password);

           try{
            User n = new User();
            n.setName(login);
            n.setPassword(password);
            n.setDescription(descrip);
            userRepository.save(n);
            isNowRegistered = true;
            return "success";
           }
           catch(Exception e){
               System.out.println("Exception occured in next traceback:");
               System.out.println(e);
              System.out.println("Short description: Failed to register user N");
              return "failed";
          }
           
         }
    
   	@RequestMapping("/")
	public String users(Model model) throws Exception {//users
        model.addAttribute("users", userRepository.findAll()); //all users add
	return "home";       
        }
        
        @GetMapping("/users/{id}")
	public String userprofile(@PathVariable("id") int id,Model model) throws Exception {//users
        model.addAttribute("users", userRepository.findById(id).get()); //all users add
	return "dev";       
        }
            
 
        //@PatchMapping("/users/{id}")
        @PatchMapping("/users/{id}")
        public String update(Model model,@ModelAttribute("user") User user,  @PathVariable("id") int id){
        User n = new User();
        n.setId(id);
        n.setName(user.getName());
        n.setDescription(user.getDescription());
        System.out.println(user.toString());
        
        userRepository.save(n);
         return "redirect:/";
        }
       
        @DeleteMapping("/users/{id}")
        public String delete(Model model,@ModelAttribute("user") User user,  @PathVariable("id") int id){
        User n = new User();
        n.setId(id);
        n.setName(user.getName());
        n.setDescription(user.getDescription());
        System.out.println("Removed:" + user.toString());
        userRepository.delete(n);
        return "redirect:/";
        }
        
             
        /*
        NOT SUPPORTED YET
        */
	@RequestMapping("/login")
	public String login() throws Exception {
	return "login";       
        }
        
        
        /*
        NOT SUPPORTED YET
        */
        @GetMapping("/auth")
	public String auth(@RequestParam(name="user_name",required=true,defaultValue="") String login ,@RequestParam(name="password",required=true,defaultValue="") String password) throws SQLException, ClassNotFoundException{
        User n = new User();
        
        return "failed";
        }

        
        

}