package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DTO.CustomerDTO;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerMesurementDTO> {


    ArrayList<CustomerDTO> getDataFromCustomer(int customerId) throws SQLException, ClassNotFoundException;
    public int saveCustomer(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException;

}
