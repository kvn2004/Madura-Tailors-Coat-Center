module edu.ijse.maduratailors.maduratailors {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ijse.maduratailors.Controller to javafx.fxml;
    exports edu.ijse.maduratailors;
}