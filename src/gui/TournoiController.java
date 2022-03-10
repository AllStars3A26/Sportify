/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Entities.match;
import Entities.tournoi;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import Services.ServiceMatch;
import Services.ServiceTournoi;
import javafx.scene.Node;
import tools.MaConnexion;
import tools.Mail_rec;

/**
 * FXML Controller class
 *
 * @author Sahar Zouari
 */
public class TournoiController implements Initializable {
  private Desktop desktop = Desktop.getDesktop();
    @FXML
    private Circle photo;
    @FXML
    private Label nbt;
    @FXML
    private TableView<tournoi> tableTournoi;
    @FXML
    private TableColumn<tournoi, String> NOM;
    @FXML
    private TableColumn<tournoi,Integer> NB_MAX;
    @FXML
    private TableColumn<tournoi,ImageView> IMAGE;
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
    private TextField getP3;
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
    private TableView<match> tableMatch;
    @FXML
    private TableColumn<match,Integer> EQUIPE1M;
    @FXML
    private TableColumn<match,Integer> EQUIPE2M;
    @FXML
    private TableColumn<match,Date> DATEM;
    @FXML
    private TableColumn<match,Integer> RESULTATM;
    
    @FXML
    private TableColumn<match,Button> MODIFIER1;
    @FXML
    private TableColumn<match,Button> SUPPRIMER1;
    @FXML
    private TableColumn<match,Integer> ID1;
    @FXML
    private Button reload1;
    @FXML
    private TextField getEquipe1;
    @FXML
    private TextField getEquipe2;
    @FXML
    private Button ajouterMatch;
    @FXML
    private DatePicker getDate_match;
    @FXML
    private TableColumn<tournoi,Integer> RESULTAT;
            private TextField getResultat;
    @FXML
    private Button home;
    @FXML
    private Button equipe;
    @FXML
    private Button tournoi;
    @FXML
    private Button seance;
    @FXML
    private Button evenement;
    @FXML
    private Button produit;
    @FXML
    private Button signout;
    @FXML 
            private VBox menu;
    @FXML
            private AnchorPane anchorr;
    @FXML
            private TabPane tabp;
    int modee=1;
   
      public static final String ACCOUNT_SID = "AC6cba527d728e15afa4914a88f33e1800";
    public static final String AUTH_TOKEN = "ef4d8471fb53b323f88be4863caeba73";
    @FXML
    void sms(ActionEvent event) {
              
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new com.twilio.type.PhoneNumber("+21650745839"),
                new com.twilio.type.PhoneNumber("+16626678504"),
                " votre demande est confirmée " ).create();

        System.out.println(message.getSid());
    
    }
    
    @FXML
    void mode(ActionEvent event) {
        modee++;
        if(modee%2==0)
        {
          home.getStyleClass().add("button4");
          equipe.getStyleClass().add("button4");
          produit.getStyleClass().add("button4");
          tournoi.getStyleClass().add("button4");
          seance.getStyleClass().add("button4");
          evenement.getStyleClass().add("button4");
          signout.getStyleClass().add("button4");
          menu.setBackground(new Background(new BackgroundFill(Color.rgb(56,56,56),CornerRadii.EMPTY,Insets.EMPTY)));
          tableTournoi.getStyleClass().add("table-view1");
          tableMatch.getStyleClass().add("table-view1");
          anchorr.setBackground(new Background(new BackgroundFill(Color.rgb(210,210,210),CornerRadii.EMPTY,Insets.EMPTY)));
          tabp.getStyleClass().add("tab-pane1");
        }
        else  if(modee%2==1)
        {
             home.getStyleClass().clear();
          equipe.getStyleClass().clear();
          produit.getStyleClass().clear();
          tournoi.getStyleClass().clear();
          seance.getStyleClass().clear();
          evenement.getStyleClass().clear();
          signout.getStyleClass().clear();
            home.getStyleClass().add("button");
          equipe.getStyleClass().add("button");
          produit.getStyleClass().add("button");
          tournoi.getStyleClass().add("button");
          seance.getStyleClass().add("button");
          evenement.getStyleClass().add("button");
          signout.getStyleClass().add("button");
           menu.setBackground(new Background(new BackgroundFill(Color.rgb(11,12,121),CornerRadii.EMPTY,Insets.EMPTY)));
          tableTournoi.getStyleClass().clear();
           tableTournoi.getStyleClass().add("table-view");
          tableMatch.getStyleClass().clear();
          tableMatch.getStyleClass().add("table-view");
          anchorr.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),CornerRadii.EMPTY,Insets.EMPTY)));
          tabp.getStyleClass().clear();
           tabp.getStyleClass().add("tab-pane");
        }
    }
   


    
    @FXML
    void reloadd(ActionEvent event) {
            ServiceTournoi tt = new ServiceTournoi();
        lt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(lt);
          ServiceTournoi ss = new ServiceTournoi();
         int nbtt= ss.nb_tournoi(lt);
        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
    }
    @FXML
     void reloadd1(ActionEvent event) {
            ServiceMatch tt = new ServiceMatch();
        lm = tt.afficher();
             tableMatch.getItems().clear();
          afficher_match(lm);
//          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
    }

    
      ServiceTournoi st = new ServiceTournoi();
     List<tournoi> lt = st.afficher();
     ServiceMatch sm = new ServiceMatch();
     List<match> lm = sm.afficher();
     
     
     
    
    Button[] modify_button = new Button[lt.size()];
       Button[] supprimerb = new Button[lt.size()];
       Button[] modify_button1 = new Button[lm.size()];
       Button[] supprimerb1 = new Button[lm.size()];
        int index=101; 
         
          private void handleButtonAction1 (ActionEvent event)
    {
       
         for (int i = 0; i < lm.size(); i++) {
            // Button a = supprimerb[i];
            
             if (event.getSource() == supprimerb1[i])
             {
                 index=i;
             }
            
                 
         }
          System.out.println(index);
          int index1 = lm.get(index).getId_match();
            ServiceMatch tm = new ServiceMatch();
            
             tm.supprimer(index1);
             lm = tm.afficher();
             tableMatch.getItems().clear();
          afficher_match(lm);
          //ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
     }
       private void modifierButtonAction1 (ActionEvent event)
    {
        try {
            
            FXMLLoader modif= new FXMLLoader(getClass().getResource("modifierMatch.fxml"));
            Parent root = modif.load();
            ModifierMatchController mcc = modif.getController();
            for (int i = 0; i < lm.size(); i++) {
            if (event.getSource() == modify_button1[i])
             {
                 index=i;
             }}
            System.out.println(index);
            int index1 = lm.get(index).getId_match();
            String s=String.valueOf(index1);
            System.out.println(s);
            mcc.setTextID(s);
            mcc.setItems(index1);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("modifier!");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                ServiceMatch tt = new ServiceMatch();
                lm = tt.afficher();
             tableMatch.getItems().clear();
          afficher_match(lm);
//          ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lm);
//        nbt.setText(String.valueOf(nbt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
                       
                   modifStage.setScene(null);
                   modifStage.close();
             
             
              });
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
        
        
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
         int nbtt= ss.nb_tournoi(lt);
        nbt.setText(String.valueOf(nbtt));
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
            
            modifStage.setTitle("Modifier Tournoi");
            modifStage.setScene(scene);
            modifStage.show();
            modifStage.setOnHidden(e -> {
                ServiceTournoi tt = new ServiceTournoi();
                List<tournoi> ltt = tt.afficher();
             tableTournoi.getItems().clear();
          afficher_tournoi(lt);
          ServiceTournoi ss = new ServiceTournoi();
         int nbtt= ss.nb_tournoi(lt);
        nbt.setText(String.valueOf(nbt));
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
      tableTournoi.setOnMouseClicked(ev -> {
              
                  
          if (ev.getButton().equals(MouseButton.PRIMARY) && ev.getClickCount() == 2) {
                String nom_p = tableTournoi.getSelectionModel().getSelectedItem().getNom_tournoi();
                 int  nb_p = tableTournoi.getSelectionModel().getSelectedItem().getNb_participants();
                int resultat = tableTournoi.getSelectionModel().getSelectedItem().getResultat_tournoi();
             
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
             String strDate = dateFormat.format(tableTournoi.getSelectionModel().getSelectedItem().getDate_tournoi()); 
                int heure = tableTournoi.getSelectionModel().getSelectedItem().getHeure();
               
                String AllInfo = " nom tournoi :       " + nom_p + "\nRésultat:       " + resultat +  "\nNb_participants:         " + nb_p +"\n  Date:          "+strDate+" à "+heure+"h";
                ////////////////////////:
               QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
           
            int width = 300;
            int height = 300;
            
            BufferedImage bufferedImage = null;
            try {
                BitMatrix byteMatrix = qrCodeWriter.encode(AllInfo, BarcodeFormat.QR_CODE, width, height);
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                bufferedImage.createGraphics();
                
                Graphics2D image = (Graphics2D) bufferedImage.getGraphics();
                image.setColor(java.awt.Color.WHITE);
                image.fillRect(0, 0, width, height);
                image.setColor(java.awt.Color.BLACK);
                
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (byteMatrix.get(i, j)) {
                            image.fillRect(i, j, 1, 1);
                        }
                    }
                }
                
                System.out.println("QR created successfully....");
                
            } catch (WriterException ex) {
                 //Todo
            }
            
            ImageView qr = new ImageView();
            qr.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
            
            StackPane obj = new StackPane();
            obj.getChildren().add(qr);
            Scene scene = new Scene(obj, 300, 250);
            Stage p1 = new Stage();
            p1.setTitle("QRCode");
            p1.setScene(scene);
            p1.show();
            WritableImage writableImage = new WritableImage(300,250);
                scene.snapshot(writableImage);
                File imageFile = new File("screenshotqr/screenshot.png");
              try {
                  ImageIO.write(bufferedImage,"png", imageFile);
              } catch (IOException ex) {
                  Logger.getLogger(TournoiController.class.getName()).log(Level.SEVERE, null, ex);
              }
                   
                }
            
              
        });

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
        for (int i = 0; i < lm.size(); i++) {
            ImageView modify1 = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button1[i] = new Button("", modify1);
    ImageView supprimer1 = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb1[i] = new Button("", supprimer1);
            lm.get(i).setModifier(modify_button1[i]);
             lm.get(i).setSupprimer(supprimerb1[i]);
           supprimerb1[i].setOnAction(this::handleButtonAction1);
            modify_button1[i].setOnAction(this::modifierButtonAction1);
        }
        
       ObservableList<match> datalistt = FXCollections.observableArrayList(lm);
        
        EQUIPE1M.setCellValueFactory(new PropertyValueFactory<>("id_equipe1"));
        EQUIPE2M.setCellValueFactory(new PropertyValueFactory<>("id_equipe2"));
        DATEM.setCellValueFactory(new PropertyValueFactory<>("date_match"));
        RESULTATM.setCellValueFactory(new PropertyValueFactory<>("resultat_match"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_match"));
        System.out.println(lm);
        tableMatch.setItems(datalistt);
//         ServiceTournoi ss = new ServiceTournoi();
//         int nbtt= ss.nb_tournoi(lt);
//        nbt.setText(String.valueOf(nbtt));
        
         ObservableList<tournoi> datalist = FXCollections.observableArrayList(lt);
      
       
          NOM.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi"));
        DATE.setCellValueFactory(new PropertyValueFactory<>("date_tournoi"));
        RESULTAT.setCellValueFactory(new PropertyValueFactory<>("resultat_tournoi"));
        NB_MAX.setCellValueFactory(new PropertyValueFactory<>("nb_participants"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("img"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));
        System.out.println(lt);
        tableTournoi.setItems(datalist);
         ServiceTournoi ss = new ServiceTournoi();
         int nbtt= ss.nb_tournoi(lt);
        nbt.setText(String.valueOf(nbtt));
           nbt1.setText(String.valueOf(lm.size()));
    }    

   
   


  
    @FXML
    private void showchart(ActionEvent event) {
        try {
            ObservableList<tournoi> data=FXCollections.observableArrayList(lt);
            FXMLLoader chart= new FXMLLoader(getClass().getResource("chart1.fxml"));
            Parent root = chart.load();
            Chart1Controller mc = chart.getController();
          
        mc.setReclamationData(data);
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Statistiques");
            modifStage.setScene(scene);
            modifStage.show();
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TournoiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void ajouterMatch(ActionEvent event) {
        
         if ((getEquipe1.getText().equals(""))||(getEquipe2.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Il faut taper le nom !");
       }
       
       else if(!( Pattern.matches("[0-9]*",getEquipe1.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Equipe1  doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",getEquipe2.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Equipe2 doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
       else{
         ServiceMatch sm= new ServiceMatch();
        
        int equipe1ajout = Integer.parseInt(getEquipe1.getText());
        int equipe2ajout = Integer.parseInt(getEquipe2.getText());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date dateajout = Date.from(getDate_match.getValue().atStartOfDay(defaultZoneId).toInstant());
       
        
        match p = new match(equipe1ajout,equipe2ajout,dateajout,0);
        
        
            sm.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Match ajouté!");
            alert.show();
            getEquipe1.setText("");
            getEquipe2.setText("");
            
            
            ServiceMatch tm = new ServiceMatch();
             lm = tm.afficher();
             tableMatch.getItems().clear();
          afficher_match(lm);
          //ServiceTournoi ss = new ServiceTournoi();
//          int nbtt= ss.nb_tournoi(ltt);
        nbt1.setText(String.valueOf(lm.size()));
//        int nbttt= ss.nb_tournoiNonjoue();
  //     nbtnj.setText(String.valueOf(lm.size()));
    }}

    
    @FXML
    private void ajouterTournoi(ActionEvent event) {
        //////////////////
        
        if ((getNom_tournoi.getText().equals(""))||(getNb_max.getText().equals(""))||(getP3.getText().equals(""))||(getheure_tournoi.getText().equals("")))
       {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("champs manquants !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Il faut taper le nom !");
       }
       
       else if(!( Pattern.matches("[a-z,A-Z]*",getNom_tournoi.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Nom  doit etre de type String !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",getNb_max.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("NB_max doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
         else if(!( Pattern.matches("[0-9]*",getP3.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Resultat doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else if(!( Pattern.matches("[0-9]*",getheure_tournoi.getText()))){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Heure doit etre de type Int !");
            alert.showAndWait();
           //JOptionPane.showMessageDialog(null, "Nom de la catégorie doit etre de type String! !");
       }
        else {
        
        /////////////////////
        
        ServiceTournoi sp= new ServiceTournoi();
        String nomAjout = getNom_tournoi.getText();
        int nb_participantsAjout = Integer.parseInt(getNb_max.getText());
        
        int resultatAjout = Integer.parseInt(getP3.getText());
        
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
//          ServiceTournoi ss = new ServiceTournoi();
//          int nbtt= ss.nb_tournoi(ltt);
//          nbt.setText(String.valueOf(nbtt));
//        int nbttt= ss.nb_tournoiNonjoue();
//        nbtnj.setText(String.valueOf(nbttt));
         
        }
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
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("img"));
        MODIFIER.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id_tournoi"));

        tableTournoi.setItems(datalist);
        ServiceTournoi ss = new ServiceTournoi();
          int nbtt= ss.nb_tournoi(ltt);
          nbt.setText(String.valueOf(nbtt));
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
    public void afficher_match(List<match> ltt)
    {
        for (int i = 0; i < ltt.size(); i++) {
            ImageView modify1 = new ImageView(new Image(getClass().getResourceAsStream("../images/edit_property_16px.png")));
         modify_button1[i] = new Button("", modify1);
    ImageView supprimer1 = new ImageView(new Image(getClass().getResourceAsStream("../images/not_sending_video_frames_16px.png")));
         supprimerb1[i] = new Button("", supprimer1);
            ltt.get(i).setModifier(modify_button1[i]);
             ltt.get(i).setSupprimer(supprimerb1[i]);
            supprimerb1[i].setOnAction(this::handleButtonAction1);
           modify_button1[i].setOnAction(this::modifierButtonAction1);
        }
       ObservableList<match> datalistt = FXCollections.observableArrayList(ltt);
        
         EQUIPE1M.setCellValueFactory(new PropertyValueFactory<>("id_equipe1"));
        EQUIPE2M.setCellValueFactory(new PropertyValueFactory<>("id_equipe2"));
        DATEM.setCellValueFactory(new PropertyValueFactory<>("date_match"));
        RESULTATM.setCellValueFactory(new PropertyValueFactory<>("resultat_match"));
        MODIFIER1.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        SUPPRIMER1.setCellValueFactory(new PropertyValueFactory<>("supprimer"));
        ID1.setCellValueFactory(new PropertyValueFactory<>("id_match"));
         nbt1.setText(String.valueOf(lm.size()));
        tableMatch.setItems(datalistt); 
         ServiceMatch tm = new ServiceMatch();
        lm = tm.afficher();
             tableMatch.getItems().clear();
          afficher_match(lm);
    }
    
      @FXML
    public void exportExcel() throws FileNotFoundException, IOException, SQLException{
Connection cnx = MaConnexion.getInstance().getCnx();
        String query = "select p.*,t.nom_tournoi,e.nom_equipe from tournoi t ,equipe e,participants_tournoi p WHERE (p.id_tournoi=t.id_tournoi) AND (p.id_equipe=e.id_equipe)";
         PreparedStatement pst = cnx.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Détails Activités");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("id_tournoi");
            header.createCell(1).setCellValue("nom_tournoi");
            header.createCell(2).setCellValue("id_equipe");
            header.createCell(3).setCellValue("nom_equipe");
            
            int index = 1;
            while(rs.next()){
                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(String.valueOf(rs.getInt("id_tournoi")));
                row.createCell(1).setCellValue(rs.getString("nom_tournoi"));
                row.createCell(2).setCellValue(String.valueOf(rs.getInt("id_equipe")));
                row.createCell(3).setCellValue(rs.getString("nom_equipe"));
                index++;
            }
            
            FileOutputStream file = new FileOutputStream("Détails Activités.xlsx");
            wb.write(file);
            file.close();
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Exportation effectuée!!!");
            alert.showAndWait();
            pst.close();
            rs.close();
            
            File myfFile = new File("C:/Users/Lenovo/Documents/NetBeansProjects/PidevProjectworkReal/Détails Activités.xlsx");
            Desktop.getDesktop().open(myfFile);
           
    }

    @FXML
    private void home_return(ActionEvent event) {
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
    private void skander(ActionEvent event) {
          try {
           Parent root = FXMLLoader.load(getClass().getResource("/gui/terrain.fxml"));
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
    private void sign_out(ActionEvent event) {
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
   
}
