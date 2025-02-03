package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudUtil;
import edu.ijse.maduratailors.dao.custom.QuaryDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QuaryDAO {
    @Override
    public ArrayList<CustomerMesurementDTO> getAll() {
        try {
            String SQL = "SELECT CS.CustomerID, M.MeasurementID, CS.Name, CS.Address, CS.Telephone, " +
                    "M.NeckSize, M.ShoulderWidth, M.ChestSize, M.WaistSize, M.HipSize, " +
                    "M.SleeveLength, M.ShirtLength, M.ThighSize, M.InseamLength, M.OutseamLength " +
                    "FROM customer AS CS JOIN measurement AS M ON CS.CustomerID = M.CustomerID";
            ResultSet rst = CrudUtil.execute(SQL);
            ArrayList<CustomerMesurementDTO> objects = new ArrayList<>();
            while (rst.next()) {
                objects.add(new CustomerMesurementDTO(
                        rst.getInt("MeasurementID"),
                        rst.getInt("CustomerID"),
                        rst.getString("Name"),
                        rst.getString("Address"),
                        rst.getString("Telephone"),
                        rst.getDouble("NeckSize"),
                        rst.getDouble("ShoulderWidth"),
                        rst.getDouble("ChestSize"),
                        rst.getDouble("WaistSize"),
                        rst.getDouble("HipSize"),
                        rst.getDouble("SleeveLength"),
                        rst.getDouble("ShirtLength"),
                        rst.getDouble("ThighSize"),
                        rst.getDouble("InseamLength"),
                        rst.getDouble("OutseamLength")
                ));
            }
            return objects;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
