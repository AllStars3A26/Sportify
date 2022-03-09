/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Seance;
import entities.Cours;
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
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceSeance;
import services.ServiceCours;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class CoursController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle photo;
    @FXML
    private Label nbt;
    @FXML
    private Label nbtnj;
    @FXML
    private TableView<Cours> tableCours;
    @FXML
    private TableColumn<Cours, String> titre ,nome,type,imc;
    @FXML
    private TableColumn<Cours,Integer> nb_heure;
    @FXML
    private TableColumn<Cours,Button> modifcours;
    @FXML
    private TableColumn<Cours,Button> suppcours;
    @FXML
    private TableColumn<Cours,Integer> ID;
     @FXML
    private TableView<Seance> tableSeance;
    @FXML
    private TableColumn<Seance, String> nomtsm ,nomesm;
    @FXML
    private TableColumn<Seance,Integer> nb_psm;
    @FXML
    private TableColumn<Seance,Button> modifSeance;
    @FXML
    private TableColumn<Seance,Button> suppSeance;
    @FXML
    private TableColumn<Seance,Integer> heuresm;
       @FXML
    private TableColumn<Seance,Date> datesm;
    @FXML
    private Button reload;
    @FXML
    private ChoiceBox getType;
    @FXML
    private ChoiceBox getImc;
    @FXML
    private TextField gettitre;
    @FXML
    private TextField getNomE;
    @FXML
    private TextField getNb_heure;
    @FXML
    private TextField getP1;
    @FXML
    private TextField getP2;
    @FXML
    private TextField getP3;
    @FXML
    private ComboBox<?> etat_tournoi;
    @FXML
    private Button ajouterTournoi;
    @FXML
    private TextField getheure_tournoi;
    @FXML
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
    private TableView<Seance> tableMatch;
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
    private TextField getEquipe1;
    @FXML
    private TextField getEquipe2;
    @FXML
    private ComboBox<?> etat_match;
    @FXML
    private Button ajouterMatch;
    @FXML
    private DatePicker getDate_match;
    @FXML
    private TextField getTournoi;
    @FXML
    private TextField getServeur;
    @FXML
    private ComboBox<?> type_match;
    @FXML
    //private TableColumn<tournoi,Integer> RESULTAT;
  
   //@FXML 
       private TextField getResultat;
    @FXML
    void reloadd(ActionEvent event) {
            ServiceCours tt = new ServiceCours();
        lt = tt.afficher();
             tableCours.getItems().clear();
          afficher_cours(lt);
          ServiceCours ss = new ServiceCours();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
    }

    
      ServiceCours st = new ServiceCours();
     List<Cours> lt = st.afficher();
     ServiceSeance sm = new ServiceSeance();
     List<Seance> lm = sm.afficher();
     
     
     
    
    Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] supprimerb1 = new Button[100];
        int index=101; 
         
           private void handleButtonAction (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb2[i])
             {
                 index1=i;
             }
            
                 
         }
          System.out.println(index1);
          int index2 = lt.get(index1).getId_cours();
            ServiceCours tt = new ServiceCours();
            
             tt.supprimer(index2);
             lt = tt.afficher();
             tableSeance.getItems().clear();
          afficher_cours(lt);
          ServiceCours ss = new ServiceCours();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
          private void modifierButtonAction (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("ModifierCours.fxml"));
            Parent root = modif.load();
            ModifierCoursController mc = modif.getController();
            for (int i = 0; i < lt.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lt.get(index).getId_cours();
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
                ServiceCours tt = new ServiceCours();
                List<Cours> ltt = tt.afficher();
             tableCours.getItems().clear();
          afficher_cours(lt);
          ServiceCours ss = new ServiceCours();
       //  int nbtt= ss.nb_tournoi(lt);
     //   nbt.setText(String.valueOf(nbt));
      //  int nbttt= ss.nb_tournoiNonjoue();
       // nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
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
          ObservableList<String> langs1 = FXCollections.observableArrayList("RPM", "Body Pump", "Yoga", "Boxe","Zumba","Musculation","Pilates");
        getType.setItems(langs1);
        ObservableList<String> langs = FXCollections.observableArrayList("Endurance", "Souplesse", "Résistance", "Equilibre","Vitesse");
        getImc.setItems(langs);
        
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
             lt.get(i).setModifierCours(modify_button[i]);
             lt.get(i).setSupprimerCours(supprimerb[i]);
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
        
       ObservableList<Cours> datalist = FXCollections.observableArrayList(lt);
        
          titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        imc.setCellValueFactory(new PropertyValueFactory<>("imc"));
       
        modifcours.setCellValueFactory(new PropertyValueFactory<>("modifierCours"));
        suppcours.setCellValueFactory(new PropertyValueFactory<>("supprimerCours"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
        System.out.println(lt);
        tableCours.setItems(datalist);
    }    

  
   
    @FXML
    private void reloadd1(ActionEvent event) {
    }

    @FXML
    private void ajouterCours(ActionEvent event) {
        //////////////////
        
       
        
        /////////////////////
        
        ServiceCours sp=new ServiceCours();
          
        
        String titre = gettitre.getText();
        String nome = getNomE.getText();
        int nbheure = Integer.parseInt(getNb_heure.getText());
        String type = getType.getValue().toString();
        String imc = getImc.getValue().toString();
        Cours t = new Cours(titre,nome,type,imc,nbheure);
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Cours ajouté!");
            alert.show();
            gettitre.setText("");
            getNomE.setText("");
            getNb_heure.setText("");
            getheure_tournoi.setText("");
            ServiceCours tt = new ServiceCours();
             List<Cours> ltt = tt.afficher();
             tableCours.getItems().clear();
          afficher_cours(ltt);
          ServiceCours ss = new ServiceCours();
//          int nbtt= ss.nb_tournoi(ltt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
            
        }
    
     public void afficher_cours(List<Cours> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
            ImageView modify = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
            ltt.get(i).setModifierCours(modify_button[i]);
             ltt.get(i).setSupprimerCours(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction);
           modify_button[i].setOnAction(this::modifierButtonAction);
        }
       ObservableList<Cours> datalist = FXCollections.observableArrayList(lt);
        
          titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        imc.setCellValueFactory(new PropertyValueFactory<>("imc"));
       
        modifcours.setCellValueFactory(new PropertyValueFactory<>("modifierCours"));
        suppcours.setCellValueFactory(new PropertyValueFactory<>("supprimerCours"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
        System.out.println(lt);
        tableCours.setItems(datalist);
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
    Button[] modify_button2 = new Button[100];
       Button[] supprimerb2 = new Button[100];
       Button[] modify_button11 = new Button[100];
       Button[] supprimerb11 = new Button[100];
        int index1=101; 
       private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lm.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb2[i])
             {
                 index1=i;
             }
            
                 
         }
          System.out.println(index1);
          int index2 = lm.get(index1).getId_seance();
            ServiceSeance tt = new ServiceSeance();
            
             tt.supprimer(index2);
             lm = tt.afficher();
             tableSeance.getItems().clear();
          afficher_seance(lm);
          ServiceSeance ss = new ServiceSeance();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
          private void modifierButtonAction1 (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("ModifierSeance.fxml"));
            Parent root = modif.load();
            ModifierSeanceController mc = modif.getController();
            for (int i = 0; i < lm.size(); i++) {
            if (event.getSource() == modify_button2[i])
             {
                 index1=i;
             }}
            System.out.println(index1);
            int index2 = lt.get(index1).getId_cours();
            String s=String.valueOf(index2);
            System.out.println(s);
               mc.setTextID(s);
              mc.setItems(index2);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                ServiceSeance tt = new ServiceSeance();
                List<Seance> ltt = tt.afficher();
             tableSeance.getItems().clear();
          afficher_cours(lm);
          ServiceSeance ss = new ServiceSeance();
       //  int nbtt= ss.nb_tournoi(lt);
     //   nbt.setText(String.valueOf(nbt));
      //  int nbttt= ss.nb_tournoiNonjoue();
       // nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 
}
