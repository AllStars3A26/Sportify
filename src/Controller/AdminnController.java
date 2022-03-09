/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Adhérent;
import Entities.Utilisateur;
import Services.UtilisateurService;
import Entities.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import Entities.CurrentUser;
import Entities.UserSession;
import Services.UserUtiles;
import gui.terrainController;
import javafx.scene.Node;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AdminnController implements Initializable {

    @FXML
    private AnchorPane principale11;
    @FXML
    private Circle photo;
    @FXML
    private Label label22;
    @FXML
    private TableColumn<?, ?> Prenom;
    @FXML
    private TableColumn<?, ?> Nom;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Email;
    @FXML
    private TableColumn<?, ?> MODIFIER;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TextField search_button1;
    @FXML
    private TextField getNom_d;
    @FXML
    private TextField getPrenom_d;
    @FXML
    private TextField getAdresse_E;
    @FXML
    private TextArea ima;
    @FXML
    private TextField getUsername_d;
    @FXML
    private Button ajout_bouton;
    @FXML
    private TextField getEmail_d;
    @FXML
    private PasswordField getpasswordd_d;
    @FXML
    private PasswordField getpassword_d;
     UserSession u;
      UtilisateurService sr = new UtilisateurService();
      Button[] modify_button = new Button[100];
    Button[] supprimerb = new Button[100];
List<Utilisateur> lt = sr.afficherAdmin();
 UserUtiles uUtiles = new UserUtiles();
    @FXML
    private TableView<Utilisateur> tabled;
    /**
     * Initializes the controller class.
     */int index=101;
     
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
            if ("yassine.ayadi1@esprit.tn".equals(UserSession.getInstance().getEmail())){
                System.out.println("houni ena d5alt wkamalt");
                if(!(lt.get(index).getEmail().equals(UserSession.getInstance().getEmail()))){
                     tt.supprimerEntraineur(index1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("suppression affecté!");
            alert.show();
             lt = tt.afficherAdmin();
             tabled.getItems().clear();
             afficher_d(lt);
                }else {
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("denied");
            alert.setContentText("it's you !");
            alert.show();
                }
           
            }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Denied");
            alert.setContentText("suppression non affecté!");
            alert.show();
            }
          
            
             
            
           
     }
          private void modifierButtonAction (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("/View/ModifierEntraineur.fxml"));
            Parent root = modif.load();
            ModifierEntraineurController mc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getid();
              mc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                 UtilisateurService tt = new UtilisateurService();
                    lt = tt.afficherAdmin();
             tabled.getItems().clear();
                afficher_d(lt);
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(terrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
            modify_button[i].setOnAction(this::modifierButtonAction);
        }

        
       ObservableList<Utilisateur> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tabled.setItems(datalist);
    }    
public void afficher_d(List<Utilisateur> ltt)
    {
                  for (int i = 0; i < lt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
            modify_button[i].setOnAction(this::modifierButtonAction);
        }

        
       ObservableList<Utilisateur> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tabled.setItems(datalist);
    }
    @FXML
    private void return_home(ActionEvent event) {
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/home_admin.fxml"));
          Stage  Stage1_2 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_2.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_2.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_2.setScene(scene);
                        Stage1_2.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void equipeswitch(ActionEvent event) {
    }

    @FXML
    private void tournoiswithc(ActionEvent event) {
    }

    @FXML
    private void produitswitch(ActionEvent event) {
    }

    @FXML
    private void evenementswitch(ActionEvent event) {
    }

    @FXML
    private void séanceswitch(ActionEvent event) {
    }

    @FXML
    private void Adhérent_page(ActionEvent event) {
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/Adheerent.fxml"));
          Stage  Stage1_2 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage1_2.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage1_2.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage1_2.setScene(scene);
                        Stage1_2.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void entraineur_page(ActionEvent event) {
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
    }

 public void alert_Box(String title, String message) {
	Alert dg = new Alert(Alert.AlertType.WARNING);
	dg.setTitle(title);
	dg.setContentText(message);
	dg.show();
    }
    @FXML
    private void ajoutadmin(ActionEvent event) throws IOException {
                UtilisateurService sp= new UtilisateurService();
        String PenomAjout = getPrenom_d.getText();
        String NomAjout =getNom_d.getText();
        String AdresseAjout =getAdresse_E.getText();
        String LoginAjout =getUsername_d.getText();
        String PasswordAjout = getpassword_d.getText();
        String PassworddAjout = getpasswordd_d.getText();
        String emailAjout =getEmail_d.getText();
        

         if (PenomAjout.isEmpty() || NomAjout.isEmpty() || LoginAjout.isEmpty() ) {
	    alert_Box("Verification", "Votre nom/prenom/username ne doit pas être vide");
	}else if (sp.verifierUsername(LoginAjout)) {
	    alert_Box("Verifier ", "veillez saisir un login non existant");
	}else if (!uUtiles.testEmail(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse mail valide");
	} else if (sp.verifierEmailBd(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse non existant");
	}else if (!PasswordAjout.equals(PassworddAjout)) {
	    alert_Box("Verifier mot de passe", "Veillez verifier votre mot de passe ");
	} else{
        
        Utilisateur e = new Utilisateur(0,NomAjout,PenomAjout,AdresseAjout,LoginAjout, PasswordAjout ,  emailAjout);
       
        
        
            sp.ajouterUtilisateur(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Admin ajouté!");
            alert.show();
            getPrenom_d.setText("");
       getNom_d.setText("");
        getAdresse_E.setText("");
       getUsername_d.setText("");
       getpassword_d.setText("");
        getpasswordd_d.setText("");
        getEmail_d.setText("");
          Parent root = FXMLLoader.load(getClass().getResource("/View/Adminn.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void closeapp(MouseEvent event) {
                 Stage Stage1_1 = (Stage)principale11.getScene().getWindow();
        System.out.println("you succesfully close the application");
        Stage1_1.close();
    }
    
}
