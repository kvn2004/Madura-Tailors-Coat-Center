package edu.ijse.maduratailors.bo.custom;

import edu.ijse.maduratailors.DTO.TM.OrdersTM;
import edu.ijse.maduratailors.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DashboardPanelBO extends SuperBO {
    ArrayList<OrdersTM> getAll() throws SQLException ,ClassNotFoundException;

    boolean save(OrdersTM emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(OrdersTM DTO) throws SQLException, ClassNotFoundException;
}
