package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DTO.TM.OrdersTM;
import edu.ijse.maduratailors.dao.custom.DashboardPanelDAO;
import edu.ijse.maduratailors.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardPanelDAOImpl implements DashboardPanelDAO {
    @Override
    public ArrayList<OrdersTM> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM orders");
        ArrayList<OrdersTM> orders = new ArrayList<>();
        while (set.next()) {
            orders.add(new OrdersTM(
                    set.getInt(1),
                    set.getInt(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getDouble(7),
                    set.getInt(8)
            ));
        }
        return orders;
    }

    @Override
    public boolean save(OrdersTM emplyeeDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrdersTM DTO) throws SQLException, ClassNotFoundException {
        return false;
    }


}
