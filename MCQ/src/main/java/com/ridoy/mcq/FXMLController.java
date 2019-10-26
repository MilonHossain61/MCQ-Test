package com.ridoy.mcq;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {


    @FXML
    private TextField uField;
    @FXML
    private PasswordField pField;
    
    @FXML
    private Label label;
    @FXML
    private Button clr;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    public void handleLogin(ActionEvent event) throws SQLException, IOException {
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Desktop/MCQ/src/main/resources/sqlite/db/test.db");
            ps = con.prepareStatement("SELECT * From students Where username = ? AND password = ? ");
            
            ps.setString(1, uField.getText());
            ps.setString(2, pField.getText());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Quick Test");
                stage.setScene(scene);
                stage.show();
            }
            else{
                label.setText("Wrong Password or Username");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void handleClear(ActionEvent event) {
        if(event.getSource()==clr){
            uField.setText("");
            pField.setText("");
        }
        else{
            
        }
    }
}