package edu.ijse.maduratailors.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.ijse.maduratailors.DTO.EmplyeeDTO;
import edu.ijse.maduratailors.DTO.TM.EmployeeTM;
import edu.ijse.maduratailors.Enum.TextField;
import edu.ijse.maduratailors.dao.custom.EmployeeDAO;
import edu.ijse.maduratailors.dao.custom.impl.EmployeeDAOImpl;
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

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    public TableView tblEmployee;

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
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

    public void loadTblEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmplyeeDTO> emplyeeDTOS = employeeDAO.getAll();
        ObservableList<EmployeeTM> objects = FXCollections.observableArrayList();

        for (EmplyeeDTO emplyeeDTO : emplyeeDTOS) {
            EmployeeTM employeeTM = new EmployeeTM(emplyeeDTO.getId(), emplyeeDTO.getFullName(), emplyeeDTO.getDob(), emplyeeDTO.getBank(), emplyeeDTO.getAccountNumber(), emplyeeDTO.getPhone());
            objects.add(employeeTM);
        }
        tblEmployee.setItems(objects);
    }

    public void refreshTblEmployee() throws SQLException, ClassNotFoundException {
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
            if (!isValid()) {
                new Alert(Alert.AlertType.ERROR, "Please ensure all fields are correctly filled out.").show();
                return;
            }
            if (isValid()) {

                EmplyeeDTO emplyeeDTO = new EmplyeeDTO(id, fName, mName, lName, dob, bank, accountNumber, phone);
                boolean isSaved = employeeDAO.save(emplyeeDTO);


                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Employee saved...!").show();
                    refreshTblEmployee();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to save Employee...!").show();
                }
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
                boolean isDeleted = employeeDAO.delete(employeeId);
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


            try {
                if (!isValid()) {
                    new Alert(Alert.AlertType.ERROR, "Please ensure all fields are correctly filled out.").show();
                    return;
                }
                if (isValid()) {
                    EmplyeeDTO emplyeeDTO = new EmplyeeDTO(id, fName, mName, lName, dob, bank, accountNumber, phone);
                    boolean isUpdated = employeeDAO.update(emplyeeDTO);
                    if (isUpdated) {
                        refreshTblEmployee();
                        clear();
                        new Alert(Alert.AlertType.INFORMATION, "Employee updated...!").show();
                    } else {
                        try {
                            new Alert(Alert.AlertType.ERROR, "Fail to update Employee...!").show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

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

    boolean isValid() {
        if (!Regex.setTextColor(TextField.NAME, lblFname)) return false;
        if (!Regex.setTextColor(TextField.NAME, lblMName)) return false;
        if (!Regex.setTextColor(TextField.NAME, lblLName)) return false;
        if (!Regex.setTextColor(TextField.DATE, lblDOB)) return false;
        if (!Regex.setTextColor(TextField.BANK, lblBank)) return false;
        if (!Regex.setTextColor(TextField.CONTACT, lblAccountNumber)) return false;
        if (!Regex.setTextColor(TextField.CONTACT, lblTelephone)) return false;
        return true;
    }
}
