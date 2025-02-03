package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO {
    boolean checkUser(String user, String pwd);
}
