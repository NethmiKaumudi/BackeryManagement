package lk.ijse.BackeryManagement.to;

public class Vehicle {
    private String VehicleNo;
    private String VehicleDetails;

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, String vehicleDetails) {
        VehicleNo = vehicleNo;
        VehicleDetails = vehicleDetails;
    }

    public String getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        VehicleNo = vehicleNo;
    }

    public String getVehicleDetails() {
        return VehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        VehicleDetails = vehicleDetails;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleNo='" + VehicleNo + '\'' +
                ", VehicleDetails='" + VehicleDetails + '\'' +
                '}';
    }
}
