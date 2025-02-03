package edu.ijse.maduratailors.bo;

import edu.ijse.maduratailors.bo.custom.impl.*;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory =
                new BOFactory() : boFactory;

    }

    public enum BOTypes {
        CUSTOMER, DASH_BOARD_PANEL, NEW_ORDER, EMPLOYEE, PAYMENT, USER
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case DASH_BOARD_PANEL:
                return new DashboardPanelBOImpl();
            case NEW_ORDER:
                return new NewOrderBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
//            case USER:
//                return new CustomerDAOImpl();
            default:
                return null;
        }
    }
}
