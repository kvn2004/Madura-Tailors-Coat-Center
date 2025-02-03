package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DTO.TM.PayemntTM;
import edu.ijse.maduratailors.Enum.PayStatus;
import edu.ijse.maduratailors.dao.CrudDAO;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<PayemntTM> {


    boolean updatePaymentStatus(String id, PayStatus value) throws SQLException, ClassNotFoundException;
}
