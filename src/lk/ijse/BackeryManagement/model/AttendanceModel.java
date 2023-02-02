package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.Attendance;
import lk.ijse.BackeryManagement.to.Employee;
import lk.ijse.BackeryManagement.to.MaterialStock;
import lk.ijse.BackeryManagement.to.Payroll;
import lk.ijse.BackeryManagement.util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceModel {
    public static boolean addAttendance(Attendance attendance) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO attendance VALUES (?, ?, ?)";
        return Crudutil.execute(sql,attendance.getDate(),attendance.getAttendance(),attendance.getNic());

    }

    public static boolean deleteAttendance(Attendance attendance) throws SQLException, ClassNotFoundException {

        String sql="Delete from attendance where date=? and nIc=?";
        Object execute = Crudutil.execute(sql,attendance.getDate(),attendance.getNic());
        System.out.println(execute);

        return (boolean) execute;

    }
    public static Attendance searchAttendance(String date,String nIc) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM attendance WHERE date=? and nIc=?";
        ResultSet result = Crudutil.execute(sql,date,nIc);

        if (result.next()) {
            return new Attendance(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3)
            );
        }
        return null;
    }

    public static boolean updateAttendance(Attendance attendance) throws SQLException, ClassNotFoundException {
        String sql ="Update attendance SET attendance=? WHERE date= ? and nIc=?";
        return Crudutil.execute(sql,attendance.getAttendance(),attendance.getDate(),attendance.getNic());

    }
}
