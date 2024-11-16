package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import edu.ijse.maduratailors.Model.userModel;
import java.io.IOException;

public class AdminLogingController {

    @FXML
    private JFXButton btnLoging;

    @FXML
    private JFXPasswordField txtPwd;

    @FXML
    private JFXTextField txtUser;

    @FXML
    void btnLogingOnAction(ActionEvent event) throws IOException {
        String pwd = txtPwd.getText();
        String user = txtUser.getText();

        boolean b = userModel.checkUser(user,pwd);
        if (b) {
            Parent load = FXMLLoader.load(getClass().getResource("/View/Dashbord.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Image image = new Image(getClass().getResourceAsStream("/imgAssets/images/m.png"));
            stage.getIcons().add(image);
            stage.setTitle("Madura Tailors & Coat Center");
            stage.setResizable(false);
            Stage window = (Stage) btnLoging.getScene().getWindow();
            window.close();
        }
    }

}
