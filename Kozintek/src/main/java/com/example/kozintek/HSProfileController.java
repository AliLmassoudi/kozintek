package com.example.kozintek;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HSProfileController implements Initializable {

    @FXML
    private ImageView imageHS;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setImage(Blob imageBlob) throws SQLException {
        byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
        Image imageresult = new Image(new ByteArrayInputStream(imageData));
        imageHS.setImage(imageresult);
    }

}
