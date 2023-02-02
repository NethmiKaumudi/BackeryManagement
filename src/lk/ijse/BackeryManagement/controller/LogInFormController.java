package lk.ijse.BackeryManagement.controller;

import animatefx.animation.BounceIn;
import animatefx.animation.ZoomIn;
import animatefx.animation.ZoomOutUp;
import com.jfoenix.controls.JFXTextField;
import com.sun.scenario.effect.ZoomRadialBlur;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.BackeryManagement.db.DBConnection;
import lk.ijse.BackeryManagement.model.MaterialStockModel;
import lk.ijse.BackeryManagement.model.SignUpModel;
import lk.ijse.BackeryManagement.to.MaterialStock;
import lk.ijse.BackeryManagement.to.User;
import lk.ijse.BackeryManagement.util.Crudutil;
import lk.ijse.BackeryManagement.util.Navigation;
import lk.ijse.BackeryManagement.util.Routes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInFormController {

    @FXML
    private AnchorPane pane2;


    @FXML
    private JFXTextField txtuserName;

    @FXML
    private JFXTextField txtPassWord;
    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnLogIn;
    public static int status;

    @FXML
    void loginbtnOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

//            if (txtuserName.getText().isEmpty()==false && txtPassWord.getText().isEmpty()==false) {
//                validateLogin();
//                Navigation.navigate(Routes.DASHBOARDFORM,pane2);
//
//            } else {
//                new Alert(Alert.AlertType.WARNING, " Please Enter username or password!").show();
//            }
        Navigation.navigate(Routes.DASHBOARDFORM,pane2);

    }

    public  void validateLogin() throws SQLException, ClassNotFoundException, IOException {
        String sql="SELECT count(1) FROM user WHERE user_name='"+txtuserName.getText()+"'AND password ='"+txtPassWord.getText()+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            if(resultSet.getInt(1)==1){
                new Alert(Alert.AlertType.CONFIRMATION, "Welcome!").show();
               Navigation.navigate(Routes.DASHBOARDFORM,pane2);
            }else{
                new Alert(Alert.AlertType.WARNING, "Invalid login,Try again!").show();
            }
        }
    }

    @FXML
    void signupbtnOnAction(ActionEvent event) throws IOException {
        new ZoomIn(btnSignUp).play();
    Navigation.navigate(Routes.SIGNUPFORM,pane2);
    }
    @FXML
    void cancelbtnOnAction(ActionEvent event) {
    System.exit(0);
    }

}


