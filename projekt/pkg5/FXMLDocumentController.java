/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt5;

import java.io.IOException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projekt.pkg5.Projekt5;

/**
 *
 * @author Kristina
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
  //  private Label label;
    Connection conn = null;
    private static PreparedStatement getUser = null;
    private static ResultSet rs = null;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPassword;
    @FXML
    private Label nameLabel;
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    Stage loginStage = new Stage();
    Scene scene;

    public FXMLDocumentController (){
    conn= Projekt5.connectdb();
    
    }
 
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       // System.out.println("You clicked me!");
        //label.setText("Hello World!");
        String role = "";
        String Name = textName.getText();
         System.out.println("Text " + Name );
        
         String Password = textPassword.getText();
        System.out.println("Password! " + Password );
        String sql = "SELECT * "+ " FROM user_tab " + " WHERE user_id = ? and pw = ? ";
     
        System.out.println("SQL");
          try 
        {
             System.out.println("try1");
            getUser  = conn.prepareStatement(sql);
            
          
             System.out.println("SQL" + getUser);
            getUser.setString (1, Name);
             System.out.println("try3" + getUser );
            getUser .setString (2, Password);
            System.out.println("try4" + getUser );
            
            
            rs  = getUser.executeQuery();
            System.out.println("try5" );
        
            if (rs.next())
            {
                System.out.println("try6"  );
                String name = rs.getString("user_id");
                System.out.println("try7"  );
                String pw = rs.getString("pw");
                role=rs.getString(3);
                System.out.println("Role " + role);
                
             if (role.equals("Dr.")){
                 System.out.println("halloooo Dr." + name);
             }
             else if (role.equals("Nurse")){
                //neues fenster für die Nurse
                 System.out.println("halloooo Nurse " + name);
                 
                 Node node= (Node)event.getSource();
                 loginStage=(Stage) node.getScene().getWindow();
                 loginStage.close();
                 
                 
                 Parent root = FXMLLoader.load(getClass().getResource("FXMLNurse.fxml"));

                 Scene scene = new Scene(root);
        
                 loginStage.setScene(scene);
                 loginStage.show();
                 

             }
             
             }
            else {
                 Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Log in failed");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a correct username and password");
            alert.showAndWait();
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}