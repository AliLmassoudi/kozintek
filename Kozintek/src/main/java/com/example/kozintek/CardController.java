package com.example.kozintek;

import io.github.gleidson28.GNAvatarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardController {

    @FXML
    private Text firstname1;
    @FXML
    private Text lastname1;
    @FXML
    private Text age1;
    @FXML
    private Text city1;
    @FXML
    private Text score1;
    @FXML
    private Text pricing1;
    @FXML
    private Text rank1;
    @FXML
    private Text reviews1;
    @FXML
    private GNAvatarView image1;
    @FXML
    private ImageView stars;
    @FXML
    private Rectangle monday1;
    @FXML
    private Rectangle tuesday1;
    @FXML
    private Rectangle wednesday1;
    @FXML
    private Rectangle thursday1;
    @FXML
    private Rectangle friday1;
    @FXML
    private Rectangle saturday1;
    @FXML
    private Rectangle sunday1;
    @FXML
    private Rectangle cleaning;
    @FXML
    private Rectangle cooking;
    @FXML
    private Rectangle baby;
    @FXML
    private Button showButton;

    private Stage stage ;
    private Scene scene ;
    private Parent root ;



    public void setSkills( String[] Skills ) throws Exception {
        int y = 0 ;
        Rectangle[] skills = { cleaning , cooking , baby };
        for ( Rectangle skill : skills ){
            if ( Skills[y].equals("0")){
                skill.setStyle("-fx-opacity:0.5;");
                y ++ ;
            }else {
                skill.setStyle("-fx-opacity:1;");
                y ++ ;
            }
        }
    }
    public void setDays( String[] WorkDays ) throws Exception {
        int i = 0 ;
        Rectangle[] rectangles = {monday1, tuesday1, wednesday1, thursday1, friday1, saturday1, sunday1};
        for (Rectangle day : rectangles) {
            if ( WorkDays[i].equals("0")){
                day.setStyle("-fx-opacity:0.5;");
                i ++ ;
            }else {
                day.setStyle("-fx-opacity:1;");
                i ++ ;
            }
        }
    }
    public void setStars( Float nbr ) throws Exception {

        ArrayList<Image> starsList = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            starsList.add(new Image("file:src/main/resources/assets/Icons/stars/stars" + i + ".png"));
        }

        if (nbr < 1) {
            stars.setImage(starsList.get(1));
        } else if (nbr > 1 && nbr < 2) {
            stars.setImage(starsList.get(2));
        } else if (nbr > 2 && nbr < 3) {
            stars.setImage(starsList.get(4));
        } else if (nbr > 3 && nbr < 4) {
            stars.setImage(starsList.get(7));
        } else if (nbr > 4 && nbr < 5) {
            stars.setImage(starsList.get(8));
        } else if (nbr == 5) {
            stars.setImage(starsList.get(10));
        } else if (nbr == 4) {
            stars.setImage(starsList.get(9));
        } else if (nbr == 3) {
            stars.setImage(starsList.get(6));
        } else if (nbr == 2) {
            stars.setImage(starsList.get(5));
        } else if (nbr == 1) {
            stars.setImage(starsList.get(3));
        }
    }
    public void setInfos(String first,String last,Integer age,Float score,String city,Float pricing,Integer rank,Integer reviews) {
        firstname1.setText(first);
        lastname1.setText(last);
        age1.setText(age+ " Yo");
        score1.setText(score.toString());
        city1.setText(city);
        pricing1.setText(pricing.toString());
        rank1.setText(rank.toString());
        reviews1.setText(reviews.toString() +" Reviews");
    }
    public void setImage(Blob imageBlob) throws SQLException {
        byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
        Image imageresult = new Image(new ByteArrayInputStream(imageData));
        image1.setImage(imageresult);
    }
    public void ShowProfile(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("HSProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =  new Scene(root);
        stage.setScene(scene);
        stage.show();

        HSProfileController ctrl = loader.getController();

    }

}
