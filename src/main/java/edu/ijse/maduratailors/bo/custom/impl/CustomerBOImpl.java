package edu.ijse.maduratailors.bo.custom.impl;

import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.DTO.CustomerDTO;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.bo.custom.CustomerBO;
import edu.ijse.maduratailors.dao.DAOFactory;
import edu.ijse.maduratailors.dao.custom.CustomerDAO;
import edu.ijse.maduratailors.dao.custom.MesurementDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    MesurementDAO measurementDAO = (MesurementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEASUREMENT);

    @Override
    public ArrayList<CustomerMesurementDTO> getAll() throws SQLException, ClassNotFoundException {
        return dao.getAll();
    }

    @Override
    public boolean save(CustomerMesurementDTO emplyeeDTO) throws SQLException, ClassNotFoundException {
        return dao.save(emplyeeDTO);
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return dao.delete(Id);
    }

    @Override
    public boolean update(CustomerMesurementDTO DTO) throws SQLException, ClassNotFoundException {
        return dao.update(DTO);
    }

    @Override
    public ArrayList<CustomerDTO> getDataFromCustomer(int customerId) throws SQLException, ClassNotFoundException {
        return dao.getDataFromCustomer(customerId);
    }

    @Override
    public boolean saveCustomerMesurement(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        boolean result = false;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // METHINI THAMA TRANSACTION EK PATAN GNNE AUTO COMIT FALSE KRAMA

            // Insert into customer table and retrieve the generated CustomerID

            int customerId = dao.saveCustomer(customerMesurementDTO);

            // Insert into measurement table
            boolean measurementInserted = measurementDAO.saveMeasurement(customerId, customerMesurementDTO);

            if (!measurementInserted) {
                throw new SQLException("Creating measurement failed, no rows affected.");
            }

            connection.commit(); // Commit transaction
            result = true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction on error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Reset auto-commit
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return result;
    }
}
