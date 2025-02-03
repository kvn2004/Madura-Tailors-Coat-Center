package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.maduratailors.DTO.CustomerDTO;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.TM.CustomerMesurementTM;
import edu.ijse.maduratailors.Enum.TextField;
import edu.ijse.maduratailors.bo.BOFactory;
import edu.ijse.maduratailors.bo.custom.CustomerBO;
import edu.ijse.maduratailors.dao.custom.CustomerDAO;
import edu.ijse.maduratailors.dao.custom.impl.CustomerDAOImpl;
import edu.ijse.maduratailors.util.Regex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Setter;
import org.w3c.dom.svg.SVGAnimatedRect;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    public Label lbl1;
    public Label lbl2;
    public Label lbl3;
    public Label lbl4;
    public Label lbl5;
    public Label lbl6;
    public Label lbl7;
    public Label lbl8;
    public Label lbl9;
    public Label lbl10;
    public Label lbl11;
    public Label lbl12;
    public Label lbl13;
    public Label lbl14;
    public Label lbl15;
    public JFXButton btnSelect;

    CustomerDAO customerDAO = new CustomerDAOImpl();

    private void lableVisible() {
        if (txtFname.getText().isEmpty()) {
            lbl1.setVisible(false);
            lbl2.setVisible(false);
            lbl3.setVisible(false);
            lbl4.setVisible(false);
            lbl5.setVisible(false);
            lbl6.setVisible(false);
            lbl7.setVisible(false);
            lbl8.setVisible(false);
            lbl9.setVisible(false);
            lbl10.setVisible(false);
            lbl11.setVisible(false);
            lbl12.setVisible(false);
            lbl13.setVisible(false);
            lbl14.setVisible(false);
            lbl15.setVisible(false);
        } else {
            lbl1.setVisible(true);
            lbl2.setVisible(true);
            lbl3.setVisible(true);
            lbl4.setVisible(true);
            lbl5.setVisible(true);
            lbl6.setVisible(true);
            lbl7.setVisible(true);
            lbl8.setVisible(true);
            lbl9.setVisible(true);
            lbl10.setVisible(true);
            lbl11.setVisible(true);
            lbl12.setVisible(true);
            lbl13.setVisible(true);
            lbl14.setVisible(true);
            lbl15.setVisible(true);
        }
    }

//    private newOrderController newOrderController;


    @Setter
    private newOrderController orderFormController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColMeasurementID.setCellValueFactory(new PropertyValueFactory<>("MeasurementId"));
        ColCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ColNeck.setCellValueFactory(new PropertyValueFactory<>("chest"));
        ColChest.setCellValueFactory(new PropertyValueFactory<>("neck"));
        ColWaist.setCellValueFactory(new PropertyValueFactory<>("waist"));
        ColSleeveLength.setCellValueFactory(new PropertyValueFactory<>("sleeve"));
        ColShirtLength.setCellValueFactory(new PropertyValueFactory<>("shirt"));
        ColShoulder.setCellValueFactory(new PropertyValueFactory<>("shoulder"));
        ColHip.setCellValueFactory(new PropertyValueFactory<>("hip"));
        ColInseame.setCellValueFactory(new PropertyValueFactory<>("inseam"));
        ColOutseame.setCellValueFactory(new PropertyValueFactory<>("outseam"));
        ColThigh.setCellValueFactory(new PropertyValueFactory<>("thigh"));

        try {
            refreshTblMeasurement();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load Table Please Contact Developper").show();
        }

    }

    private void refreshTblMeasurement() throws SQLException, ClassNotFoundException {
        loadTblMesurement();
    }

    private void loadTblMesurement() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerMesurementDTO> allCustomerMeasurement = customerDAO.getAll();
        ObservableList<CustomerMesurementTM> objects = FXCollections.observableArrayList();

        for (CustomerMesurementDTO customerMesurementDTO : allCustomerMeasurement) {
            objects.add(new CustomerMesurementTM(customerMesurementDTO.getMeasurementId(), customerMesurementDTO.getCustomerId(), customerMesurementDTO.getName(), customerMesurementDTO.getNeck(), customerMesurementDTO.getChest(), customerMesurementDTO.getWaist(), customerMesurementDTO.getSleeve(), customerMesurementDTO.getShirt(), customerMesurementDTO.getShoulder(), customerMesurementDTO.getHip(), customerMesurementDTO.getInseam(), customerMesurementDTO.getOutseam(), customerMesurementDTO.getThigh()));
        }
        tblCustomerMesurement.setItems(objects);
    }

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColChest;

    @FXML
    private TableColumn<CustomerMesurementTM, Integer> ColCustomerID;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColHip;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColInseame;

    @FXML
    private TableColumn<CustomerMesurementTM, Integer> ColMeasurementID;

    @FXML
    private TableColumn<CustomerMesurementTM, String> ColName;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColNeck;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColOutseame;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColShirtLength;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColShoulder;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColSleeveLength;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColThigh;

    @FXML
    private TableColumn<CustomerMesurementTM, Double> ColWaist;

    @FXML
    private JFXButton btnADD;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpadate;

    @FXML
    private JFXButton btnUpload;

    @FXML
    private ImageView imgEmployee;

    @FXML
    private TableView<CustomerMesurementTM> tblCustomerMesurement;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtChest;

    @FXML
    private JFXTextField txtFname;

    @FXML
    private JFXTextField txtHip;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtInseam;

    @FXML
    private JFXTextField txtNeck;

    @FXML
    private JFXTextField txtOutseam;

    @FXML
    private JFXTextField txtShirtLength;

    @FXML
    private JFXTextField txtShoulder;

    @FXML
    private JFXTextField txtSleeveLength;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXTextField txtThigh;

    @FXML
    private JFXTextField txtWaist;

    @FXML
    private JFXTextField txtWaist2;

CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    void btnADDOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        int id = 0;
        int mId = 0;
        String name = txtFname.getText();
        String address = txtAddress.getText();
        String telephone = txtTelephone.getText();
        double neck = 0.0;
        double Shoulder = 0.0;
        double Chest = 0.0;
        double waist = 0.0;
        double hip = 0.0;
        double sleeveLength = 0.0;
        double shirtLength = 0.0;
        double thigh = 0.0;
        double outseame = 0.0;
        double inseam = 0.0;

        try {
            neck = parseDoubleWithDefault(txtNeck.getText(), "neck");
            Shoulder = parseDoubleWithDefault(txtShoulder.getText(), "shoulder");
            Chest = parseDoubleWithDefault(txtChest.getText(), "chest");
            ////////
            if (!txtWaist.getText().isEmpty()) {
                waist = parseDoubleWithDefault(txtWaist.getText(), "waist");
            } else {
                waist = parseDoubleWithDefault(txtWaist2.getText(), "waist2");
            }
            ///////////////
            hip = parseDoubleWithDefault(txtHip.getText(), "hip");
            sleeveLength = parseDoubleWithDefault(txtSleeveLength.getText(), "sleeve length");
            shirtLength = parseDoubleWithDefault(txtShirtLength.getText(), "shirt length");
            thigh = parseDoubleWithDefault(txtThigh.getText(), "thigh");
            outseame = parseDoubleWithDefault(txtOutseam.getText(), "outseam");
            inseam = parseDoubleWithDefault(txtInseam.getText(), "inseam");
            if (!isValidInput()) {
                new Alert(Alert.AlertType.ERROR, "Please ensure all fields are correctly filled out.").show();
                return;
            }
            if (isValidInput()) {
                CustomerMesurementDTO customerMesurementDTO = new CustomerMesurementDTO(id, mId, name, address, telephone, neck, Shoulder, Chest, waist, hip, sleeveLength, shirtLength, thigh, outseame, inseam);

                boolean isSaved = customerBO.saveCustomerMesurement(customerMesurementDTO);
                if (isSaved) {
                    refreshTblMeasurement();
                    clear();
                    new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optType = alert.showAndWait();
        if (optType.get() == ButtonType.YES) {
            String id = txtID.getText();

            boolean isDeleted = customerDAO.delete(id);
            if (isDeleted) {
                refreshTblMeasurement();
                clear();
                new Alert(Alert.AlertType.INFORMATION, "Delete SUCCESFUL...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to Delete Contact Developper...!").show();
            }
        }
    }

    @FXML
    void btnUpadateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optType = alert.showAndWait();
        if (optType.get() == ButtonType.YES) {
            int id = Integer.parseInt(txtID.getText());
            int mId = tblCustomerMesurement.getSelectionModel().getSelectedItem().getCustomerId();
            String name = txtFname.getText();
            String address = txtAddress.getText();
            String telephone = txtTelephone.getText();
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

            if (!isValidInput()) {
                new Alert(Alert.AlertType.ERROR, "Please ensure all fields are correctly filled out.").show();
                return;
            }
            if (isValidInput()) {
                CustomerMesurementDTO customerMesurementDTO = new CustomerMesurementDTO(id, mId, name, address, telephone, neck, Shoulder, Chest, waist, hip, sleeveLength, shirtLength, thigh, outseame, inseam);
                boolean isUpdated = customerDAO.update(customerMesurementDTO);
                if (isUpdated) {
                    refreshTblMeasurement();
                    clear();
                    new Alert(Alert.AlertType.INFORMATION, "Customer update...!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to update ...!").show();
                }
            }
        }
    }

    @FXML
    void btnUploadOnAction(ActionEvent event) {
        // Create a FileChooser instance
        FileChooser fileChooser = new FileChooser();

        // Set the title of the FileChooser dialog
        fileChooser.setTitle("Open Resource File");

        // Set the initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set the file extension filters (optional)
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        // Show the Open dialog and get the selected file
        Stage stage1 = new Stage();

        stage1 = (Stage) ((Button) event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage1);

        // Handle the selected file (if any)
        if (selectedFile != null) {
            System.out.println("File selected: " + selectedFile.getAbsolutePath());
            // You can add your file handling code here
        } else {
            System.out.println("File selection cancelled.");
        }

    }

    private double parseDoubleWithDefault(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            input = String.valueOf(0.0);
            throw new NumberFormatException("Input for " + fieldName + " is empty.");
        }
        return Double.parseDouble(input);
    }

    private void clear() {
        txtAddress.setText("");
        txtChest.setText("");
        txtFname.setText("");
        txtHip.setText("");
        txtID.setText("");
        txtInseam.setText("");
        txtNeck.setText("");
        txtOutseam.setText("");
        txtShirtLength.setText("");
        txtShoulder.setText("");
        txtSleeveLength.setText("");
        txtTelephone.setText("");
        txtWaist.setText("");
        txtWaist2.setText("");
        txtHip.setText("");
        txtThigh.setText("");
    }

    public void onClickMesuremetTbl(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        CustomerMesurementTM selectedItem = tblCustomerMesurement.getSelectionModel().getSelectedItem();
        int customerId = selectedItem.getMeasurementId();
        ArrayList<CustomerDTO> customerDTOS = customerDAO.getDataFromCustomer(customerId);
        for (CustomerDTO customerDTO : customerDTOS) {
            txtAddress.setText(customerDTO.getAddress());
            txtTelephone.setText(customerDTO.getTelephone());
        }
        if (selectedItem != null) {
            txtID.setText(String.valueOf(selectedItem.getMeasurementId()));
            txtFname.setText(selectedItem.getName());
            txtChest.setText(String.valueOf(selectedItem.getChest()));
            txtHip.setText(String.valueOf(selectedItem.getHip()));
            txtWaist.setText(String.valueOf(selectedItem.getWaist()));
            txtOutseam.setText(String.valueOf(selectedItem.getOutseam()));
            txtInseam.setText(String.valueOf(selectedItem.getInseam()));
            txtNeck.setText(String.valueOf(selectedItem.getNeck()));
            txtShoulder.setText(String.valueOf(selectedItem.getShoulder()));
            txtShirtLength.setText(String.valueOf(selectedItem.getShirt()));
            txtThigh.setText(String.valueOf(selectedItem.getThigh()));
            txtSleeveLength.setText(String.valueOf(selectedItem.getSleeve()));
            txtWaist2.setText(String.valueOf(selectedItem.getWaist()));
        }


    }

    public void onMouseEntered(MouseEvent mouseEvent) {
        lableVisible();
    }


    public void btnSelectOnAction(ActionEvent actionEvent) {
//        try {
//
//            String idText = txtID.getText();
//            if (idText.isEmpty()) {
//                throw new NumberFormatException("ID field is empty");
//            }
//            int id = Integer.parseInt(idText);
//
//            int mId = tblCustomerMesurement.getSelectionModel().getSelectedItem().getCustomerId();
//
//
//            String name = txtFname.getText();
//            String address = txtAddress.getText();
//            String telephone = txtTelephone.getText();
//
//
//            double neck = parseDoubleWithValidation(txtNeck.getText(), "Neck");
//            double shoulder = parseDoubleWithValidation(txtShoulder.getText(), "Shoulder");
//            double chest = parseDoubleWithValidation(txtChest.getText(), "Chest");
//            double waist = parseDoubleWithValidation(txtWaist.getText(), "Waist");
//            double waist2 = parseDoubleWithValidation(txtWaist2.getText(), "Waist2");
//            double hip = parseDoubleWithValidation(txtHip.getText(), "Hip");
//            double sleeveLength = parseDoubleWithValidation(txtSleeveLength.getText(), "Sleeve Length");
//            double shirtLength = parseDoubleWithValidation(txtSleeveLength.getText(), "Shirt Length");
//            double thigh = parseDoubleWithValidation(txtThigh.getText(), "Thigh");
//            double outseam = parseDoubleWithValidation(txtOutseam.getText(), "Outseam");
//            double inseam = parseDoubleWithValidation(txtInseam.getText(), "Inseam");
//
//            CustomerMesurementDTO customerMesurementDTO = new CustomerMesurementDTO(id, mId, name, address, telephone, neck, shoulder, chest, waist, hip, sleeveLength, shirtLength, thigh, outseam, inseam);
//            System.out.println(customerMesurementDTO);
//
//
//            if (newOrderController != null) {
//                newOrderController.receiveCustomerMesurementDTO(customerMesurementDTO);
//            }
//        } catch (NumberFormatException e) {
//            System.err.println("Invalid input: " + e.getMessage());
//
//        }
    }

    boolean isValidInput() {
        if (!Regex.setTextColor(TextField.NAME, txtFname)) return false;
        if (!Regex.setTextColor(TextField.ADDRESS, txtAddress)) return false;
        if (!Regex.setTextColor(TextField.CONTACT, txtTelephone)) return false;
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




