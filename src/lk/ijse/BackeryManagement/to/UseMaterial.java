package lk.ijse.BackeryManagement.to;

import lk.ijse.BackeryManagement.view.tm.ProductTm;

import java.util.ArrayList;

public class UseMaterial {
     private String date;
     private ArrayList<MaterialTable>MaterialUsage;

    public UseMaterial() {
    }

    public UseMaterial(String date, ArrayList<MaterialTable> materialUsage) {
        this.date = date;
        MaterialUsage = materialUsage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<MaterialTable> getMaterialUsage() {
        return MaterialUsage;
    }

    public void setMaterialUsage(ArrayList<MaterialTable> materialUsage) {
        MaterialUsage = materialUsage;
    }
}
