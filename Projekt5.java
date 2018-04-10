/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt5;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 *
 * @author kozonakis
 */
public class Projekt5 extends Application {
    
           public static Connection c= null;

    
    //private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String driverClass = "com.mysql.jdbc.Driver";
   // private static final String connectionDescriptor = "jdbc:mysql://i-med-ts:3306;databasename=mdprojekt";
    private static final String connectionDescriptor = "jdbc:mysql://i-med-ts:3306/md_projekt";
    private static String user= "kozonakis";
    private static String password= ".kozonakis%";
 //  ("jdbc:mysql://localhost:3306/tnpcb","root","");

    
   
    
    
    public static Projekt5 connectdb () {
        try{
			c = DriverManager.getConnection(connectionDescriptor, user,password);
                        System.out.println("Connection");
                        return (Projekt5) c;
                        
                }
            
		catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("A database error occured.");
			alert.showAndWait();
                        return null;

		} 
                              
    }
    @Override
      public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
          System.out.println("Scene Builder");     
       Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}
