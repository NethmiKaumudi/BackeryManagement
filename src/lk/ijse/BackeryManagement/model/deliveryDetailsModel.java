package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.DeliveryDetailsTable;
import lk.ijse.BackeryManagement.util.Crudutil;

import java.sql.SQLException;
import java.util.ArrayList;

public class deliveryDetailsModel {
    //Add delivery Details
    public static boolean saveDeliveryDetails(ArrayList<DeliveryDetailsTable> deliveryDetailsTable) throws SQLException, ClassNotFoundException {
        for (DeliveryDetailsTable deliveryDetailsTables : deliveryDetailsTable) {
            if (!save(deliveryDetailsTables)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(DeliveryDetailsTable deliveryDetailsTable) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO delivery_detail VALUES(?, ?, ?, ?,?)";
        return Crudutil.execute(sql,deliveryDetailsTable.getDate(),deliveryDetailsTable.getVehicleNo(),deliveryDetailsTable.getPrId(),deliveryDetailsTable.getUnitPrice(),deliveryDetailsTable.getProductQty());
    }
}
