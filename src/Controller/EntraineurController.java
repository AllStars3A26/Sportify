/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import Entities.Entraineur;
import Entities.UserSession;
import Entities.Utilisateur;
import Services.UtilisateurService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import Services.UserUtiles;
import gui.terrainController;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EntraineurController implements Initializable {
Button[] modify_button = new Button[100];
Button[] supprimerb = new Button[100];
    @FXML
    private Circle photo;
    private ListView<Utilisateur> listEntraineur;
    @FXML
    private TextField getNom_E;
    @FXML
    private TextField getPrenom_E;
    @FXML
    private TextField getAdresse_E;
    @FXML
    private TextArea ima;
    @FXML
    private TextField getUsername_E;
    @FXML
    private Button ajout_bouton;
    @FXML
    private TextField getEmail_E;
    @FXML
    private TextField getType_E;
    @FXML
    private DatePicker getDate_con;
    @FXML
    private TextField getDuré;
    @FXML
    private TextField getnum_e;
    @FXML
    private PasswordField getpasswordd_E;
    @FXML
    private PasswordField getpassword_E;
List <Utilisateur> RECC ;
UtilisateurService sr = new UtilisateurService();
    @FXML
    private AnchorPane principale11;
    public static Entraineur  o ;
    List<Entraineur> lt = sr.afficherEntraineur();
    @FXML
    private Label label22;
    private TableView<?> tableTerrain;
    @FXML
    private TableColumn<?, ?> Prenom;
    @FXML
    private TableColumn<?, ?> Nom;
    private TableColumn<?, ?> type;
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> MODIFIER;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TextField search_button1;
    @FXML
    private TableColumn<Entraineur, ?> Adresse;
    @FXML
    private TableColumn<Entraineur, ?> Email;
    @FXML
    private TableColumn<Entraineur, ?> Type;
    @FXML
    private TableColumn<Entraineur, ?> Date_contractt;
    private TableColumn<Entraineur, ?> dure;
   
    @FXML
    private TableColumn<Entraineur, ?> Num;
   
    @FXML
    private TableView<Entraineur> tableE;
     int index=101;
    @FXML
    private TableColumn<?, ?> dure_contractt;
    
   UserUtiles uUtiles = new UserUtiles();
    /**
     * Initializes the controller class.
     */
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
             lt = tt.afficherEntraineur();
             tableE.getItems().clear();
             afficher_E(lt);
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
                    lt = tt.afficherEntraineur();
             tableE.getItems().clear();
                afficher_E(lt);
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

        
       ObservableList<Entraineur> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Type.setCellValueFactory(new PropertyValueFactory<>("type_E"));
        dure_contractt.setCellValueFactory(new PropertyValueFactory<>("dure"));
        Date_contractt.setCellValueFactory(new PropertyValueFactory<>("Date_contract"));
        Num.setCellValueFactory(new PropertyValueFactory<>("num"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableE.setItems(datalist);
        
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
          List<Entraineur> ltt = tt.rechercheEntraineur(search_button1.getText());
          tableE.getItems().clear();
          afficher_E(ltt);
    }

   public void alert_Box(String title, String message) {
	Alert dg = new Alert(Alert.AlertType.WARNING);
	dg.setTitle(title);
	dg.setContentText(message);
	dg.show();
    }

    @FXML
    private void ajouterentraineur(ActionEvent event) throws IOException {
           
        UtilisateurService sp= new UtilisateurService();
        String PenomAjout = getPrenom_E.getText();
        String NomAjout =getNom_E.getText();
        String AdresseAjout =getAdresse_E.getText();
        String LoginAjout =getUsername_E.getText();
        String PasswordAjout = getpassword_E.getText();
        String PassworddAjout = getpasswordd_E.getText();
        String emailAjout =getEmail_E.getText();
        String TypeAjout =getType_E.getText();
        String Date_contractAjout =getDate_con.getValue().toString();
        int DureAjout = Integer.parseInt(getDuré.getText());
        String numAjout =getnum_e.getText();

         if (PenomAjout.isEmpty() || NomAjout.isEmpty() || LoginAjout.isEmpty() ) {
	    alert_Box("Verification", "Votre nom/prenom/username ne doit pas être vide");
	}else if (sp.verifierUsername(LoginAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse non existant");
	}else if (!uUtiles.testEmail(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse mail valide");
	} else if (sp.verifierEmailBd(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse non existant");
	}else if (!PasswordAjout.equals(PassworddAjout)) {
	    alert_Box("Verifier mot de passe", "Veillez verifier votre mot de passe ");
	} else if (!uUtiles.testTel(numAjout)) {
	    alert_Box("Verifier votre numero telephone", "Veillez mettre un numero de telephone valide");
	} else{
        
        Entraineur e = new Entraineur(NomAjout,PenomAjout,AdresseAjout,LoginAjout, PasswordAjout , numAjout, emailAjout, TypeAjout,DureAjout,Date_contractAjout, 2);
       
        
        
            sp.ajouterUtilisateur(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Entraineur ajouté!");
            alert.show();
            getAdresse_E.setText("");
            
            getDuré.setText("");
            getEmail_E.setText("");
             getNom_E.setText("");
            getPrenom_E.setText("");
            getType_E.setText("");
            getnum_e.setText("");
             getUsername_E.setText("");
            getpassword_E.setText("");
            getpasswordd_E.setText("");
          Parent root = FXMLLoader.load(getClass().getResource("/View/Entraineur.fxml"));
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
public void afficher_E(List<Entraineur> ltt)
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

        
       ObservableList<Entraineur> datalist = FXCollections.observableArrayList(lt);
        
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Type.setCellValueFactory(new PropertyValueFactory<>("type_E"));
        Date_contractt.setCellValueFactory(new PropertyValueFactory<>("Date_contract"));
        dure_contractt.setCellValueFactory(new PropertyValueFactory<>("dure"));
        Num.setCellValueFactory(new PropertyValueFactory<>("num"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableE.setItems(datalist);
    }

    @FXML
    private void Adhérent_page(ActionEvent event) {
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/View/Adheerent.fxml"));
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
    private void admin_page(ActionEvent event) {
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
    
    
}
