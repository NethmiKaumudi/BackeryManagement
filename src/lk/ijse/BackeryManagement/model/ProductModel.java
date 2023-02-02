package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.*;
import lk.ijse.BackeryManagement.util.Crudutil;
import lk.ijse.BackeryManagement.view.tm.ProductTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel {
    //Material Usage Form Load Product Ids
    public static ArrayList<String> loadProductIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT prId FROM product";
        ResultSet result = Crudutil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
    public static Product search(String prId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM product WHERE prId= ?";
        ResultSet result = Crudutil.execute(sql, prId);

        if (result.next()) {
            return new Product(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getInt(4)
            );
        }
        return null;
    }
    //Material Usage Update code
//    public static boolean updateQty(ArrayList<> cartDetails) throws SQLException, ClassNotFoundException {
//        for (CartDetail cartDetail : cartDetails) {
//            if (!updateQty(new Item(cartDetail.getCode(), cartDetail.getDescription(), cartDetail.getUnitPrice(), cartDetail.getQty()))) {
//                return false;
//            }
//        }
//        return true;
//    }

//    private static boolean updateQty(Product product) throws SQLException, ClassNotFoundException {
//        String sql = "UPDATE product SET Quantity= ? WHERE prId = ?";
//        return Crudutil.execute(sql, product.getQuantity(),product.getPrid());
//    }
public static boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
    String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
    return Crudutil.execute(sql, product.getPrid(), product.getProductName(), product.getUnitPrice(),product.getQuantity());
}
    public static boolean deleteProduct(Product product) throws SQLException, ClassNotFoundException {
        System.out.println(product.getPrid());
        String sql="Delete from product where prId=?";
        Object execute = Crudutil.execute(sql, product.getPrid());
        System.out.println(execute);

        return (boolean) execute;

    }
    public static Product searchProduct(String prId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM product WHERE prId = ?";
        ResultSet result = Crudutil.execute(sql, prId);

        if (result.next()) {
            return new Product(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getInt(4)

            );
        }
        return null;
    }
    public static boolean updateProduct(Product product) throws SQLException, ClassNotFoundException {
        String sql ="Update product SET product_name = ?,unit_price = ? ,Quantity=? WHERE prId= ?";
        return Crudutil.execute(sql,product.getProductName(),product.getUnitPrice(),product.getQuantity(),product.getPrid());

    }
    //Material Usage------>ekatu karanna na
    public static boolean updateProductQty(ArrayList<MaterialTable>materialdetails) throws SQLException, ClassNotFoundException {
        for (MaterialTable materialTable: materialdetails) {
            if (!updateProductQty(new Product(materialTable.getPrId(),materialTable.getProductName(),materialTable.getUnitPrice(),materialTable.getPrductqty()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateProductQty(Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product SET  Quantity =  Quantity + ? WHERE   prId = ?";
        return Crudutil.execute(sql, product.getQuantity(),product.getPrid());
    }

    //Deliverdetails --->adu karanna ona
    public static boolean updateProductQuantity(ArrayList<DeliveryDetailsTable>deliverydetails) throws SQLException, ClassNotFoundException {
        for (DeliveryDetailsTable deliveryDetailsTable: deliverydetails) {
            if (!updateProductQuantity(new Product(deliveryDetailsTable.getPrId(),deliveryDetailsTable.getProductName(),deliveryDetailsTable.getUnitPrice(),deliveryDetailsTable.getProductQty()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateProductQuantity(Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product SET  Quantity =  Quantity - ? WHERE   prId = ?";
        return Crudutil.execute(sql, product.getQuantity(),product.getPrid());
    }


}
