package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.maduratailors.dao.custom.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import edu.ijse.maduratailors.dao.custom.impl.userDAOImpl;
import java.io.IOException;

public class AdminLogingController {

    @FXML
    private JFXButton btnLoging;

    @FXML
    private JFXPasswordField txtPwd;

    @FXML
    private JFXTextField txtUser;

    UserDAO userDAO = new userDAOImpl();

    @FXML
    void btnLogingOnAction(ActionEvent event) throws IOException {
        String pwd = txtPwd.getText();
        String user = txtUser.getText();

        boolean b = userDAO.checkUser(user,pwd);
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
