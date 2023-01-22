module com.example.kozintek {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires GNAvatarView;

    opens com.example.kozintek to javafx.fxml;
    exports com.example.kozintek;
}