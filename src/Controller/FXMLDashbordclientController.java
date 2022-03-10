/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.UserSession;
import Services.UtilisateurService;
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
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLDashbordclientController implements Initializable {

    @FXML
    private AnchorPane principale11;
    @FXML
    private Circle photo;
    @FXML
    private Label label22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UtilisateurService us = new UtilisateurService();
       /* photo.setStroke(Color.SEAGREEN);
        Image im = new Image(us.getimbyemail(UserSession.getInstance().getEmail()), false);
        photo.setFill(new ImagePattern(im));
        photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));*/
                label22.setText(UserSession.getInstance().getUserName());

    }    

    @FXML
    private void return_home(ActionEvent event) {
    }

    @FXML
    private void log_out(ActionEvent event) {
          label22.setText("");
        UserSession.getInstance().cleanUserSession();
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void closeapp(MouseEvent event) {
         Stage Stage1_1 = (Stage)principale11.getScene().getWindow();
        System.out.println("you succesfully close the application");
        Stage1_1.close();
    }

    @FXML
    private void settings(ActionEvent event) {
          try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void equipe(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/gui/equipe.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void tournoiswitch(ActionEvent event) {
         try {
           Parent root = FXMLLoader.load(getClass().getResource("/gui/tournoiadherant.fxml"));
          Stage  Stage1_1 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_1.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_1.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_1.setScene(scene);
                        Stage1_1.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }
    
}
