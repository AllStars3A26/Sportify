/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.SendMail;
import Entities.equipe;
import Entities.terrain;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import Services.Serviceequipe;
import Services.Serviceterrain;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class EquipeController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle photo;
    @FXML
    private Label nbt;
    @FXML
    private TextField getnom;
    @FXML
    private TextField gettype;
    @FXML
    private TextField getdescrip;
    @FXML
    private TextField getadresse;
    @FXML
    private Button reload;
    @FXML
    private TableView<terrain> tableterrain;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> adresse;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private Button Reserver;
    @FXML
    private TableView<equipe> tableEquipe;
    @FXML
    private TableColumn<?, ?> nom_equipe;
    @FXML
    private TableColumn<?, ?> type_equipe;
    @FXML
    private TableColumn<?, ?> description_equipe;
    @FXML
    private TableColumn<?, ?> mail_equipe;
    @FXML
    private TableColumn<?, ?> nbre_equipe;
    @FXML
    private TableColumn<?, ?> MODIFIER1;
    @FXML
    private TableColumn<?, ?> SUPPRIMER1;
    @FXML
    private TableColumn<?, ?> ID1;
    @FXML
    private TextField search_button1;
    @FXML
    private Button tri1;
    @FXML
    private TextField getNom_equipe;
    @FXML
    private TextField getType_equipe;
    @FXML
    private Button ajouterEquipe;
    @FXML
    private TextField getDescription_equipe;
    @FXML
    private TextField getMail_equipe;
    @FXML
    private TextField getNbre_equipe;
    @FXML
    private Button reload1;

   

    @FXML
    private void reloadd(ActionEvent event) {
        Serviceterrain tt = new Serviceterrain();
        lt = tt.afficherDispo();
             tableterrain.getItems().clear();
          ObservableList<terrain> datalist = FXCollections.observableArrayList(lt);
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_terrain"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_terrain"));
        description.setCellValueFactory(new PropertyValueFactory<>("description_terrain"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        
        //System.out.println(lt);
        tableterrain.setItems(datalist);
         Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
           
            
          
    }



    Serviceterrain st = new Serviceterrain();
     List<terrain> lt = st.afficherDispo();
     Serviceequipe sm = new Serviceequipe();
     List<equipe> lm = sm.afficher();
     Button[] modify_button = new Button[100];
       Button[] supprimerb = new Button[100];
       Button[] modify_button1 = new Button[100];
       Button[] supprimerb1 = new Button[100];
        int index=101; 
        private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lt.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb[i])
             {
                 index=i;
             }
            
                 
         }
          //System.out.println(index);
          int index1 = lm.get(index).getId_equipe();
            Serviceequipe tt = new Serviceequipe();
            
             tt.supprimer(index1);
             lm = tt.afficher();
             
         Serviceequipe ss1 = new Serviceequipe();
             tableEquipe.getItems().clear();
             for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
             ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
         /*int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));*/
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
        
       private void modifierButtonAction1 (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierEquipe.fxml"));
            Parent root = modif.load();
            ModifierEquipeController mc = modif.getController();
            for (int i = 0; i < lm.size(); i++) {
            if (event.getSource() == modify_button[i])
             {
                 index=i;
             }}
            //System.out.println(index);
            int index1 = lm.get(index).getId_equipe();
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
                 Serviceequipe tt = new Serviceequipe();
                    lm = tt.afficher();
             tableEquipe.getItems().clear();
             for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
             ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
         Serviceequipe ss1 = new Serviceequipe();
          Serviceequipe ss = new Serviceequipe();
                 /*int nbtt= ss.nb_terrain(lm);
        nbt.setText(String.valueOf(nbtt));*/
      
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(terrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        photo.setStroke(Color.SEAGREEN);
        Image im = new Image("/images/1.png", false);
        photo.setFill(new ImagePattern(im));
        photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
        ObservableList<terrain> datalist = FXCollections.observableArrayList(lt);
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_terrain"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_terrain"));
        description.setCellValueFactory(new PropertyValueFactory<>("description_terrain"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        
        //System.out.println(lt);
        tableterrain.setItems(datalist);
         Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
        
        ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
         Serviceequipe ss1 = new Serviceequipe();
    }

    @FXML
    private void fillforum(MouseEvent event) {
        String username=tableterrain.getSelectionModel().getSelectedItem().getNom_terrain();
        terrain u=st.findByUsername(username);
        
        getnom.setText(u.getNom_terrain());
        gettype.setText(u.getType_terrain());
        getdescrip.setText(u.getDescription_terrain());        
        getadresse.setText(u.getAdresse_terrain());
      
    }

    @FXML
    private void reservation(ActionEvent event) {
         terrain u = new terrain();
         u.setNom_terrain(getnom.getText());
            st.reserver(u);
        Serviceterrain tt = new Serviceterrain();
        lt = tt.afficherDispo();
             tableterrain.getItems().clear();
          ObservableList<terrain> datalist = FXCollections.observableArrayList(lt);
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom_terrain"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_terrain"));
        description.setCellValueFactory(new PropertyValueFactory<>("description_terrain"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_terrain"));
        
        //System.out.println(lt);
        tableterrain.setItems(datalist);
         Serviceterrain ss = new Serviceterrain();
         int nbtt= ss.nb_terrain(lt);
        nbt.setText(String.valueOf(nbtt));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("vous avez reservé le terrain :"+getnom.getText());
            alert.show();
         
    }
ObservableList<equipe> data = FXCollections.observableArrayList();
    @FXML
    private void searchmethode(KeyEvent event) {
        FilteredList<equipe> filtereddata = new FilteredList<equipe>(data, b -> true);
        
        search_button1.textProperty().addListener((observable, oldvalue, newValue) -> {
            filtereddata.setPredicate(ter -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;                    
                }
                String lowercasefilter = newValue.toLowerCase();
                if (ter.getNom_equipe().toLowerCase().contains(lowercasefilter)) {
                    return true;
                } else if (ter.getType_equipe().toLowerCase().contains(lowercasefilter)) {
                    return true;
                } else if (ter.getDescription_equipe().toLowerCase().contains(lowercasefilter)) {
                    return true;
                } else if (ter.getMail_equipe().toLowerCase().contains(lowercasefilter)) {
                    return true;
                }else {
                    return false;
                }
                

            });

        });
        System.out.println(data);
        SortedList<equipe> sorteddata = new SortedList<>(filtereddata);
        sorteddata.comparatorProperty().bind(tableEquipe.comparatorProperty());
        tableEquipe.setItems(filtereddata);
        Serviceequipe tt = new Serviceequipe();
          List<equipe> ltt = tt.rechercheequipe(search_button1.getText());
          tableEquipe.getItems().clear();
          ObservableList<equipe> datalist1 = FXCollections.observableArrayList(ltt);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
         Serviceequipe ss1 = new Serviceequipe();
    }

    @FXML
    private void tri_on_clicked(ActionEvent event) {
        Serviceequipe tt = new Serviceequipe();
          List<equipe> ltt = tt.TrierParnom();
          tableEquipe.getItems().clear();
          for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
             ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
    }

    @FXML
    private void showchart(ActionEvent event) {
        try {
            
            FXMLLoader chart= new FXMLLoader(getClass().getResource("chart.fxml"));
            Parent root = chart.load();
            ChartController mc = chart.getController();
            //System.out.println("aslema");
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            modifStage.setTitle("Hello World!");
            modifStage.setScene(scene);
            modifStage.show();
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(terrainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterEquipe(ActionEvent event) {
        if ((getNom_equipe.getText().equals(""))||(getType_equipe.getText().equals(""))||(getDescription_equipe.getText().equals(""))||(getMail_equipe.getText().equals(""))||(getNbre_equipe.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();}
        else if(!( Pattern.matches("[0-15]*",getNbre_equipe.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("nombre de joueur  doit etre de type Int !");
            alert.showAndWait();}
        else if(!( Pattern.matches("[a-zA-Z]*",getNom_equipe.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("nom d'equipe doit etre de type String !");
            alert.showAndWait();}
        else if(!( Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",getMail_equipe.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("mail doit contenir un @ !");
            alert.showAndWait();}
        else{ 
    Serviceequipe sp= new Serviceequipe();
        String nomAjout = getNom_equipe.getText();
        String typeAjout =getType_equipe.getText();
        String descriptionAjout =getDescription_equipe.getText();
        String mailAjout =getMail_equipe.getText();
        int nbreAjout =Integer.parseInt(getNbre_equipe.getText());
         
        
        equipe t = new equipe(nomAjout,typeAjout,descriptionAjout,mailAjout,nbreAjout);
        
        
            sp.ajouter(t);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("equipe ajouté!");
            alert.show();
            getNom_equipe.setText("");
            getType_equipe.setText("");
            getDescription_equipe.setText("");
            getMail_equipe.setText("");
            getNbre_equipe.setText("");
            Serviceequipe tt = new Serviceequipe();
             List<equipe> ltt = tt.afficher();
             tableEquipe.getItems().clear();
             String email = t.getMail_equipe();
            
                String cn = "Votre Equipe:"+t.getNom_equipe()+"a ete bien enregistrer";

                String sb = "Confirmation d'Ajout equipe";
                SendMail.sendMail(email, sb, cn);
                for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
             ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
           
          
//          Serviceterrain ss = new Serviceterrain();
//          int nbtt= ss.nb_terrain(ltt);
//          nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_terrainNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
        }
    }

    @FXML
    private void reloadd1(ActionEvent event) {
        Serviceequipe tt = new Serviceequipe();
        lm = tt.afficher();
             tableterrain.getItems().clear();
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify= new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button[i] = new Button("", modify);
    ImageView supprimer = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb[i] = new Button("", supprimer);
           lm.get(i).setModifier(modify_button[i]);
            lm.get(i).setSupprimer(supprimerb[i]);
            supprimerb[i].setOnAction(this::handleButtonAction1);
           modify_button[i].setOnAction(this::modifierButtonAction1);
      }
             ObservableList<equipe> datalist1 = FXCollections.observableArrayList(lm);
        
          nom_equipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        type_equipe.setCellValueFactory(new PropertyValueFactory<>("type_equipe"));
        description_equipe.setCellValueFactory(new PropertyValueFactory<>("description_equipe"));
        mail_equipe.setCellValueFactory(new PropertyValueFactory<>("mail_equipe"));
        nbre_equipe.setCellValueFactory(new PropertyValueFactory<>("nbre_joueur"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        //System.out.println(lm);
        tableEquipe.setItems(datalist1);
        
    }
}