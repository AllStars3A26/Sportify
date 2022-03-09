/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.UtilisateurService;
import Entities.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLResetController implements Initializable {

    @FXML
    private TextField nv_pass;
    @FXML
    private TextField conv_pass;
    @FXML
    private Button modifier;
    private Label text;
Stage app_stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resetpass(ActionEvent event) {
             
       
           CurrentUser cu = CurrentUser.CurrentUser();
if(!nv_pass.getText().isEmpty()&& !conv_pass.getText().isEmpty())
        {
         
            if (nv_pass.getText().equals(conv_pass.getText()))
            {
                UtilisateurService us = new UtilisateurService();
                
                Utilisateur u = us.findById(cu.targetId);
                System.out.println(u);
                String hashed = BCrypt.hashpw(nv_pass.getText(), BCrypt.gensalt());
                u.setPwd(hashed);
                us.updatePassword(u); 
                
                Parent loader;
            try {
                loader = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
                //Creates a Parent called loader and assign it as ScReen2.FXML
                              loader.setOnMousePressed(pressEvent -> {
                        loader.setOnMouseDragged(dragEvent -> {
        app_stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        app_stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});

                Scene scene = new Scene(loader); //This creates a new scene called scene and assigns it as the Sample.FXML document which was named "loader"

                 app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //this accesses the window.

                app_stage.setScene(scene); //This sets the scene as scene

                app_stage.show(); // this shows the scene
            } catch (IOException ex) {
            }
            }
            else
            
               text.setText("Les deux mots de passe ne sont identiques");
            }
    }
    
}
