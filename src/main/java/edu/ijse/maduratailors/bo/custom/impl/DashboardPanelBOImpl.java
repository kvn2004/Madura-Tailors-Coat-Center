package edu.ijse.maduratailors.bo.custom.impl;

import edu.ijse.maduratailors.DTO.TM.OrdersTM;
import edu.ijse.maduratailors.bo.custom.DashboardPanelBO;
import edu.ijse.maduratailors.dao.DAOFactory;
import edu.ijse.maduratailors.dao.custom.DashboardPanelDAO;
import edu.ijse.maduratailors.dao.custom.impl.DashboardPanelDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardPanelBOImpl implements DashboardPanelBO {
    DashboardPanelDAO dao = (DashboardPanelDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DASH_BOARD_PANEL);

    @Override
    public ArrayList<OrdersTM> getAll() throws SQLException, ClassNotFoundException {
        return dao.getAll();
    }

    @Override
    public boolean save(OrdersTM emplyeeDTO) throws SQLException, ClassNotFoundException {
        return dao.save(emplyeeDTO);
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return dao.delete(Id);
    }

    @Override
    public boolean update(OrdersTM DTO) throws SQLException, ClassNotFoundException {
        return dao.update(DTO);
    }
}
