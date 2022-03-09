/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.produit;
import entities.tournoi;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceMatch;
import services.ServiceTournoi;

/**
 * FXML Controller class
 *
 * @author Snowy
 * 
 */
public class TournoiController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle photo;
    @FXML
    private TableView<tournoi> tableTournoi;
    @FXML
    private TableColumn<tournoi, String> NOM;
    @FXML
    private TableColumn<tournoi,Integer> NB_MAX;
    @FXML
    private TableColumn<tournoi,String> IMAGE;
    @FXML
    private TableColumn<tournoi,Date> DATE;
    @FXML
    private TableColumn<tournoi,Button> MODIFIER;
    @FXML
    private TableColumn<tournoi,Button> SUPPRIMER;
    @FXML
    private TableColumn<tournoi,Integer> ID;
    @FXML
    private Button reload;
    @FXML
    private TextField getNom_tournoi;
    @FXML
    private TextField getNb_max;
    @FXML
    private Button ajouterTournoi;
    private TextField getheure_tournoi;
    private DatePicker getDate_tournoi;
    @FXML
    private TextArea ima;
    @FXML
    private Button buttonima;
    @FXML
    private Label nbt1;
    @FXML
    private Label nbtnj1;
    @FXML
    private TableView<tournoi> tableMatch;
    @FXML
    private TableColumn<?, ?> EQUIPE1M;
    @FXML
    private TableColumn<?, ?> EQUIPE2M;
    @FXML
    private TableColumn<?, ?> DATEM;
    @FXML
    private TableColumn<?, ?> SERVEURM;
    @FXML
    private TableColumn<?, ?> ETATM;
    @FXML
    private TableColumn<?, ?> TYPEM;
    @FXML
    private TableColumn<?, ?> TOURNOIM;
    @FXML
    private TableColumn<?, ?> SCORE1M;
    @FXML
    private TableColumn<?, ?> SCORE2M;
    @FXML
    private TableColumn<?, ?> MODIFIER1;
    @FXML
    private TableColumn<?, ?> SUPPRIMER1;
    @FXML
    private TableColumn<?, ?> ID1;
    @FXML
    private Button reload1;
    @FXML
    private TableColumn<tournoi,Integer> RESULTAT;
            private TextField getResultat;
    @FXML
    private TableColumn<?, ?> IMAGE1;
    @FXML
    private TextField search_button;
    @FXML
    private TextField getNb_max1;
    @FXML
    private TextField getNb_max11;
    @FXML
    private TextField getNb_max12;
    @FXML
    void reloadd(ActionEvent event) {
            ServiceTournoi tt = new ServiceTournoi();
        lt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(lt);
          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
    }

    
      ServiceTournoi st = new ServiceTournoi();
     List<tournoi> lt = st.afficher();
     ServiceMatch sm = new ServiceMatch();
     List<match> lm = sm.afficher();
     
     
     
    
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
          int index1 = lt.get(index).getId_tournoi();
            ServiceTournoi tt = new ServiceTournoi();
            
             tt.supprimer(index1);
             lt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(lt);
          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
          private void modifierButtonAction (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierTournoi.fxml"));
            Parent root = modif.load();
            ModifierTournoiController mc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getId_tournoi();
            String s=String.valueOf(index1);
            System.out.println(s);
               mc.setTextID(s);
              mc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                ServiceTournoi tt = new ServiceTournoi();
                List<tournoi> ltt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(lt);
          ServiceTournoi ss = new ServiceTournoi();
       //  int nbtt= ss.nb_tournoi(lt);
     //   nbt.setText(String.valueOf(nbt));
      //  int nbttt= ss.nb_tournoiNonjoue();
       // nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        photo.setStroke(Color.SEAGREEN);
        Image im = new Image("/images/1.png", false);
        photo.setFill(new ImagePattern(im));
        photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        
         final FileChooser fileChooser = new FileChooser();
         buttonima.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ima.clear();
              Stage a =(Stage) buttonima.getScene().getWindow();
                File file = fileChooser.showOpenDialog(a);
                if (file != null) {
                    openFile(file);
                    List<File> files = Arrays.asList(file);
                    printLog(ima, files);
                }
            }
        });
        
        
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
//        for (int i = 0; i < lm.size(); i++) {
//            ImageView modify1 = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
//         modify_button1[i] = new Button("", modify1);
//    ImageView supprimer1 = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
//         supprimerb1[i] = new Button("", supprimer1);
//            lm.get(i).setModifier(modify_button1[i]);
//             lm.get(i).setSupprimer(supprimerb1[i]);
//            supprimerb1[i].setOnAction(this::handleButtonAction1);
//            modify_button1[i].setOnAction(this::modifierButtonAction1);
//        }
        
       ObservableList<tournoi> datalist = FXCollections.observableArrayList(lt);
        
          NOM.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi"));
        DATE.setCellValueFactory(new PropertyValueFactory<>("date_tournoi"));
        RESULTAT.setCellValueFactory(new PropertyValueFactory<>("resultat_tournoi"));
        NB_MAX.setCellValueFactory(new PropertyValueFactory<>("nb_participants"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image_tournoi"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));
        System.out.println(lt);
        tableTournoi.setItems(datalist);
    }    

   
   


   
    @FXML
    private void reloadd1(ActionEvent event) {
    }

    
    @FXML
    private void ajouterTournoi(ActionEvent event) {
        //////////////////
        
       
        
        /////////////////////
        
        ServiceTournoi sp= new ServiceTournoi();
        String nomAjout = getNom_tournoi.getText();
        int nb_participantsAjout = Integer.parseInt(getNb_max.getText());
        
        int resultatAjout = Integer.parseInt(getResultat.getText());
        
        String imageAjout = ima.getText();
        
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dateAjout = Date.from(getDate_tournoi.getValue().atStartOfDay(defaultZoneId).toInstant());
        int heureAjout = Integer.parseInt(getheure_tournoi.getText());
        
        tournoi t = new tournoi(nomAjout,dateAjout,nb_participantsAjout,imageAjout,resultatAjout,heureAjout);
        
        
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Tournoi ajouté!");
            alert.show();
            getNom_tournoi.setText("");
            getNb_max.setText("");
            getResultat.setText("");
            getheure_tournoi.setText("");
            ServiceTournoi tt = new ServiceTournoi();
             List<tournoi> ltt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(ltt);
          ServiceTournoi ss = new ServiceTournoi();
//          int nbtt= ss.nb_tournoi(ltt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
            
        }
    
     public void afficher_tournoi(List<tournoi> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
            ltt.get(i).setModifier(modify_button[i]);
             ltt.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction);
           modify_button[i].setOnAction(this::modifierButtonAction);
        }
       ObservableList<tournoi> datalist = FXCollections.observableArrayList(ltt);
        
          NOM.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi"));
        DATE.setCellValueFactory(new PropertyValueFactory<>("date_tournoi"));
        RESULTAT.setCellValueFactory(new PropertyValueFactory<>("resultat_tournoi"));
        NB_MAX.setCellValueFactory(new PropertyValueFactory<>("nb_participants"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image_tournoi"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));

        tableTournoi.setItems(datalist); 
    }
     private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchmethode(KeyEvent event) {
    }
}
