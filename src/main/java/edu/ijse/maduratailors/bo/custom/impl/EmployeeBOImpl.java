package edu.ijse.maduratailors.bo.custom.impl;

import edu.ijse.maduratailors.DTO.EmplyeeDTO;
import edu.ijse.maduratailors.bo.custom.EmployeeBO;
import edu.ijse.maduratailors.dao.DAOFactory;
import edu.ijse.maduratailors.dao.custom.EmployeeDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmplyeeDTO> getAll() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAll();
    }

    @Override
    public boolean save(EmplyeeDTO emplyeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(emplyeeDTO);
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(Id);
    }

    @Override
    public boolean update(EmplyeeDTO DTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(DTO);
    }
}
