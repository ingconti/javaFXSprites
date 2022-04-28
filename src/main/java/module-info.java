module com.example.grassorulez {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawSprites to javafx.fxml;
    exports com.example.drawSprites;
}