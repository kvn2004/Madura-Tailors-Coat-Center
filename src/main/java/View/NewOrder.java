package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class NewOrder {

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
    void imgSearchOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void tglBtnPurchaseOnAction(ActionEvent event) {

    }

    @FXML
    void tglBtnRentOnAction(ActionEvent event) {

    }

}
