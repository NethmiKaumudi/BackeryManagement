package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.db.DBConnection;
import lk.ijse.BackeryManagement.to.MaterialTable;
import lk.ijse.BackeryManagement.to.Product;
import lk.ijse.BackeryManagement.to.UseMaterial;
import lk.ijse.BackeryManagement.util.Crudutil;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MaterialUsageModel {
    public static boolean saveMaterialUsgae(ArrayList<MaterialTable> materialusage) throws SQLException, ClassNotFoundException {
        for (MaterialTable materialTable : materialusage) {
           // System.out.println(materialTable);
            if (!save(materialTable)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(MaterialTable materialTable) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO material_usage VALUES(?, ?, ?, ?)";
      //  System.out.println(materialTable.getMaterialqty());
        return Crudutil.execute(sql,materialTable.getDate(),materialTable.getUserId(),materialTable.getId(),materialTable.getPrId());
    }


}
