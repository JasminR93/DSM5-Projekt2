/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt5;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kozonakis
 */
public class FXMLDocumentController implements Initializable {

    Connection c=null;
    private static PreparedStatement getUser = null;
    private static ResultSet rs = null;
   @FXML
    private TextField textName;
   @FXML private TextField textPassword;
    @FXML
    private Label nameLabel;
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    public FXMLDocumentController (){
        c = (Connection) Projekt5.connectdb();
         System.out.println("querycheck");
    }
  
  

    @FXML
       public void loginApplication(ActionEvent event){
          
           String Name = textName.getText();
           String Password = textPassword.getText();
          
        String queryCheck = "SELECT * "+ "FROM user_tab " + " WHERE user_id = ? "+ " and pw = ?";
        
        

        try 
        {
            getUser  = c.prepareStatement(queryCheck);
            getUser.setString (1, Name);
            getUser .setString (2, Password);
            rs  = getUser.executeQuery();
            
            while (rs.next())
            {
             String name = rs.getString("user_id");
             String pw = rs.getString("pw");
             }
            
            
           
            
        
        }
        catch (SQLException e1) 
        {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("A database error occured.");
			alert.showAndWait();
        }
        
       }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
          


    
      
}
