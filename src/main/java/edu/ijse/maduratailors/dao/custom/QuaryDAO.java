package edu.ijse.maduratailors.dao.custom;

import edu.ijse.maduratailors.DTO.CustomerMesurementDTO;
import edu.ijse.maduratailors.dao.CrudUtil;
import edu.ijse.maduratailors.dao.SuperDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    public ArrayList<CustomerMesurementDTO> getAll();
}
