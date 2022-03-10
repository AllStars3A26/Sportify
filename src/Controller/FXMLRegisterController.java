/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Adhérent;
import Services.UserUtiles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Services.UtilisateurService;
import com.github.sarxos.webcam.Webcam;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLRegisterController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_ad;
    @FXML
    private TextField tf_login;
    @FXML
    private TextField tf_pass;
    @FXML
    private TextField tf_email;
    @FXML
    private TextArea tf_description;
   Stage Stage3;
    @FXML
    private ImageView arrow_back;
    @FXML
    private TextField tf_pass1;
    /**
     * Initializes the controller class.
     */
    UserUtiles uUtiles = new UserUtiles();
    @FXML
    private Button photo_bouton;
    @FXML
    private Label label_photo;
    String filePhotoEnt = null;
    File filePhotoEntFile = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void alert_Box(String title, String message) {
	Alert dg = new Alert(Alert.AlertType.WARNING);
	dg.setTitle(title);
	dg.setContentText(message);
	dg.show();
    }
    @FXML
    private void register(ActionEvent event) {
        UtilisateurService us = new UtilisateurService();
                String PenomAjout = tf_nom.getText();
        String NomAjout =tf_prenom.getText();
        String AdresseAjout =tf_ad.getText();
        String LoginAjout =tf_login.getText();
        String PasswordAjout = tf_pass.getText();
        String PassworddAjout = tf_pass1.getText();
        String emailAjout =tf_email.getText();
        String DescriptionAjout =tf_description.getText();
 
 
         if (PenomAjout.isEmpty() || NomAjout.isEmpty() || LoginAjout.isEmpty() ) {
	    alert_Box("Verification", "Votre nom/prenom/username ne doit pas être vide");
	}else if (us.verifierUsername(LoginAjout)) {
	    alert_Box("Verifier ", "veillez saisir un username non existant");
	}else if (!uUtiles.testEmail(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse mail valide");
	} else if (us.verifierEmailBd(emailAjout)) {
	    alert_Box("Verifier votre mail", "veillez saisir une adresse non existant");
	}else if (!PasswordAjout.equals(PassworddAjout)) {
	    alert_Box("Verifier mot de passe", "Veillez verifier votre mot de passe ");
	}else{
            
        Adhérent A =new Adhérent(tf_nom.getText(),tf_prenom.getText(), tf_ad.getText(),tf_login.getText(), tf_pass.getText(),1,filePhotoEnt,tf_email.getText(),tf_description.getText());
        us.ajouterUtilisateur(A);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Adhérent Ajouté!");
            alert.show(); 
                                Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
            Stage3 = (Stage)((Node)event.getSource()).getScene().getWindow();
              root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage3.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage3.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        
                        Stage3.setScene(scene);
                        Stage3.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }
    }
    @FXML
    private void back_tologin(MouseEvent event) {
                                  Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin.fxml"));
            Stage3 = (Stage)((Node)event.getSource()).getScene().getWindow();
                          root.setOnMousePressed(pressEvent -> {
                        root.setOnMouseDragged(dragEvent -> {
        Stage3.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
        Stage3.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
    });
});
                        Scene  scene = new Scene(root);
                        Stage3.setScene(scene);
                        Stage3.show();
        } catch (IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterphoto(ActionEvent event) {
        	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Images files", "jpeg");
	chooser.setFileFilter(filter);
	chooser.showOpenDialog(null);
	filePhotoEnt = chooser.getSelectedFile().getName();
	filePhotoEntFile = chooser.getSelectedFile();
	label_photo.setText(filePhotoEnt);
    }

    @FXML
    private void takephoto(MouseEvent event) throws IOException {
        String code_random = code_random();

	Webcam webcam = Webcam.getDefault();
	webcam.open();
	String filename = "";
	filename = code_random + "_" + tf_login.getText() + ".jpeg";
	ImageIO.write(webcam.getImage(), "JPG", new File("Images/" + filename));
	filePhotoEnt = filename;
	webcam.close();

    }
    private String code_random() {

	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		+ "0123456789"
		+ "abcdefghijklmnopqrstuvxyz";

	// create StringBuffer size of AlphaNumericString 
	StringBuilder sb = new StringBuilder(4);

	for (int i = 0; i < 4; i++) {

	    // generate a random number between 
	    // 0 to AlphaNumericString variable length 
	    int index
		    = (int) (AlphaNumericString.length()
		    * Math.random());

	    // add Character one by one in end of sb 
	    sb.append(AlphaNumericString
		    .charAt(index));
	}

	return sb.toString();
    }
    
}
