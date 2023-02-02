package lk.ijse.BackeryManagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BackeryManagement.db.DBConnection;
import lk.ijse.BackeryManagement.model.EmployeeModel;
import lk.ijse.BackeryManagement.model.ProductModel;
import lk.ijse.BackeryManagement.model.VehicleModel;
import lk.ijse.BackeryManagement.to.Employee;
import lk.ijse.BackeryManagement.to.Product;
import lk.ijse.BackeryManagement.to.Vehicle;
import lk.ijse.BackeryManagement.util.Navigation;
import lk.ijse.BackeryManagement.util.Routes;
import lk.ijse.BackeryManagement.view.tm.EmployeeTM;
import lk.ijse.BackeryManagement.view.tm.VehicleTm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleFormController {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtvNo;

    @FXML
    private JFXTextField txtVehicleDetails;

    @FXML
    private TableView<VehicleTm> tblVehicle;

    @FXML
    private TableColumn<?, ?> ColvNo;

    @FXML
    private TableColumn<?, ?> ColDetals;
    @FXML
    private JFXTextField txtSearch;
    private String searchText = "";


    public void initialize(){
        ColvNo.setCellValueFactory(new PropertyValueFactory<>("VehicleNo"));
        ColDetals.setCellValueFactory(new PropertyValueFactory<>("VehicleDetails"));

        tableView(searchText);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText=newValue;
            tableView(searchText);
        });
    }
    private void tableView(String text){
         String searchText = "%" + text + "%";
        try {
            ObservableList<VehicleTm> tmList = FXCollections.observableArrayList();

            Connection connection = DBConnection.getInstance().getConnection();
          //  String sql = "SELECT *FROM vehicle;";
            String sql = "SELECT * From vehicle WHERE   vNo LIKE ?||details LIKE ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,searchText);
            statement.setString(2,searchText);

            ResultSet set = statement.executeQuery();

            while (set.next()){
              VehicleTm vehicleTm=new VehicleTm(
                        set.getString(1),
                        set.getString(2)
                );
                tmList.add(vehicleTm);
            }

            tblVehicle.setItems(tmList);

        } catch (ClassNotFoundException | SQLException e)  {
            System.out.println(e);
        }
    }

    @FXML
    void adbtnOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String VehicleNo=txtvNo.getText();
        String VehicleDetails=txtVehicleDetails.getText();

        Vehicle vehicle=new Vehicle(VehicleNo,VehicleDetails);
        boolean isAdded = VehicleModel.addVehicle(vehicle);
    tableView(searchText);
        if (isAdded) {
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }


    }
    private void clearFields(){
        txtvNo.clear();
        txtVehicleDetails.clear();
    }



    @FXML
    void backbtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUMMARYFORM,pane);
    }

    @FXML
    void deletebtnOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String VehicleNo= txtvNo.getText();
        Vehicle vehicle=new Vehicle();
        vehicle.setVehicleNo(VehicleNo);
        boolean isDeleted = VehicleModel.deleteVehicle(vehicle);
        tableView(searchText);
        if (isDeleted) {
            // System.out.println("Deleted");
            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Deleted!").show();
        }else{
            //System.out.println("Somthing Happend");
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
        }

    }


    @FXML
    void updatebtnOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String vNo=txtvNo.getText();
        String VehicleDetails=txtVehicleDetails.getText();
        Vehicle vehicle=new Vehicle(vNo,VehicleDetails);
        boolean isUpdate =VehicleModel.updateVehicle(vehicle);
        if (isUpdate) {
            // System.out.println("Updated");
            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Details Updated!").show();

        }else{
            // System.out.println("Not");
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();

        }
        tableView(searchText);
        clearFields();
    }
    @FXML
    void vNoOnAction(ActionEvent event) {

        String VehicleNo= txtvNo.getText();
        try {
            Vehicle vehicle=VehicleModel.searchvehicle(VehicleNo);
            if (vehicle != null) {
                fillData(vehicle);
                // System.out.println( "Fill");
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle  Detailes Searched and filled  Fields succesfully!").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void fillData(Vehicle vehicle) {
        txtvNo.setText(vehicle.getVehicleNo());
        txtVehicleDetails.setText(vehicle.getVehicleDetails());
    }




}
