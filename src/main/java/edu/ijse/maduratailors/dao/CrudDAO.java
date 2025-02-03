package edu.ijse.maduratailors.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> extends SuperDAO{
    ArrayList<T> getAll() throws SQLException ,ClassNotFoundException;

    boolean save(T emplyeeDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String Id) throws SQLException, ClassNotFoundException;

    boolean update(T DTO) throws SQLException, ClassNotFoundException;
}
