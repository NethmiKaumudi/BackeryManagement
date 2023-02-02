package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.db.DBConnection;
import lk.ijse.BackeryManagement.to.DeliveryVehicle;

import java.sql.SQLException;

public class DeliveryVehicleModel {
    public static boolean deliveryVehicles(DeliveryVehicle deliveryVehicle) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isUpdated = ProductModel.updateProductQuantity(deliveryVehicle.getDeliveryDetails());
            if (isUpdated) {
                boolean isdeliveryDetailAdded = deliveryDetailsModel.saveDeliveryDetails(deliveryVehicle.getDeliveryDetails());
                if (isdeliveryDetailAdded) {
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            // }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
