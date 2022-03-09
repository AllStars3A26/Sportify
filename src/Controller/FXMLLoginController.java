/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entities.CurrentUser;
import org.mindrot.jbcrypt.BCrypt;
import Entities.UserSession;
import Entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Services.UtilisateurService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField text_username;
    @FXML
    private PasswordField text_password;
    @FXML
    private AnchorPane anchorpanelglobal;
    @FXML
    private Label exit_button;
    Stage Stage1;
    @FXML
    private Button login_button;
    CurrentUser cu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        /*try {
            Parent root = FXMLLoader.load(getClass().getResource("/GuiLogin/FXMLLogin.fxml"));
            root.setOnMousePressed(pressEvent -> {
            root.setOnMouseDragged(dragEvent -> {
        Stage1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
            });
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
                 
    }    
                 
    @FXML
    private void exitX(MouseEvent event) {
        Stage1 = (Stage) anchorpanelglobal.getScene().getWindow();
        System.out.println("you succesfully close the application");
        Stage1.close();
    }


    @FXML
    private void authentifier(ActionEvent event) {
        if (!text_username.getText().isEmpty() && !text_password.getText().isEmpty()) {
            UtilisateurService us = new UtilisateurService();
            Utilisateur user = us.findbyemail(text_username.getText());
            if (user == null){
                System.out.println("email not found");
            }else{
  // user pwd crypted
            String bcryptHashString = user.getPwd();
               
            if (BCrypt.checkpw(text_password.getText(),bcryptHashString)){
                UserSession.getInstace(user.getLogin(),user.getEmail(), user.getRole());
                //System.out.println(users.getEmail()); 
            System.out.println("el if tekhdem");
                String path = "/View/FXMLDashbordclient.fxml";
                
                if (user.getRole() == 0) {
                    System.out.println("admin");
                    path = "/View/home_admin.fxml";
                    
                }
                if (user.getRole() == 2) {
                    System.out.println("admin");
                    path = "/View/FXMLDashbordEntraineur.fxml";
                    
                }
              try {
                 
           
                     Parent root = FXMLLoader.load(getClass().getResource(path));
                        Stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                                      root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage1.setScene(scene);
                        Stage1.show();

                } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                }
            }else {
                 System.out.println("email found wrong password");
            }

        }}else {

            System.out.println("you didn't write anything  ");
 
        }
        
    }

    @FXML
    private void forgot_pass(MouseEvent event) {
         try {
                     Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLforgot.fxml"));
                        Stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                                      root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage1.setScene(scene);
                        Stage1.show();

                } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                }
    }

    @FXML
    private void register_onclick(ActionEvent event) {
                                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLRegister.fxml"));
            Stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                          root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage1.setScene(scene);
                        Stage1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }
    
}

