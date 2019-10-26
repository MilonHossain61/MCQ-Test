package com.ridoy.mcq;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultMessageController  {

    @FXML
    public Label resultLabel;
    
    public void dashboardelements(int point) {
        resultLabel.setText("Correct Result:  " +  Integer.toString(point));
    }  

    @FXML
    private void handleMainMenu(ActionEvent event) throws IOException {
        
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        TestController testRes = new TestController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
        
        
    }

    

}