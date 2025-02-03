package edu.ijse.maduratailors.bo.custom;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.OrderPaymentDTO;
import edu.ijse.maduratailors.DTO.ProductDTO;
import edu.ijse.maduratailors.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NewOrderBO extends SuperBO {
    ArrayList<String> getID() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerMesurementDTO> getCustomerMeasurement(int id) throws SQLException, ClassNotFoundException;


    ArrayList<String> getItemID() throws SQLException, ClassNotFoundException;

    ArrayList<ProductDTO> getItemDetails(int id) throws SQLException, ClassNotFoundException;

    boolean pay(OrderPaymentDTO orderPaymentDTO);

    ArrayList<CustomerMesurementDTO> getAll() throws SQLException ,ClassNotFoundException;

    boolean save(CustomerMesurementDTO emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(CustomerMesurementDTO DTO) throws SQLException, ClassNotFoundException;
}
