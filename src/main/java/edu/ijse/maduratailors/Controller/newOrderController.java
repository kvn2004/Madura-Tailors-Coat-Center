package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newOrderController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private AnchorPane ancNewOrder;

    @FXML
    private AnchorPane ancRentalInfo;

    @FXML
    private JFXButton btnRecipt;

    @FXML
    private JFXButton btnRecipt1;

    @FXML
    private JFXComboBox<?> cBDesign;

    @FXML
    private DatePicker dpDueDate;

    @FXML
    private DatePicker dpOrderDate;

    @FXML
    private DatePicker dpRentDueDate;

    @FXML
    private ImageView imgCustomrSearch;

    @FXML
    private ImageView imgItemSerch;

    @FXML
    private Label lblCustomerAddress;

    @FXML
    private Label lblCustomerContact;

    @FXML
    private Label lblCustomerID;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDesign;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblFirstFitOn;

    @FXML
    private Label lblItemID;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblItemType;

    @FXML
    private Label lblNormalRental;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblOrderType;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblQTY;

    @FXML
    private Label lblRentDueDate;

    @FXML
    private JFXToggleButton tglBtnPurchase;

    @FXML
    private JFXToggleButton tglBtnRent;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtCustomerContact;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtItemID;

    @FXML
    private JFXTextField txtItemPrice;

    @FXML
    private JFXTextField txtItemType;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQTY;

    @FXML
    void btnRecipt(ActionEvent event) {

    }

    @FXML
    void imgSearchOnMouseClicked(MouseEvent event) throws IOException {
        Parent load = new FXMLLoader().load(getClass().getResource("/View/Customer.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        Image image = new Image(getClass().getResourceAsStream("/imgAssets/icons/icons8-person-100.png"));
        stage.getIcons().add(image);
        stage.show();

    }

    @FXML
    void tglBtnPurchaseOnAction(ActionEvent event) {

    }

    @FXML
    void tglBtnRentOnAction(ActionEvent event) {

    }


}
