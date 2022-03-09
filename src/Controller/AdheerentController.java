/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Adhérent;
import Entities.UserSession;
import Entities.Utilisateur;
import Services.UtilisateurService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
public class AdheerentController implements Initializable {

    @FXML
    private AnchorPane principale11;
    @FXML
    private Circle photo;
    @FXML
    private Label label22;
    @FXML
    private TableView<Adhérent> tableA;
    @FXML
    private TableColumn<?, ?> Prenom;
    @FXML
    private TableColumn<?, ?> Nom;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Email;
    @FXML
    private TableColumn<Adhérent,String> Date_inscritt;
    @FXML
    private TableColumn<?, ?> Description;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TextField search_button1;
    UtilisateurService sr = new UtilisateurService();
    Button[] supprimerb = new Button[100];
List<Adhérent> lt = sr.afficherAdhérent();
    /**
     * Initializes the controller class.
     */
int index=101;
 private void handleButtonAction (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lt.get(index).getid();
            UtilisateurService tt = new UtilisateurService();
            
             tt.supprimerEntraineur(index1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("suppression affecté!");
            alert.show();
             lt = tt.afficherAdhérent();
             tableA.getItems().clear();
             afficher_A(lt);
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
         label22.setText(UserSession.getInstance().getUserName());
        //updatelist();
        photo.setStroke(Color.SEAGREEN);
        Image im = new Image("/images/1.png", false);
        photo.setFill(new ImagePattern(im));
        photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
       
        for (int i = 0; i < lt.size(); i++) {
         
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
        }

        
       ObservableList<Adhérent> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Date_inscritt.setCellValueFactory(new PropertyValueFactory<>("date_inscrit"));
        Description.setCellValueFactory(new PropertyValueFactory<>("desc"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableA.setItems(datalist);
    }    

    @FXML
    private void return_home(ActionEvent event) {
          try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/home_admin.fxml"));
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
    private void equipeswtich(ActionEvent event) {
        
    }

    @FXML
    private void tournoiswitch(ActionEvent event) {
    }

    @FXML
    private void produitswitch(ActionEvent event) {
    }

    @FXML
    private void evenementswitch(ActionEvent event) {
    }

    @FXML
    private void seanceswitch(ActionEvent event) {
    }

    @FXML
    private void Adhérent_page(ActionEvent event) {
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
    private void searchmethode(KeyEvent event) {
          UtilisateurService tt = new UtilisateurService();
          List<Adhérent> ltt = tt.rechercheadhérent(search_button1.getText());
          tableA.getItems().clear();
          afficher_A(ltt);
    }

    @FXML
    private void closeapp(MouseEvent event) {
                      Stage Stage1_1 = (Stage)principale11.getScene().getWindow();
        System.out.println("you succesfully close the application");
        Stage1_1.close();
    }
    public void afficher_A(List<Adhérent> ltt)
    {
                for (int i = 0; i < lt.size(); i++) {
         
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
        }

        
       ObservableList<Adhérent> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Date_inscritt.setCellValueFactory(new PropertyValueFactory<>("date_inscrit"));
        Description.setCellValueFactory(new PropertyValueFactory<>("desc"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableA.setItems(datalist);
    }

    @FXML
    private void adminswitch(ActionEvent event) {
         try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/Adminn.fxml"));
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
    private void entreineurswitch(ActionEvent event) {
         try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/Entraineur.fxml"));
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
