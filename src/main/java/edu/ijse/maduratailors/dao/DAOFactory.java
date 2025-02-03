package edu.ijse.maduratailors.dao;

import edu.ijse.maduratailors.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory instance;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public enum DAOTypes {
        CUSTOMER, DASH_BOARD_PANEL, NEW_ORDER, EMPLOYEE, PAYMENT, USER, MEASUREMENT
    }

    public SuperDAO getDAO(DAOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case DASH_BOARD_PANEL:
                return new DashboardPanelDAOImpl();
            case NEW_ORDER:
                return new NewOrderDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case USER:
                return new CustomerDAOImpl();
            case MEASUREMENT:
                return new MesurementDAOImpl();
            default:
                return null;
        }
    }
}
