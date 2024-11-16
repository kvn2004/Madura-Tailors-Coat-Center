package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Label lblDate;
    public ImageView imgEmployee;
    public JFXButton btnEmployee;
    public JFXButton btnCustomer;
    public ImageView imgCustomer;
    public JFXButton btnPayment;
    public ImageView imgPayment;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(LocalDate.now().toString());

    }

    public JFXButton btnAddEmployee;
    public JFXButton btnAddCustomer;
    public Label lblUserName;
    public Label lblInterfaceName;
    public AnchorPane ancinterfaces;
    public JFXButton btnNewOrder;
    public ImageView imgDashboard;
    public ImageView imgNewOrder;
    public ImageView imgInterfaceImage;

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        lblInterfaceName.setText(btnAddEmployee.getText());
        imgInterfaceImage.setImage(imgDashboard.getImage());
        ancinterfaces.getChildren().clear();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/DashbordPanel.fxml"));
        ancinterfaces.getChildren().add(anchorPane);
    }

    public void btnbtnNewOrder(ActionEvent actionEvent) throws IOException {
        lblInterfaceName.setText(btnNewOrder.getText());
        imgInterfaceImage.setImage(imgNewOrder.getImage());
        ancinterfaces.getChildren().clear();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/NewOrder.fxml"));
        ancinterfaces.getChildren().add(anchorPane);
    }

    public void btnEmplyee(ActionEvent actionEvent) throws IOException {
        lblInterfaceName.setText(btnEmployee.getText());
        imgInterfaceImage.setImage(imgEmployee.getImage());
        ancinterfaces.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/View/AddEmlpyee.fxml"));
        ancinterfaces.getChildren().add(load);
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        lblInterfaceName.setText(btnCustomer.getText());
        imgInterfaceImage.setImage(imgCustomer.getImage());
        ancinterfaces.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/View/Customer.fxml"));
        ancinterfaces.getChildren().add(load);
    }

    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        lblInterfaceName.setText(btnPayment.getText());
        imgInterfaceImage.setImage(imgPayment.getImage());
        ancinterfaces.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/View/Payements.fxml"));
        ancinterfaces.getChildren().add(load);

    }
}
