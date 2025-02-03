package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.maduratailors.DTO.TM.PayemntTM;
import edu.ijse.maduratailors.Enum.PayStatus;
import edu.ijse.maduratailors.dao.custom.PaymentDAO;
import edu.ijse.maduratailors.dao.custom.impl.PaymentDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PayementController implements Initializable {

    @FXML
    private JFXComboBox<PayStatus> CbStatus;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtPaymentID;
    @FXML
    private TableColumn<PayemntTM, Double> colAmmount;

    @FXML
    private TableColumn<PayemntTM, Integer> colCustomerID;

    @FXML
    private TableColumn<PayemntTM, Integer> colOrderID;

    @FXML
    private TableColumn<PayemntTM, String> colPaymentDate;

    @FXML
    private TableColumn<PayemntTM, ?> colPaymentID;

    @FXML
    private TableColumn<PayemntTM, ?> colPaymentMethod;

    @FXML
    private TableColumn<PayemntTM, ?> colStatus;

    @FXML
    private TableView<PayemntTM> tblPayment;

    PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colPaymentID.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        colAmmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colPaymentMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        CbStatus.getItems().addAll(PayStatus.values());
        load();


    }

    public void tblPaymenOnMouseClicked(MouseEvent mouseEvent) {
        txtPaymentID.setText(String.valueOf(tblPayment.getSelectionModel().getSelectedItem().getPaymentId()));
        txtOrderID.setText(String.valueOf(tblPayment.getSelectionModel().getSelectedItem().getOrderId()));
        txtCustomerID.setText(String.valueOf(tblPayment.getSelectionModel().getSelectedItem().getCustomerId()));
        CbStatus.setValue(PayStatus.valueOf(tblPayment.getSelectionModel().getSelectedItem().getStatus()));
    }
    void load(){
        try {

            ArrayList<PayemntTM> payemntTMS = paymentDAO.getAll();
            ObservableList<PayemntTM> payemntTMObservableList = FXCollections.observableArrayList();
            for (PayemntTM payemntTM : payemntTMS) {
                payemntTMObservableList.add(new PayemntTM(
                        payemntTM.getPaymentId(),
                        payemntTM.getOrderId(),
                        payemntTM.getPaymentDate(),
                        payemntTM.getAmount(),
                        payemntTM.getPaymentMethod(),
                        payemntTM.getStatus(),
                        payemntTM.getCustomerId()
                ));
                tblPayment.setItems(payemntTMObservableList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println("hi");
        boolean isUpdated = paymentDAO.updatePaymentStatus(txtPaymentID.getText(), CbStatus.getValue());
        if (isUpdated) {
            load();
            new Alert(Alert.AlertType.INFORMATION, "Succesfully Updated...!").show();


        }
    }
}
