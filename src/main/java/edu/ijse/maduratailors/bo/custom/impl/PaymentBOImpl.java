package edu.ijse.maduratailors.bo.custom.impl;

import edu.ijse.maduratailors.DTO.TM.PayemntTM;
import edu.ijse.maduratailors.Enum.PayStatus;
import edu.ijse.maduratailors.bo.custom.PaymentBO;
import edu.ijse.maduratailors.dao.DAOFactory;
import edu.ijse.maduratailors.dao.custom.PaymentDAO;
import edu.ijse.maduratailors.dao.custom.impl.PaymentDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean updatePaymentStatus(String id, PayStatus value) throws SQLException, ClassNotFoundException {
        return paymentDAO.updatePaymentStatus(id, value);
    }

    @Override
    public ArrayList<PayemntTM> getAll() throws SQLException, ClassNotFoundException {
        return paymentDAO.getAll();
    }

    @Override
    public boolean save(PayemntTM emplyeeDTO) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(emplyeeDTO);
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(Id);
    }

    @Override
    public boolean update(PayemntTM DTO) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(DTO);
    }
}
