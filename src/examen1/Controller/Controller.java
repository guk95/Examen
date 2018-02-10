/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;
import examen1.Model.ChatBox;
import examen1.View.ChatBoxView;



/**
 *
 * @author Mario
 */
public class Controller {
    public Controller(){}
    
       public void Start() {
       ChatBox chatBox= new ChatBox();
        ChatBoxView boxView= new ChatBoxView();
        
        Manager manager = new Manager(chatBox,boxView);
   

    }
    
}
