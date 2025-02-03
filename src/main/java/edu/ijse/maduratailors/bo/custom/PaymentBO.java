package edu.ijse.maduratailors.bo.custom;

import edu.ijse.maduratailors.DTO.TM.PayemntTM;
import edu.ijse.maduratailors.Enum.PayStatus;
import edu.ijse.maduratailors.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    boolean updatePaymentStatus(String id, PayStatus value) throws SQLException, ClassNotFoundException;

    ArrayList<PayemntTM> getAll() throws SQLException, ClassNotFoundException;

    boolean save(PayemntTM emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(PayemntTM DTO) throws SQLException, ClassNotFoundException;


}
