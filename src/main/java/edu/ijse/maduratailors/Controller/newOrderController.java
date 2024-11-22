package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.*;
import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.OrderPaymentDTO;
import edu.ijse.maduratailors.DTO.ProductDTO;
import edu.ijse.maduratailors.Enum.Design;
import edu.ijse.maduratailors.Enum.TextField;
import edu.ijse.maduratailors.Model.CustomerModel;
import edu.ijse.maduratailors.Model.NewOrderModel;
import edu.ijse.maduratailors.util.Regex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class newOrderController implements Initializable {


    public JFXButton btnCal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tglBtnPurchase.setSelected(true);
        if (tglBtnPurchase.isSelected()) {
            ancRentalInfo.setDisable(true);
        }
        loadCustomerId();
        loadItemId();
        cBDesign.getItems().addAll(Design.values());


    }

    @FXML
    private JFXCheckBox cbCash;
    @FXML
    private JFXCheckBox CbCard;
    @FXML
    private ImageView imgSearchItem;
    @FXML
    private JFXButton btnPay;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private ImageView imgSearch;
    @FXML
    private JFXComboBox<String> cBCustomerID;
    @FXML
    private JFXComboBox<String> cBItemID;
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
    private JFXComboBox<Design> cBDesign;

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
    public JFXTextField txtCustomerName;

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
    void btnRecipt(ActionEvent event) throws JRException, SQLException, ClassNotFoundException {
        JasperDesign jasperDesign = JRXmlLoader.load("/Reports/NewOrderReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);

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

    void loadCustomerId() {
        try {
            ArrayList<String> list = NewOrderModel.getID();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(list);
            cBCustomerID.setItems(objects);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("e");
        }
    }

    void loadItemId() {
        try {
            ArrayList<String> list = NewOrderModel.getItemID();
            ObservableList<String> objects = FXCollections.observableArrayList();
            objects.addAll(list);
            cBItemID.setItems(objects);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("e");
        }
    }

    public void imgSearchClicked(MouseEvent mouseEvent) {
        int id = Integer.parseInt(cBCustomerID.getValue());
        try {
            ArrayList<CustomerMesurementDTO> Cm = NewOrderModel.getCustomerMeasurement(id);
            for (CustomerMesurementDTO cm : Cm) {
                txtCustomerName.setText(cm.getName());
                txtCustomerContact.setText(cm.getTelephone());
                txtCustomerAddress.setText(cm.getAddress());
                txtNeck.setText(String.valueOf(cm.getNeck()));
                txtHip.setText(String.valueOf(cm.getHip()));
                txtInseam.setText(String.valueOf(cm.getInseam()));
                txtOutseam.setText(String.valueOf(cm.getOutseam()));
                txtChest.setText(String.valueOf(cm.getChest()));
                txtShirtLength.setText(String.valueOf(cm.getShirt()));
                txtSleeveLength.setText(String.valueOf(cm.getSleeve()));
                txtThigh.setText(String.valueOf(cm.getThigh()));
                txtShoulder.setText(String.valueOf(cm.getShoulder()));
                txtWaist.setText(String.valueOf(cm.getWaist()));
                txtWaist2.setText(String.valueOf(cm.getWaist()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optType = alert.showAndWait();
        if (optType.get() == ButtonType.YES) {
            int id = Integer.parseInt(cBCustomerID.getValue());
            int mId = 0;
            String name = txtCustomerName.getText();
            String address = txtCustomerAddress.getText();
            String telephone = txtCustomerContact.getText();
            double neck = Double.parseDouble(txtNeck.getText());
            double Shoulder = Double.parseDouble(txtShoulder.getText());
            double Chest = Double.parseDouble(txtChest.getText());
            double waist = Double.parseDouble(txtWaist.getText());
            waist = Double.parseDouble(txtWaist2.getText());
            double hip = Double.parseDouble(txtHip.getText());
            double sleeveLength = Double.parseDouble(txtSleeveLength.getText());
            double shirtLength = Double.parseDouble(txtSleeveLength.getText());
            double thigh = Double.parseDouble(txtThigh.getText());
            double outseame = Double.parseDouble(txtOutseam.getText());
            double inseam = Double.parseDouble(txtInseam.getText());
            if (isValidInput()) {
                CustomerMesurementDTO customerMesurementDTO = new CustomerMesurementDTO(id, mId, name, address, telephone, neck, Shoulder, Chest, waist, hip, sleeveLength, shirtLength, thigh, outseame, inseam);
                boolean isUpdated = NewOrderModel.upadte(customerMesurementDTO);
                if (isUpdated) {

                    new Alert(Alert.AlertType.INFORMATION, "Customer update...!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to update ...!").show();
                }
            }if (!isValidInput()) {
                new Alert(Alert.AlertType.ERROR, "Please ensure all fields are correctly filled out.").show();
                return;
            }
        }
    }

    public void btnPay(ActionEvent actionEvent) {
        int cID = Integer.parseInt(cBCustomerID.getValue());
        String type;
        int itemId;
        if (tglBtnPurchase.isSelected()) {
            type = "Purchase";
            itemId = 0;
        } else {
            type = "Rent";
            itemId = Integer.parseInt(cBItemID.getValue());
        }
        String orderDate = dpOrderDate.getValue().toString();
        String dueDate = dpDueDate.getValue().toString();
        String design = cBDesign.getValue().toString();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQTY.getText());
        String paymentMethod = "Cash";
        /////////////////////
        if (cbCash.isSelected()) {
            paymentMethod = "Cash";
            CbCard.setSelected(false);
        }
        if (CbCard.isSelected()) {
            paymentMethod = "Card";
            cbCash.setSelected(false);
        }
        /////////////////////
        String Status = "Pending";
        ///////
        if (txtTotal.getText().equals(txtAdvance.getText())) {
            Status = "Completed";
        } else {
            Status = "Pending";
        }
        //////
        double amount = Double.parseDouble(txtAdvance.getText());
        String paymentDate = orderDate;
        OrderPaymentDTO orderPaymentDTO = new OrderPaymentDTO(cID, type, orderDate, dueDate, design, price, qty, itemId, paymentMethod, paymentDate, amount, Status);
        boolean isSuccesfull = NewOrderModel.pay(orderPaymentDTO);
        if (isSuccesfull) {
            new Alert(Alert.AlertType.INFORMATION, "Order Placed...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Order Placed!!").show();
        }


    }

    public void imgSearchItem(MouseEvent mouseEvent) {
        int id = Integer.parseInt(cBItemID.getValue());
        System.out.println(id);
        try {
            ArrayList<ProductDTO> productDTOS = NewOrderModel.getItemDetails(id);
            for (ProductDTO productDTO : productDTOS) {
                txtItemPrice.setText(String.valueOf(productDTO.getPrice()));
                txtItemType.setText(productDTO.getCatogory());
            }
            txtPrice.setText(txtItemPrice.getText());
            txtQTY.setText("1");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void btnCalONAction(ActionEvent actionEvent) {
        double tot = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQTY.getText());
        txtTotal.setText(String.valueOf(tot * qty));
    }

    boolean isValidInput() {
        if (!Regex.setTextColor(TextField.NAME, txtCustomerName)) return false;
        if (!Regex.setTextColor(TextField.ADDRESS, txtCustomerAddress)) return false;
        if (!Regex.setTextColor(TextField.CONTACT, txtCustomerContact)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtNeck)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtNeck)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtChest)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtWaist)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtWaist2)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtShirtLength)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtSleeveLength)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtShoulder)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtHip)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtInseam)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtOutseam)) return false;
        if (!Regex.setTextColor(TextField.MEASUREMENT, txtThigh)) return false;
        return true;
    }

}
