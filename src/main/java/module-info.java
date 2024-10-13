module edu.ijse.maduratailors.maduratailors {
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.controls;
    requires static lombok;
    requires java.desktop;


    opens edu.ijse.maduratailors.Controller to javafx.fxml;
    exports edu.ijse.maduratailors;
    opens View to javafx.fxml;
}