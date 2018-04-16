/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.pkg5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kristina
 */
public class Projekt5 extends Application {
    
     Connection conn = null;
    private static final String driverClass = "com.mysql.jdbc.Driver";
   // private static final String connectionDescriptor = "jdbc:mysql://i-med-ts:3306;databasename=mdprojekt";
    private static final String connectionDescriptor = "jdbc:mysql://i-med-ts:3306/md_projekt";
    private static String user= "kozonakis";
    private static String password= ".kozonakis%";
     
     public static Connection connectdb() {
        try {
         
            Connection conn = DriverManager.getConnection(connectionDescriptor, user,password);
            System.out.println("Connected!"  );
            System.out.println(conn);
            return conn;
            
        }  catch (SQLException e) {
            System.out.print("Database error: " + e.getMessage());
        }
        ;
        return null;
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}