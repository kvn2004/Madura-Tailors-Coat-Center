package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.DTO.EmplyeeDTO;
import edu.ijse.maduratailors.dao.custom.EmployeeDAO;
import edu.ijse.maduratailors.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<EmplyeeDTO> getAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rst = preparedStatement.executeQuery();
            ArrayList<EmplyeeDTO> objects = new ArrayList<>();
            while (rst.next()) {
                EmplyeeDTO emplyeeDTO = new EmplyeeDTO(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getDate(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8)
                );
                objects.add(emplyeeDTO);
            }
            return objects;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(EmplyeeDTO emplyeeDTO) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("INSERT INTO employee (FirstName, MiddleName, LastName, DOB, Bank, AccountNumber, Telephone) VALUES (?, ?, ?, ?, ?, ?, ?)",
                emplyeeDTO.getFName(),
                emplyeeDTO.getMName(),
                emplyeeDTO.getLName(),
                emplyeeDTO.getDob(),
                emplyeeDTO.getBank(),
                emplyeeDTO.getAccountNumber(),
                emplyeeDTO.getPhone());
    }


    @Override
    public boolean delete(String employeeId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM employee WHERE EmployeeID = ?", employeeId);
    }

    @Override
    public boolean update(EmplyeeDTO emplyeeDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE employee SET FirstName = ?, MiddleName = ?, LastName = ?, DOB = ?, Bank = ?, AccountNumber = ?, Telephone = ? WHERE EmployeeID = ?",
                emplyeeDTO.getFName(),
                emplyeeDTO.getMName(),
                emplyeeDTO.getLName(),
                emplyeeDTO.getDob(),
                emplyeeDTO.getBank(),
                emplyeeDTO.getAccountNumber(),
                emplyeeDTO.getPhone(),
                emplyeeDTO.getId()
        );
    }
}
