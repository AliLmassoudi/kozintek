package com.example.kozintek;

import io.github.gleidson28.GNAvatarView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane HeaderAnchorPane;



    ObservableList<HousekeeperModel> HousekeeperObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);
        try {
            loadHeader();
            importHousekeepers();
            ShowCards();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowCards() throws Exception {

        int posX = 19;
        int posY = 52;

        Pane CARDS = new Pane();

        ArrayList<AnchorPane> anchorPanes = new ArrayList<>();
        ArrayList<CardController> cardControllers = new ArrayList<>();

        FXMLLoader loader = new FXMLLoader();
        CardController cardController = new CardController();

        for ( int i = 0 ; i < HousekeeperObservableList.size() ; i++) {
            anchorPanes.add(new AnchorPane ());
            anchorPanes.get(i).setPrefWidth(330);anchorPanes.get(i).setPrefHeight(270);
            anchorPanes.get(i).setLayoutX(posX);anchorPanes.get(i).setLayoutY(posY);

            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));
            anchorPanes.get(i).getChildren().add(loader.load());
            CARDS.getChildren().add(anchorPanes.get(i));
            cardController = loader.getController();

            writeCard(cardController,i);

            scrollPane.setContent(CARDS);
            posY = posY + 290 ;
        }
    }
    public void writeCard ( CardController ctrl , int i ) throws Exception {
        ctrl.setInfos(HousekeeperObservableList.get(i).firstname,HousekeeperObservableList.get(i).lastname,HousekeeperObservableList.get(i).age,HousekeeperObservableList.get(i).score,HousekeeperObservableList.get(i).city,HousekeeperObservableList.get(i).pricing,HousekeeperObservableList.get(i).ranking,HousekeeperObservableList.get(i).reviews);
        ctrl.setImage(HousekeeperObservableList.get(i).image);
        ctrl.setStars(HousekeeperObservableList.get(i).score);
        String WorkDays[] = { HousekeeperObservableList.get(i).monday,HousekeeperObservableList.get(i).tuesday,HousekeeperObservableList.get(i).wednesday,HousekeeperObservableList.get(i).thursday,HousekeeperObservableList.get(i).friday,HousekeeperObservableList.get(i).saturday,HousekeeperObservableList.get(i).sunday};
        ctrl.setDays(WorkDays);
        String Skills[] = { HousekeeperObservableList.get(i).cleaning,HousekeeperObservableList.get(i).cooking,HousekeeperObservableList.get(i).baby};
        ctrl.setSkills(Skills);
    }

    public void loadHeader() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Header.fxml"));
        HeaderAnchorPane.getChildren().add(loader.load());
    }



    public void importHousekeepers() throws Exception {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String HousekeeperVieweQuery = "SELECT id,firstname,lastname,age,ranking,reviews,monday,tuesday,wednesday,thursday,friday,saturday,sunday,cleaning,cooking,baby,email,city,score,pricing,image FROM Housekeepers";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(HousekeeperVieweQuery);

            while (queryOutput.next()) {

                Integer id = queryOutput.getInt("id");
                Integer age = queryOutput.getInt("age");
                Integer ranking = queryOutput.getInt("ranking");
                Integer reviews = queryOutput.getInt("reviews");

                String firstname = queryOutput.getString("firstname");
                String lastname = queryOutput.getString("lastname");
                String monday = queryOutput.getString("monday");
                String tuesday = queryOutput.getString("tuesday");
                String wednesday = queryOutput.getString("wednesday");
                String thursday = queryOutput.getString("thursday");
                String friday = queryOutput.getString("friday");
                String saturday = queryOutput.getString("saturday");
                String sunday = queryOutput.getString("sunday");
                String cleaning = queryOutput.getString("cleaning");
                String cooking = queryOutput.getString("cooking");
                String baby = queryOutput.getString("baby");
                String email = queryOutput.getString("email");
                String city = queryOutput.getString("city");

                Float score = queryOutput.getFloat("score");
                Float pricing = queryOutput.getFloat("pricing");

                Blob image = queryOutput.getBlob("image");

                HousekeeperObservableList.add( new HousekeeperModel(id,age,ranking,reviews,firstname,monday,tuesday,wednesday,thursday,friday,saturday,sunday,cleaning,cooking,baby,lastname,email,city,score,pricing,image));
            }

            System.out.println(HousekeeperObservableList.get(0).age);

        } catch (Exception e){
            Logger.getLogger(HousekeeperModel.class.getName()).log(Level.SEVERE, null , e);
            e.printStackTrace();
        }


    }

}
