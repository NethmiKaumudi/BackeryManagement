package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.Employee;
import lk.ijse.BackeryManagement.to.Product;
import lk.ijse.BackeryManagement.to.User;
import lk.ijse.BackeryManagement.util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpModel {
    public static boolean signinUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO  user VALUES (?, ?, ?, ?,?)";
        return Crudutil.execute(sql,user.getUid(),user.getUserName(),user.getPassWord(),user.getEmail(),user.getNic());
    }
//   public static User ConfirmUser(String uId) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT  * FROM user WHERE   user_name= ? and password=?";
//        ResultSet result = Crudutil.execute(sql, uId);
//
//        if (result.next()) {
//            return new User(
//                    result.getString(1),
//                    result.getString(2),
//                    result.getString(3),
//                    result.getString(4),
//                    result.getString(5)
//
//            );
//        }
//        return null;
//    }

    }
