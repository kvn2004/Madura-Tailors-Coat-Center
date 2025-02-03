package edu.ijse.maduratailors.Controller;

import edu.ijse.maduratailors.DTO.TM.OrdersTM;
import edu.ijse.maduratailors.dao.custom.DashboardPanelDAO;
import edu.ijse.maduratailors.dao.custom.impl.DashboardPanelDAOImpl;
import edu.ijse.maduratailors.dao.CrudUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashBoardPanelController implements Initializable {
    @FXML
    private Label lblOrderCount;
    @FXML
    private Label lblCustomerCount;

    DashboardPanelDAO dashboardPanelDAO = new DashboardPanelDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        col_customer_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        col_order_type.setCellValueFactory(new PropertyValueFactory<>("order_type"));
        col_order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        col_order_DueDate.setCellValueFactory(new PropertyValueFactory<>("order_DueDate"));
        col_design.setCellValueFactory(new PropertyValueFactory<>("design"));
        col_order_price.setCellValueFactory(new PropertyValueFactory<>("order_price"));
        col_order_quantity.setCellValueFactory(new PropertyValueFactory<>("order_quantity"));

        try {
            ArrayList<OrdersTM>list= dashboardPanelDAO.getAll();
            ObservableList<OrdersTM>ordersTMS = FXCollections.observableArrayList();
            for(OrdersTM ordersTM:list){
                ordersTMS.add(ordersTM);
            }
            tblOrders.setItems(ordersTMS);
            ResultSet set = CrudUtil.execute("SELECT COUNT(*) FROM orders");
            ResultSet resultSet= CrudUtil.execute("SELECT COUNT(*) FROM customer;");
            while(set.next()){
                lblOrderCount.setText(String.valueOf(set.getInt(1)));
            }
            while(resultSet.next()){
                lblCustomerCount.setText(String.valueOf(resultSet.getInt(1)));
            }




        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    @FXML
    private TableColumn<OrdersTM, Integer> col_customer_id;

    @FXML
    private TableColumn<OrdersTM, String> col_design;

    @FXML
    private TableColumn<OrdersTM, String> col_order_DueDate;

    @FXML
    private TableColumn<OrdersTM, String> col_order_date;

    @FXML
    private TableColumn<OrdersTM, Integer> col_order_id;

    @FXML
    private TableColumn<OrdersTM, Double> col_order_price;

    @FXML
    private TableColumn<OrdersTM, Integer> col_order_quantity;

    @FXML
    private TableColumn<OrdersTM, String> col_order_type;

    @FXML
    private TableView<OrdersTM> tblOrders;
}
