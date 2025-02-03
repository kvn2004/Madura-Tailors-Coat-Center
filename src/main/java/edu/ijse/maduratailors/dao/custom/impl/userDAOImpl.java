package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DB.DBConnection;
import edu.ijse.maduratailors.dao.custom.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAOImpl implements UserDAO {

    @Override
    public boolean checkUser(String user, String pwd) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "select * from users WHERE username = ? AND password_hash = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, user);
            ps.setString(2, pwd);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
