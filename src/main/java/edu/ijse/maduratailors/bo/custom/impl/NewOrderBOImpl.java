package edu.ijse.maduratailors.bo.custom.impl;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.OrderPaymentDTO;
import edu.ijse.maduratailors.DTO.ProductDTO;
import edu.ijse.maduratailors.bo.custom.NewOrderBO;
import edu.ijse.maduratailors.dao.DAOFactory;
import edu.ijse.maduratailors.dao.custom.NewOrderDAO;
import edu.ijse.maduratailors.dao.custom.impl.NewOrderDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class NewOrderBOImpl implements NewOrderBO {
    NewOrderDAO dao = (NewOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.NEW_ORDER);

    @Override
    public ArrayList<String> getID() throws SQLException, ClassNotFoundException {
        return dao.getID();
    }

    @Override
    public ArrayList<CustomerMesurementDTO> getCustomerMeasurement(int id) throws SQLException, ClassNotFoundException {
        return dao.getCustomerMeasurement(id);
    }

    @Override
    public ArrayList<String> getItemID() throws SQLException, ClassNotFoundException {
        return dao.getItemID();
    }

    @Override
    public ArrayList<ProductDTO> getItemDetails(int id) throws SQLException, ClassNotFoundException {
        return dao.getItemDetails(id);
    }

    @Override
    public boolean pay(OrderPaymentDTO orderPaymentDTO) {
        return dao.pay(orderPaymentDTO);
    }

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
}
