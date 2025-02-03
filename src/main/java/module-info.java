module edu.ijse.maduratailors.maduratailors {
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.controls;
    requires static lombok;
    requires java.desktop;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires xml.apis.ext;


    opens edu.ijse.maduratailors.Controller to javafx.fxml;
    exports edu.ijse.maduratailors;
    exports edu.ijse.maduratailors.DTO.TM;
    opens View to javafx.fxml;
}