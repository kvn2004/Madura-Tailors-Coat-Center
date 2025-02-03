package edu.ijse.maduratailors.bo.custom;

import edu.ijse.maduratailors.DTO.CustomerDTO;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerMesurementDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean save(CustomerMesurementDTO emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(CustomerMesurementDTO DTO) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getDataFromCustomer(int customerId) throws SQLException, ClassNotFoundException;

    public boolean saveCustomerMesurement(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException;



}
