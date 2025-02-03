package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.OrderPaymentDTO;
import edu.ijse.maduratailors.DTO.ProductDTO;
import edu.ijse.maduratailors.dao.CrudDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NewOrderDAO extends CrudDAO<CustomerMesurementDTO> {
    ArrayList<String> getID() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerMesurementDTO> getCustomerMeasurement(int id) throws SQLException, ClassNotFoundException;


    ArrayList<String> getItemID() throws SQLException, ClassNotFoundException;

    ArrayList<ProductDTO> getItemDetails(int id) throws SQLException, ClassNotFoundException;

    boolean pay(OrderPaymentDTO orderPaymentDTO);
}
