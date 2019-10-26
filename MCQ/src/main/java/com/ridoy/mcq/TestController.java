package com.ridoy.mcq;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestController implements Initializable {

    @FXML
    private Label ques1;
    @FXML
    private ToggleGroup q1;
    @FXML
    private ToggleGroup q2;
    @FXML
    private ToggleGroup q3;
    @FXML
    private ToggleGroup q4;
    @FXML
    private ToggleGroup q5;
    @FXML
    private Label ques2;
    @FXML
    private Label ques3;
    @FXML
    private Label ques4;
    @FXML
    private Label ques5;
    @FXML
    private RadioButton qn14;
    @FXML
    private RadioButton qn13;
    @FXML
    private RadioButton qn12;
    @FXML
    private RadioButton qn11;
    @FXML
    private RadioButton qn24;
    @FXML
    private RadioButton qn23;
    @FXML
    private RadioButton qn22;
    @FXML
    private RadioButton qn21;
    @FXML
    private RadioButton qn34;
    @FXML
    private RadioButton qn33;
    @FXML
    private RadioButton qn32;
    @FXML
    private RadioButton qn31;
    @FXML
    private RadioButton qn44;
    @FXML
    private RadioButton qn43;
    @FXML
    private RadioButton qn42;
    @FXML
    private RadioButton qn41;
    @FXML
    private RadioButton qn54;
    @FXML
    private RadioButton qn53;
    @FXML
    private RadioButton qn52;
    @FXML
    private RadioButton qn51;
    ArrayList crr = new ArrayList();
    int [] array1 =new int[15];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    public void handleMainMenu(ActionEvent event)  throws SQLException, IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleLogout(ActionEvent event) throws IOException, SQLException {
        
    }

    @FXML
    public void handleStart(ActionEvent event) throws IOException, SQLException  {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Desktop/MCQ/src/main/resources/sqlite/db/test.db");
            ps = con.prepareStatement("SELECT * From questions  ");

            rs = ps.executeQuery();
            ArrayList arr = new ArrayList();
            ArrayList ans =new ArrayList();
            ArrayList ans1 =new ArrayList();
            ArrayList ans2 =new ArrayList();
            ArrayList ans3 =new ArrayList();
           
            while(rs.next()){
              int id = rs.getInt("id");
              String qs1 = rs.getString("ques");
              arr.add(qs1);
              String anss=rs.getString("ans");
              String anss1=rs.getString("ans1");
              String anss2=rs.getString("ans2");
              String anss3=rs.getString("ans3");
              String correct = rs.getString("correct");
              ans.add(anss);
              ans1.add(anss1);
              ans2.add(anss2);
              ans3.add(anss3);
              crr.add(correct);
                 
            }
          
        int [] array =new int[15];
        Random rand = new Random();

        for (int i=0; i<5; i++) {
            int random_integer = -1;

            while(exists(random_integer, array)) {
                random_integer = rand.nextInt(15);
            }

            array[i] = random_integer;
        }
        
            ques1.setText( (String)arr.get(array[0]));
            ques2.setText( (String)arr.get(array[1]));
            ques3.setText( (String)arr.get(array[2]));
            ques4.setText( (String)arr.get(array[3]));
            ques5.setText( (String)arr.get(array[4]));
            
            qn11.setText((String)ans.get(array[0]));
            qn12.setText((String)ans1.get(array[0]));
            qn13.setText((String)ans2.get(array[0]));
            qn14.setText((String)ans3.get(array[0]));
            
            qn21.setText((String)ans.get(array[1]));
            qn22.setText((String)ans1.get(array[1]));
            qn23.setText((String)ans2.get(array[1]));
            qn24.setText((String)ans3.get(array[1]));
            
            qn31.setText((String)ans.get(array[2]));
            qn32.setText((String)ans1.get(array[2]));
            qn33.setText((String)ans2.get(array[2]));
            qn34.setText((String)ans3.get(array[2]));
            
            qn41.setText((String)ans.get(array[3]));
            qn42.setText((String)ans1.get(array[3]));
            qn43.setText((String)ans2.get(array[3]));
            qn44.setText((String)ans3.get(array[3]));
            
            qn51.setText((String)ans.get(array[4]));
            qn52.setText((String)ans1.get(array[4]));
            qn53.setText((String)ans2.get(array[4]));
            qn54.setText((String)ans3.get(array[4]));
            
            
            ps.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
    public boolean exists(int number, int[] array) {
        if (number == -1)
            return true; 

        for (int i=0; i<array.length; i++) {
            if (number == array[i])
                return true;
        }
        return false;
    }
    int point =0;
    @FXML
    public void handleSubmit(ActionEvent event) throws IOException, SQLException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ResultMessage.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        
        
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Desktop/MCQ/src/main/resources/sqlite/db/test.db");
            ps = con.prepareStatement("SELECT * From questions  ");

            rs = ps.executeQuery();
            while(rs.next()){
              
              String correct = rs.getString("correct");
              
               if(qn11.isSelected())
               {
                if(qn11.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn12.isSelected())
               {
                if(qn12.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn13.isSelected())
               {
                if(qn13.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn14.isSelected())
               {
                if(qn14.getText().equals(correct))
                {
                    point++;
                }
               }
               
               
               if(qn21.isSelected())
               {
                if(qn21.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn22.isSelected())
               {
                if(qn22.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn23.isSelected())
               {
                if(qn23.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn24.isSelected())
               {
                if(qn24.getText().equals(correct))
                {
                    point++;
                }
               }
               
               if(qn31.isSelected())
               {
                if(qn31.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn32.isSelected())
               {
                if(qn32.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn33.isSelected())
               {
                if(qn33.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn34.isSelected())
               {
                if(qn34.getText().equals(correct))
                {
                    point++;
                }
               }
               
               if(qn41.isSelected())
               {
                if(qn41.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn42.isSelected())
               {
                if(qn42.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn43.isSelected())
               {
                if(qn43.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn44.isSelected())
               {
                if(qn44.getText().equals(correct))
                {
                    point++;
                }
               }
               
               
               if(qn51.isSelected())
               {
                if(qn51.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn52.isSelected())
               {
                if(qn52.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn53.isSelected())
               {
                if(qn53.getText().equals(correct))
                {
                    point++;
                }
               }
               if(qn54.isSelected())
               {
                if(qn54.getText().equals(correct))
                {
                    point++;
                }
               }
               
                 
            }
           
        
            
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println(point);
        
        Page pg = new Page();
        StackPane background = new StackPane();
        

       
        
        
        
        stage.setTitle("Main Menu");
        background.getChildren().add(pg.dashboardelements(point));
        scene = new Scene(background,400,250);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
        
        
      
    }

}
