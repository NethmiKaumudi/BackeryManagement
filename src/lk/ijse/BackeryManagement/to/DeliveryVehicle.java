package lk.ijse.BackeryManagement.to;

import java.util.ArrayList;

public class DeliveryVehicle {
    private String date;
    private String vehicleNo;
    private ArrayList<DeliveryDetailsTable>deliveryDetails;

    public DeliveryVehicle() {
    }

    public DeliveryVehicle(String date, String vehicleNo, ArrayList<DeliveryDetailsTable> deliveryDetails) {
        this.date = date;
        this.vehicleNo = vehicleNo;
        this.deliveryDetails = deliveryDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public ArrayList<DeliveryDetailsTable> getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(ArrayList<DeliveryDetailsTable> deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    @Override
    public String toString() {
        return "DeliveryVehicle{" +
                "date='" + date + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", deliveryDetails=" + deliveryDetails +
                '}';
    }
}
