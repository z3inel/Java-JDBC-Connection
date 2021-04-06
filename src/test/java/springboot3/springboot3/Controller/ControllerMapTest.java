/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot3.springboot3.Controller;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import springboot3.springboot3.Controller.UserRepository;


public class ControllerMapTest {
    
    public ControllerMapTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test of main method, of class ControllerMap.
     * Test is not useable in some of reasons
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String name = "";
        Model model = null;
        ControllerMap instance = new ControllerMap();
        String expResult = "";
        String result = instance.main(name, model);
    }
    
}
