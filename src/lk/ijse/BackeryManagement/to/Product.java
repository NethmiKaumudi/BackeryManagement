package lk.ijse.BackeryManagement.to;

public class Product {
    private String Prid;
    private String ProductName;
    private Double UnitPrice;
    private int Quantity;


    public Product() {

    }

    public Product(String prid, String productName, Double unitPrice, int quantity) {
        Prid = prid;
        ProductName = productName;
        UnitPrice = unitPrice;
        Quantity = quantity;
    }

    public String getPrid() {
        return Prid;
    }

    public void setPrid(String prid) {
        Prid = prid;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
