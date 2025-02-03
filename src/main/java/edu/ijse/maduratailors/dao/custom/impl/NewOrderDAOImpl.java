package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.DTO.OrderPaymentDTO;
import edu.ijse.maduratailors.DTO.ProductDTO;
import edu.ijse.maduratailors.dao.custom.NewOrderDAO;
import edu.ijse.maduratailors.dao.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewOrderDAOImpl implements NewOrderDAO {
    @Override
    public ArrayList<String> getID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT CustomerID FROM customer");
        ArrayList<String> list = new ArrayList<String>();
        while (rst.next()) {
            list.add(rst.getString(1));
        }
        return list;
    }

    @Override
    public ArrayList<CustomerMesurementDTO> getCustomerMeasurement(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT M.MeasurementID, CS.CustomerID, CS.Name, CS.Address, CS.Telephone, " + "M.NeckSize, M.ShoulderWidth, M.ChestSize, M.WaistSize, M.HipSize, " + "M.SleeveLength, M.ShirtLength, M.ThighSize, M.InseamLength, M.OutseamLength " + "FROM customer AS CS JOIN measurement AS M ON CS.CustomerID = M.CustomerID WHERE CS.CustomerID = ?";
        ResultSet rst = CrudUtil.execute(sql, id);
        ArrayList<CustomerMesurementDTO> objects = new ArrayList<>();
        while (rst.next()) {
            objects.add(new CustomerMesurementDTO(rst.getInt("MeasurementID"), rst.getInt("CustomerID"), rst.getString("Name"), rst.getString("Address"), rst.getString("Telephone"), rst.getDouble("NeckSize"), rst.getDouble("ShoulderWidth"), rst.getDouble("ChestSize"), rst.getDouble("WaistSize"), rst.getDouble("HipSize"), rst.getDouble("SleeveLength"), rst.getDouble("ShirtLength"), rst.getDouble("ThighSize"), rst.getDouble("InseamLength"), rst.getDouble("OutseamLength")));
        }
        return objects;
    }

    @Override
    public ArrayList<CustomerMesurementDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerMesurementDTO emplyeeDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        boolean result = false;

        try {
            System.out.println(customerMesurementDTO);
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean customerUpdated = CrudUtil.execute("UPDATE customer SET Name = ?, Address = ?, Telephone = ? WHERE CustomerID = ?", customerMesurementDTO.getName(), customerMesurementDTO.getAddress(), customerMesurementDTO.getTelephone(), customerMesurementDTO.getCustomerId());
            if (!customerUpdated) {
                throw new SQLException("Updating customer failed, no rows affected.");
            }
            boolean measurementUpdated = CrudUtil.execute("UPDATE measurement SET NeckSize = ?, ShoulderWidth = ?, ChestSize = ?, WaistSize = ?, HipSize = ?, SleeveLength = ?, ShirtLength = ?, ThighSize = ?, InseamLength = ?, OutseamLength = ? WHERE CustomerID = ?", customerMesurementDTO.getNeck(), customerMesurementDTO.getShoulder(), customerMesurementDTO.getChest(), customerMesurementDTO.getWaist(), customerMesurementDTO.getHip(), customerMesurementDTO.getSleeve(), customerMesurementDTO.getShirt(), customerMesurementDTO.getThigh(), customerMesurementDTO.getInseam(), customerMesurementDTO.getOutseam(), customerMesurementDTO.getCustomerId());

            if (!measurementUpdated) {
                throw new SQLException("Updating measurement failed, no rows affected.");
            }

            connection.commit();
            result = true;
        } catch (SQLException | ClassNotFoundException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return result;


    }

    @Override
    public ArrayList<String> getItemID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT product_id, category, price FROM products");
        ArrayList<String> list = new ArrayList<String>();
        while (rst.next()) {
            list.add(rst.getString(1));
        }
        return list;
    }

    @Override
    public ArrayList<ProductDTO> getItemDetails(int id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM products WHERE product_id = ?", id);
        ArrayList<ProductDTO> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new ProductDTO(rst.getInt(1), rst.getString(2), rst.getDouble(3)));
        }
        return list;
    }

    @Override
    public boolean pay(OrderPaymentDTO orderPaymentDTO) {
        System.out.println("Method called with: " + orderPaymentDTO);
        Connection connection = null;
        boolean result = false;

        try {

            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            ResultSet rst = CrudUtil.executeAndReturnGeneratedKeys("INSERT INTO orders (CustomerID, OrderType, OrderDate, DueDate, Design, Price, Quantity) VALUES (?, ?, ?, ?, ?, ?, ?)", orderPaymentDTO.getCustomerID(), orderPaymentDTO.getOrderType(), orderPaymentDTO.getOrderDate(), orderPaymentDTO.getDueDate(), orderPaymentDTO.getDesign(), orderPaymentDTO.getPrice(), orderPaymentDTO.getQuantity());
            int orderID;
            if (rst.next()) {
                orderID = rst.getInt(1);
            } else {
                throw new SQLException("Inserting into orders failed, no rows affected.");
            }

            ResultSet set = CrudUtil.executeAndReturnGeneratedKeys("INSERT INTO payments (order_id, payment_date, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)", orderID, orderPaymentDTO.getPaymentDate(), orderPaymentDTO.getAmount(), orderPaymentDTO.getPaymentMethod(), orderPaymentDTO.getStatus());
            int paymentID;
            if (set.next()) {
                paymentID = set.getInt(1);
            } else {
                throw new SQLException("Inserting into payments failed, no rows affected.");
            }

            boolean orderDetailUpdated = CrudUtil.execute("INSERT INTO order_details (order_id, payment_id) VALUES (?, ?)", orderID, paymentID);
            if (!orderDetailUpdated) {
                throw new SQLException("Inserting into order_details failed, no rows affected.");
            }

            if ("Rent".equalsIgnoreCase(orderPaymentDTO.getOrderType())) {
                boolean orderItemUpdated = CrudUtil.execute("INSERT INTO orderitems (order_id, product_id) VALUES (?, ?)", orderID, orderPaymentDTO.getItemID());
                if (!orderItemUpdated) {
                    throw new SQLException("Inserting into order_items failed, no rows affected.");
                }
            }

            connection.commit();
            result = true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

}
