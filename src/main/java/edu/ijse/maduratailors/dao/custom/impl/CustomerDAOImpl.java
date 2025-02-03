package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.DTO.CustomerDTO;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudUtil;
import edu.ijse.maduratailors.dao.custom.CustomerDAO;
import edu.ijse.maduratailors.dao.custom.QuaryDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public ArrayList<CustomerDTO> getDataFromCustomer(int customerId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE CustomerID = ?", customerId);
        ArrayList<CustomerDTO> objects = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getInt("CustomerID"),    // Retrieve by column name or index
                    rst.getString("Name"),       // Retrieve by column name or index
                    rst.getString("Address"),    // Retrieve by column name or index
                    rst.getString("Telephone")
            );
            objects.add(customerDTO);
        }
        return objects;
    }
    QuaryDAO quaryDAO = new QueryDAOImpl();
    @Override
    public ArrayList<CustomerMesurementDTO> getAll() throws SQLException, ClassNotFoundException {
        return quaryDAO.getAll();
    }

    @Override
    public boolean save(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {

         return false;

    }
    @Override
    public int saveCustomer(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {
        ResultSet generatedKeys = CrudUtil.executeAndReturnGeneratedKeys(
                "INSERT INTO customer (Name, Address, Telephone) VALUES (?, ?, ?)",
                customerMesurementDTO.getName(),
                customerMesurementDTO.getAddress(),
                customerMesurementDTO.getTelephone()
        );

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1); // Return generated CustomerID
        }
        throw new SQLException("Creating customer failed, no ID obtained.");
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        int _id = Integer.parseInt(Id);
        return CrudUtil.execute("DELETE FROM customer WHERE CustomerID = ?", _id);
    }



    @Override
    public boolean update(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        boolean result = false;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean customerUpdated = CrudUtil.execute(
                    "UPDATE customer SET Name = ?, Address = ?, Telephone = ? WHERE CustomerID = ?",
                    customerMesurementDTO.getName(),
                    customerMesurementDTO.getAddress(),
                    customerMesurementDTO.getTelephone(),
                    customerMesurementDTO.getCustomerId()
            );
            if (!customerUpdated) {
                throw new SQLException("Updating customer failed, no rows affected.");
            }
            boolean measurementUpdated = CrudUtil.execute(
                    "UPDATE measurement SET NeckSize = ?, ShoulderWidth = ?, ChestSize = ?, WaistSize = ?, HipSize = ?, SleeveLength = ?, ShirtLength = ?, ThighSize = ?, InseamLength = ?, OutseamLength = ? WHERE CustomerID = ?",
                    customerMesurementDTO.getNeck(),
                    customerMesurementDTO.getShoulder(),
                    customerMesurementDTO.getChest(),
                    customerMesurementDTO.getWaist(),
                    customerMesurementDTO.getHip(),
                    customerMesurementDTO.getSleeve(),
                    customerMesurementDTO.getShirt(),
                    customerMesurementDTO.getThigh(),
                    customerMesurementDTO.getInseam(),
                    customerMesurementDTO.getOutseam(),
                    customerMesurementDTO.getCustomerId()
            );

            if (!measurementUpdated) {
                throw new SQLException("Updating measurement failed, no rows affected.");
            }

            connection.commit();
            result = true;
        } catch (SQLException | ClassNotFoundException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return result;


    }


}


