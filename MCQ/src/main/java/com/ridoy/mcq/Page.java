package com.ridoy.mcq;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Page {
     public VBox dashboardelements(int point) {

        VBox primeV = new VBox(10);
        primeV.setPadding(new Insets(60,60,60,60));
        
        Label result = new Label();
        result.setText("Correct Result:  " +  Integer.toString(point));
        result.setTextFill(Color.RED);
        result.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        result.setAlignment(Pos.CENTER);
        
        Button Main = new Button("Main Menu");
        Main.setAlignment(Pos.CENTER);
        
        Main.setOnAction(e -> {
        
            try {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                Parent root;
                
                root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
        
        
        });
        
        
        primeV.getChildren().addAll(result,Main);

        return primeV;

    }


    
}
