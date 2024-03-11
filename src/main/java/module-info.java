module com.example.OldSprites {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ingconti.drawSprites to javafx.fxml;
    exports com.ingconti.drawSprites;
}