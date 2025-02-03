package edu.ijse.maduratailors.dao.custom.impl;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudUtil;
import edu.ijse.maduratailors.dao.custom.MesurementDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MesurementDAOImpl implements MesurementDAO {
    CustomerMesurementDTO customerMesurementDTO = new CustomerMesurementDTO();

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Object emplyeeDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Object DTO) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public boolean saveMeasurement(int customerId, CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO measurement (CustomerID, NeckSize, ShoulderWidth, ChestSize, WaistSize, HipSize, SleeveLength, ShirtLength, ThighSize, InseamLength, OutseamLength) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                customerId,
                customerMesurementDTO.getNeck(),
                customerMesurementDTO.getShoulder(),
                customerMesurementDTO.getChest(),
                customerMesurementDTO.getWaist(),
                customerMesurementDTO.getHip(),
                customerMesurementDTO.getSleeve(),
                customerMesurementDTO.getShirt(),
                customerMesurementDTO.getThigh(),
                customerMesurementDTO.getInseam(),
                customerMesurementDTO.getOutseam()
        );
    }
}
