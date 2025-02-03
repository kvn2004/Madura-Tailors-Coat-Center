package edu.ijse.maduratailors.bo.custom;

import edu.ijse.maduratailors.DTO.EmplyeeDTO;
import edu.ijse.maduratailors.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    ArrayList<EmplyeeDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(EmplyeeDTO emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(EmplyeeDTO DTO) throws SQLException, ClassNotFoundException;
}
