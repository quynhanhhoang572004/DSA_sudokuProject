module org.example.sudokugame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.sudokugame to javafx.fxml;
    exports org.example.sudokugame;
}