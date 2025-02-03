package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudDAO;

import java.sql.SQLException;

public interface MesurementDAO extends CrudDAO {
    public boolean saveMeasurement(int customerId, CustomerMesurementDTO customerMesurementDTO) throws SQLException, ClassNotFoundException;
}
