/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Adhérent;
import Entities.UserSession;
import Services.UserUtiles;

import Services.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SettingsController implements Initializable {

    @FXML
    private AnchorPane principale11;
    @FXML
    private Circle photo;
    @FXML
    private Label label22;
    @FXML
    private TextField Nom_A;
    @FXML
    private TextField Prenom_A;
    @FXML
    private TextField Adresse_A;
    @FXML
    private TextArea ima;
    @FXML
    private TextField Username_A;
    @FXML
    private Button ModifyE;
    @FXML
    private TextField Email_A;
    @FXML
    private TextArea desc_A;
UserUtiles uUtiles = new UserUtiles();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label22.setText(UserSession.getInstance().getUserName());
        try {
            // TODO
            UtilisateurService sp=new UtilisateurService();
            setItems(sp.geIdbyemail(UserSession.getInstance().getEmail()));
        } catch (SQLException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 public void setItems (int id)
    {
        UtilisateurService sp= new UtilisateurService();
       List<Adhérent> ll = sp.afficherIdAdhérent(id);
         

         
       Prenom_A.setText(String.valueOf(ll.get(0).getPrenom()));
        Nom_A.setText(String.valueOf(ll.get(0).getNom()));
        Adresse_A.setText(String.valueOf(ll.get(0).getAdresse()));
        Username_A.setText(String.valueOf(ll.get(0).getLogin()));
        Email_A.setText(String.valueOf(ll.get(0).getEmail()));
        desc_A.setText(String.valueOf(ll.get(0).getDesc()));

            ModifItems(id);
    }
      public void alert_Box(String title, String message) {
	Alert dg = new Alert(Alert.AlertType.WARNING);
	dg.setTitle(title);
	dg.setContentText(message);
	dg.show();
    }
    public void ModifItems (int id)
    {
                UtilisateurService sp=new UtilisateurService();
            List<Adhérent> ll = sp.afficherIdAdhérent(id);
        ModifyE.setOnAction(e -> {
           String PenomAjout = Prenom_A.getText();
        String NomAjout =Nom_A.getText();
        String AdresseAjout =Adresse_A.getText();
        String LoginAjout =Username_A.getText();
        
        String emailAjout =Email_A.getText();
        String descriptionAjout =desc_A.getText();
        if (PenomAjout.isEmpty() || NomAjout.isEmpty() || LoginAjout.isEmpty() ) {
	    alert_Box("Verification", "Votre nom/prenom/username ne doit pas être vide");
	}else if (!uUtiles.testEmail(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse mail valide");
	} else{

            sp.ModifierAdhérent(NomAjout,PenomAjout,AdresseAjout,LoginAjout, emailAjout,descriptionAjout);
            
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Adhérent modifié!");
            alert.show(); 
            
                
           
        }});
        

                }
    @FXML
    private void return_home(ActionEvent event) {
         try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLDashbordclient.fxml"));
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
    private void settings(ActionEvent event) {
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
    
}
