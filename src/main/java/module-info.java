module com.example.computer_graphics_lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.computer_graphics_lab1 to javafx.fxml;
    exports com.example.computer_graphics_lab1;
}