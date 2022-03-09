/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Evenement;
import entities.ticket;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import services.Serviceevenement;
import services.Serviceterrain;
import services.Serviceticket;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Evenement_ticketController implements Initializable {

    @FXML
    private Circle photo;
    @FXML
    private TableView<Evenement> tableE;
    @FXML
    private TableColumn<?, ?> Libelle;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<Evenement,Date> Date;
    @FXML
    private TableColumn<?, ?> MODIFIER;
    @FXML
    private TableColumn<?, ?> SUPPRIMER;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private Button tri;
    @FXML
    private TextField r;
    @FXML
    private TextField getlibelle_E;
    @FXML
    private TextField gettype_E;
    @FXML
    private Button ajouter_evenement;
    @FXML
    private TextArea ima;
    @FXML
    private DatePicker getdate_E;
    @FXML
    private TableView<ticket> tableT;
    @FXML
    private TableColumn<?, ?> libelle_t;
    @FXML
    private TableColumn<?, ?> type_t;
    @FXML
    private TableColumn<?, ?> date_t;
    @FXML
    private TableColumn<?, ?> prix_t;
    @FXML
    private TableColumn<?, ?> MODIFIER1;
    @FXML
    private TableColumn<?, ?> SUPPRIMER1;
    @FXML
    private TableColumn<?, ?> ID1;
    @FXML
    private Button tri1;
    @FXML
    private TextField getlibelle_t;
    @FXML
    private TextField gettype_t;
    @FXML
    private Button ajouter_ticket;
    @FXML
    private TextField getprix_t;
    @FXML
    private DatePicker getdate_t;

    /**
     * Initializes the controller class.
     */
         Serviceevenement st = new Serviceevenement();
     List<Evenement> lt = st.afficher();
     Serviceticket sm = new Serviceticket();
     List<ticket> lm = sm.afficher();
     
     
     
    
    Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] supprimerb1 = new Button[100];
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
            System.out.println(lt.get(0));
         int index1 = lt.get(index).getId_evenement();
         System.out.println(index1);
            Serviceevenement tt = new Serviceevenement();
            
             tt.supprimer(index1);
             lt = tt.afficher();
             tableE.getItems().clear();
          afficher_E(lt);

     }
         private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lm.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          //System.out.println(index);
          int index1 = lm.get(index).getId_ticket();
        
            Serviceticket tt = new Serviceticket();
            
             tt.supprimer(index1);
             lm = tt.afficher();
             tableE.getItems().clear();
                afficher_t(lm);
       

     }
         private void modifierButtonAction (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierevenement.fxml"));
            Parent root = modif.load();
            ModifierterrainController mc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getId_evenement();
            
            String s=String.valueOf(index1);
            //System.out.println(s);
               mc.setTextID(s);
              mc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                 Serviceevenement tt = new Serviceevenement();
                    lt = tt.afficher();
             tableE.getItems().clear();
          afficher_E(lt);
          Serviceevenement ss = new Serviceevenement();
                 int nbtt= ss.nb_evenement(lt);
        //nbt.setText(String.valueOf(nbtt));
      
                       
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
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           //modify_button[i].setOnAction(this::modifierButtonAction1);
      }

       ObservableList<Evenement> datalist = FXCollections.observableArrayList(lt);
        
        Libelle.setCellValueFactory(new PropertyValueFactory<>("libelle_evenement"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_evenement"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date_evenement"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableE.setItems(datalist);

        
       /* ObservableList<ticket> datalist1 = FXCollections.observableArrayList(lm);
        
          libelle_t.setCellValueFactory(new PropertyValueFactory<>("libelle_ticket"));
        type_t.setCellValueFactory(new PropertyValueFactory<>("type_ticket"));
        date_t.setCellValueFactory(new PropertyValueFactory<>("date_ticket"));
        prix_t.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier1"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer1"));
        System.out.println(lm);
        tableT.setItems(datalist1);*/
    }    

    @FXML
    private void sign_out(ActionEvent event) {
    }

    @FXML
    private void recherchetf(KeyEvent event) {
    }

    @FXML
    private void searchmethode(KeyEvent event) {
    }

    @FXML
    private void tri_on_clicked(ActionEvent event) {
    }

    @FXML
    private void searchmethode(ActionEvent event) {
    }

    @FXML
    private void recherche_avance(KeyEvent event) {
    }

    @FXML
    private void ajouterevenement(ActionEvent event) throws IOException, ParseException {
           
        /////////////////////
        if ((getlibelle_E.getText().equals(""))||(gettype_E.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();}
        else if(!( Pattern.matches("[a-zA-Z]*",getlibelle_E.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("nom du terrain doit etre de type String !");
            alert.showAndWait();}
        else if(!( Pattern.matches("[a-zA-Z]*",gettype_E.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("type du terrain doit etre de type String !");
            alert.showAndWait();}
        
        else{
        Serviceevenement sp= new Serviceevenement();
        String nomAjout = getlibelle_E.getText();
        String typeAjout =gettype_E.getText();
         ZoneId defaultZoneId = ZoneId.systemDefault();
       String dateAjout =getdate_E.getValue().toString();
       SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date udco=df.parse(dateAjout);
        long ms=udco.getTime();
        java.sql.Date squdco= new java.sql.Date(ms);
        
        Evenement t = new Evenement(nomAjout, typeAjout, squdco);
        
        
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("evenement ajouté!");
            alert.show();
            getlibelle_E.setText("");
            gettype_E.setText("");
           
            
            Serviceevenement tt = new Serviceevenement();
             List<Evenement> ltt = tt.afficher();
             tableE.getItems().clear();
          afficher_E(ltt);
          Parent root = FXMLLoader.load(getClass().getResource("Evenement_ticket.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            /*Notifications notificationBuilder = Notifications.create()
                    .title("Terrain ajouté")
                    .text("un terrain a été ajouter avec succé")
                    .graphic(null)
                    .hideAfter(Duration.seconds(10))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Clicked on Notification");
               }
        });*/
            //notificationBuilder.show();
    }
    }
    @FXML
    private void tri_on_clicked1(ActionEvent event) {
    }

    @FXML
    private void showchart(ActionEvent event) {
    }

    @FXML
    private void ajouterticket(ActionEvent event) {
    }
     public void afficher_E(List<Evenement> ltt)
    {
        for (int i = 0; i < lt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction);
            //modify_button[i].setOnAction(this::modifierButtonAction);
        }
              ObservableList<Evenement> datalist = FXCollections.observableArrayList(lt);
        
        Libelle.setCellValueFactory(new PropertyValueFactory<>("libelle_evenement"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_evenement"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date_evenement"));
        ID.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        System.out.println(lt);
        tableE.setItems(datalist);
    }
     public void afficher_t(List<ticket> ltt)
    {
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
             lt.get(i).setModifier(modify_button[i]);
             lt.get(i).setSupprimer(supprimerb[i]);
           supprimerb[i].setOnAction(this::handleButtonAction1);
            //modify_button[i].setOnAction(this::modifierButtonAction);
        }
               ObservableList<ticket> datalist1 = FXCollections.observableArrayList(lm);
        
          libelle_t.setCellValueFactory(new PropertyValueFactory<>("libelle_ticket"));
        type_t.setCellValueFactory(new PropertyValueFactory<>("type_ticket"));
        date_t.setCellValueFactory(new PropertyValueFactory<>("date_ticket"));
        prix_t.setCellValueFactory(new PropertyValueFactory<>("prix_ticket"));
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier1"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer1"));
        System.out.println(lm);
        tableT.setItems(datalist1);
    }
}
