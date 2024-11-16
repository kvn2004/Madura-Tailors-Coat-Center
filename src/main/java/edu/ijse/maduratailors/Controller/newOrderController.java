package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class newOrderController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tglBtnPurchase.setSelected(true);
        if (tglBtnPurchase.isSelected()) {
            ancRentalInfo.setDisable(true);
        }

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
    private JFXButton btnRecipt2;

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
    private Label lbl10;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl12;

    @FXML
    private Label lbl13;

    @FXML
    private Label lbl14;

    @FXML
    private Label lbl15;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl9;

    @FXML
    private Label lblAdvance;

    @FXML
    private Label lblCustomerAddress;

    @FXML
    private Label lblCustomerContact;

    @FXML
    private Label lblDesign;

    @FXML
    private Label lblDiscount;

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
    private Label lblRestAmmountToPay;

    @FXML
    private JFXToggleButton tglBtnPurchase;

    @FXML
    private JFXToggleButton tglBtnRent;

    @FXML
    private JFXTextField txtAdvance;

    @FXML
    private JFXTextField txtChest;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtCustomerContact;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtHip;

    @FXML
    private JFXTextField txtInseam;

    @FXML
    private JFXTextField txtItemID;

    @FXML
    private JFXTextField txtItemPrice;

    @FXML
    private JFXTextField txtItemType;

    @FXML
    private JFXTextField txtNeck;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtOutseam;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQTY;

    @FXML
    private JFXTextField txtRestAmmountToPay;

    @FXML
    private JFXTextField txtShirtLength;

    @FXML
    private JFXTextField txtShoulder;

    @FXML
    private JFXTextField txtSleeveLength;

    @FXML
    private JFXTextField txtThigh;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtWaist;

    @FXML
    private JFXTextField txtWaist2;

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
    void tglBtnOnAction(ActionEvent event) {
        if (tglBtnPurchase.isSelected()) {
            tglBtnRent.setSelected(false);
        }
        if (!tglBtnPurchase.isSelected()) {
            tglBtnRent.setSelected(true);
        }
        if (tglBtnRent.isSelected()) {
            ancRentalInfo.setDisable(false);
        }
        if (!tglBtnRent.isSelected()) {
            ancRentalInfo.setDisable(true);
        }
    }


    public void receiveCustomerMesurementDTO(CustomerMesurementDTO customerMesurementDTO) {
        try {
            System.out.println("-----------------------------------------");
            System.out.println("awaaaaaa  -"+customerMesurementDTO);
            System.out.println("-----------------------------------------");
            String name = customerMesurementDTO.getName();
            txtCustomerName.setText(name);

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR "+e.getMessage());
        }


    }
}
