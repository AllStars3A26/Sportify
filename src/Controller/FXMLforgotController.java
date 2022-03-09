/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.SendMail;
import Services.UtilisateurService;
import Entities.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLforgotController implements Initializable {
 CurrentUser cu;
    Stage Stage2;
    @FXML
    private TextField txt_usr;
    @FXML
    private TextField txt_email;
    @FXML
    private Label labelemail;
    @FXML
    private Button Reset;
    @FXML
    private ImageView arrow_tologin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txt_email.setDisable(true);
        Reset.setDisable(true);
    }    

   
   

    @FXML
    private void sendcode(ActionEvent event) throws SQLException {
         cu = CurrentUser.CurrentUser();
            UtilisateurService us = new UtilisateurService();
            if (us.verifierEmailBd(txt_usr.getText())) {
                txt_email.setDisable(false);
                Reset.setDisable(false);
                labelemail.setText("un code a été envoyé a votre Email, retapez-le ici");

                String code = us.getAlphaNumericString(8);
                cu.targetId = us.geIdbyemail(txt_usr.getText());
                cu.code = code;

                String email = txt_usr.getText();
                us.updateCode(code, us.geIdbyemail(txt_email.getText()));
                System.out.println(code);
                String cn = "Saissisez ce code pour réinitialiser votre mot de passe : " + code;

                String sb = "Mot de passe oublié";
                SendMail.sendMail(email, sb, cn);
            } else {
                labelemail.setText("Username n'existe pas");
            }
        }

    @FXML
    private void Reset_onclick(ActionEvent event) {
         System.out.println(cu);
        if (cu.code.equals(txt_email.getText())) {
            try {
            Parent   root = FXMLLoader.load(getClass().getResource("/View/FXMLReset.fxml"));
            Stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                        root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage2.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage2.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage2.setScene(scene);
                        Stage2.show();
            } catch (IOException ex) {
                 System.out.println(ex.getMessage());
            }
        } else {
            labelemail.setText("code incorrect");
        }
    }

    @FXML
    private void back(MouseEvent event) {
                                  Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
            Stage2 = (Stage)((Node)event.getSource()).getScene().getWindow();
                          root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage2.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage2.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage2.setScene(scene);
                        Stage2.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }
    }
    

