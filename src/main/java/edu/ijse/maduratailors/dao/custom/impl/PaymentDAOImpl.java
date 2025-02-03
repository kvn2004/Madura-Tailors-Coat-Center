package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DTO.TM.PayemntTM;
import edu.ijse.maduratailors.Enum.PayStatus;
import edu.ijse.maduratailors.dao.custom.PaymentDAO;
import edu.ijse.maduratailors.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<PayemntTM> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT payments.*, orders.CustomerID FROM payments JOIN orders ON payments.order_id = orders.OrderID");
        ArrayList<PayemntTM> payemntTMS = new ArrayList<>();
        while (rst.next()) {
            payemntTMS.add(new PayemntTM(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getString(6), rst.getInt(7)));
        }
        return payemntTMS;
    }

    @Override
    public boolean save(PayemntTM emplyeeDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PayemntTM DTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updatePaymentStatus(String id, PayStatus value) throws SQLException, ClassNotFoundException {
        String statusValue = String.valueOf(value);
        return CrudUtil.execute("UPDATE payments SET status = ? WHERE payment_id = ?", statusValue, Integer.parseInt(id));
    }
}
