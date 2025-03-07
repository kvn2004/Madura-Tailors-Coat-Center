package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.maduratailors.DTO.EmplyeeDTO;
import edu.ijse.maduratailors.DTO.TM.EmployeeTM;
import edu.ijse.maduratailors.Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    public TableView tblEmployee;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cFName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        cBank.setCellValueFactory(new PropertyValueFactory<>("bank"));
        cAccountNumber.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        cTelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        try {
            loadTblEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTblEmployee() {
        ArrayList<EmplyeeDTO> emplyeeDTOS = EmployeeModel.getAllEmployee();
        ObservableList<EmployeeTM> objects = FXCollections.observableArrayList();

        for (EmplyeeDTO emplyeeDTO : emplyeeDTOS) {
            EmployeeTM employeeTM = new EmployeeTM(emplyeeDTO.getId(), emplyeeDTO.getFullName(), emplyeeDTO.getDob(), emplyeeDTO.getBank(), emplyeeDTO.getAccountNumber(), emplyeeDTO.getPhone());
            objects.add(employeeTM);
        }
        tblEmployee.setItems(objects);
    }

    public void refreshTblEmployee() {
        loadTblEmployee();
    }

    @FXML
    private JFXButton btnADD;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpadate;

    @FXML
    private JFXButton btnUpload;

    @FXML
    private TableColumn<EmployeeTM, String> cAccountNumber;

    @FXML
    private TableColumn<EmployeeTM, String> cBank;

    @FXML
    private TableColumn<EmployeeTM, Date> cDob;

    @FXML
    private TableColumn<EmployeeTM, String> cFName;

    @FXML
    private TableColumn<EmployeeTM, Integer> cID;

    @FXML
    private TableColumn<EmployeeTM, String> cTelephone;

    @FXML
    private ImageView imgEmployee;

    @FXML
    private JFXTextField lblAccountNumber;

    @FXML
    private JFXTextField lblBank;

    @FXML
    private JFXTextField lblDOB;

    @FXML
    private JFXTextField lblFname;

    @FXML
    private JFXTextField lblID;

    @FXML
    private JFXTextField lblLName;

    @FXML
    private JFXTextField lblMName;

    @FXML
    private JFXTextField lblTelephone;

    @FXML
    void btnADDOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            int id = 0;
            String fName = lblFname.getText();
            String mName = lblMName.getText();
            String lName = lblLName.getText();
            String dobString = lblDOB.getText();
            java.sql.Date dob = java.sql.Date.valueOf(dobString);
            String bank = lblBank.getText();
            String accountNumber = lblAccountNumber.getText();
            String phone = lblTelephone.getText();

            String fNamePattern = "^[A-Za-z ]+$";
            String mNamePattern = "^[A-Za-z ]+$";
            String lNamePattern = "^[A-Za-z ]+$";
            String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
            String dobPattern = "^\\d{4}-\\d{2}-\\d{2}$";
            String bankPattern = "^[A-Za-z ]+$";
            String accountNumberPattern = "^[0-9]+$";


            boolean isValidFName =fName.matches(fNamePattern);
            boolean isValidMName =mName.matches(mNamePattern);
            boolean isValidLName =lName.matches(lNamePattern);



            if (!isValidFName) {
                lblFname.setStyle(lblFname.getStyle() + ";-fx-border-color: red;");
            }

            EmplyeeDTO emplyeeDTO = new EmplyeeDTO(id, fName, mName, lName, dob, bank, accountNumber, phone);
            boolean isSaved = EmployeeModel.AddEmployee(emplyeeDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee saved...!").show();
                refreshTblEmployee();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save Employee...!").show();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An unexpected error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optType = alert.showAndWait();
        if (optType.get() == ButtonType.YES) {
            try {
                String employeeId = lblID.getText();
                boolean isDeleted = EmployeeModel.deleteEmployee(employeeId);
                if (isDeleted) {
                    refreshTblEmployee();
                    clear();
                    new Alert(Alert.AlertType.INFORMATION, "Employee deleted...!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete Employee...!").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnUpadateOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optType = alert.showAndWait();
        if (optType.get() == ButtonType.YES) {
            int employeeId = Integer.parseInt(lblID.getText());
            int id = employeeId;
            String fName = lblFname.getText();
            String mName = lblMName.getText();
            String lName = lblLName.getText();
            String dobString = lblDOB.getText();
            java.sql.Date dob = java.sql.Date.valueOf(dobString);
            String bank = lblBank.getText();
            String accountNumber = lblAccountNumber.getText();
            String phone = lblTelephone.getText();

            EmplyeeDTO emplyeeDTO = new EmplyeeDTO(id, fName, mName, lName, dob, bank, accountNumber, phone);
            try {
                boolean isUpdated = EmployeeModel.updateEmployee(emplyeeDTO);
                if (isUpdated) {
                    refreshTblEmployee();
                    clear();
                    new Alert(Alert.AlertType.INFORMATION, "Employee updated...!").show();
                }else {
                    try {
                        new Alert(Alert.AlertType.ERROR, "Fail to update Employee...!").show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    void btnUploadOnAction(ActionEvent event) {

    }

    public void onClickEmpTbl(MouseEvent mouseEvent) {
        EmployeeTM employeeTM = (EmployeeTM) tblEmployee.getSelectionModel().getSelectedItem();
        if (employeeTM != null) {
            lblID.setText(String.valueOf(employeeTM.getId()));
            lblFname.setText(employeeTM.getName().split(" ")[0]);
            lblMName.setText(employeeTM.getName().split(" ")[1]);
            lblLName.setText(employeeTM.getName().split(" ")[2]);
            lblAccountNumber.setText(employeeTM.getAccountNumber());
            lblBank.setText(employeeTM.getBank());
            lblDOB.setText(String.valueOf(employeeTM.getDob()));
            lblTelephone.setText(employeeTM.getPhone());
        }
    }

    public void clear() {
        lblID.setText("");
        lblFname.setText("");
        lblMName.setText("");
        lblLName.setText("");
        lblAccountNumber.setText("");
        lblBank.setText("");
        lblDOB.setText("");
        lblTelephone.setText("");
    }
}
