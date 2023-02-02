package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.Employee;
import lk.ijse.BackeryManagement.to.MaterialStock;
import lk.ijse.BackeryManagement.to.MaterialTable;
import lk.ijse.BackeryManagement.to.Product;
import lk.ijse.BackeryManagement.util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialStockModel {
    //Material usage form load ids
    public static ArrayList<String> loadMaterialIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT mId FROM material_stock ";
        ResultSet result = Crudutil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
    public static MaterialStock search(String mId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM material_stock WHERE mId= ?";
        ResultSet result = Crudutil.execute(sql,mId);

        if (result.next()) {
            return new MaterialStock(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }
    public static boolean updateQty(ArrayList<MaterialTable> materialDetails) throws SQLException, ClassNotFoundException {
        for (MaterialTable materialTable: materialDetails) {
            if (!updateQty(new MaterialStock(materialTable.getId(), materialTable.getMaterialtype(), materialTable.getUserId(), materialTable.getMaterialqty()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(MaterialStock materialStock) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE material_stock SET quantity = quantity - ? WHERE  mId = ?";
        return Crudutil.execute(sql, materialStock.getQuantity(), materialStock.getMid());
    }
    //material stock form
    public static boolean addMaterialStock(MaterialStock materialStock) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO material_stock  VALUES (?, ?, ?, ?)";
        return Crudutil.execute(sql,materialStock.getMid(),materialStock.getMaterialType(),materialStock.getQuantity(),materialStock.getUid());

    }

    public static boolean deleteMaterialStock(MaterialStock materialStock) throws SQLException, ClassNotFoundException {
        System.out.println(materialStock.getMid());
        String sql="Delete from material_stock where  mId=?";
        Object execute = Crudutil.execute(sql, materialStock.getMid());
        System.out.println(execute);

        return (boolean) execute;

    }
    public static MaterialStock searchMaterial(String Id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM material_stock WHERE mId = ?";
        ResultSet result = Crudutil.execute(sql, Id);

        if (result.next()) {
            return new MaterialStock(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }
    //update materialstock Details
    public static boolean updateMaterial(MaterialStock materialStock) throws SQLException, ClassNotFoundException {
        String sql ="Update material_stock SET  material_type =?, quantity=?, uId=? WHERE mId=?";
        return Crudutil.execute(sql,materialStock.getMaterialType(),materialStock.getQuantity(),materialStock.getUid(),materialStock.getMid());

    }

}
