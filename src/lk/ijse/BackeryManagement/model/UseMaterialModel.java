package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.db.DBConnection;
import lk.ijse.BackeryManagement.to.Product;
import lk.ijse.BackeryManagement.to.UseMaterial;

import java.sql.SQLException;
import java.util.ArrayList;

public class UseMaterialModel {

public static boolean useMaterial(UseMaterial useMaterial) throws SQLException, ClassNotFoundException {
    try {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
        boolean isProductUpdated = ProductModel.updateProductQty(useMaterial.getMaterialUsage());
     if (isProductUpdated) {
          boolean isUpdated = MaterialStockModel.updateQty(useMaterial.getMaterialUsage());
          if (isUpdated) {
              boolean isMaterialUsageAdded = MaterialUsageModel.saveMaterialUsgae(useMaterial.getMaterialUsage());
             if (isMaterialUsageAdded) {
                   DBConnection.getInstance().getConnection().commit();
                   return true;
                }
           }
    }
        DBConnection.getInstance().getConnection().rollback();
        return false;
    } finally {
       DBConnection.getInstance().getConnection().setAutoCommit(true);
   }
}
}
