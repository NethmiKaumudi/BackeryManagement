package lk.ijse.BackeryManagement.model;

import lk.ijse.BackeryManagement.to.Employee;
import lk.ijse.BackeryManagement.util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
    String sql = "INSERT INTO employee VALUES (?, ?, ?, ?,?,?,?)";
    return Crudutil.execute(sql,employee.getNic(),employee.getName(),employee.getAddress(),employee.getLicenceNo(),employee.getContact(),employee.getPosition(),employee.getBasicSalary());

}
    public static boolean deleteEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        System.out.println(employee.getNic());
        String sql="Delete from employee where nIc=?";
        Object execute = Crudutil.execute(sql, employee.getNic());
        System.out.println(execute);

        return (boolean) execute;

}

   public static Employee searchEmployee(String Nic) throws SQLException, ClassNotFoundException {
    String sql = "SELECT  * FROM employee WHERE nIc = ?";
    ResultSet result = Crudutil.execute(sql, Nic);

    if (result.next()) {
        return new Employee(
                result.getString(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getInt(5),
                result.getString(6),
                result.getDouble(7)

        );
    }
    return null;
}
public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
     String sql ="Update employee SET name  = ?, address = ? ,vehicle_licance_number=? ,contact=? ,position=?, basic_salary=? WHERE nIc= ?";
     return Crudutil.execute(sql,employee.getName(),employee.getAddress(),employee.getLicenceNo(),employee.getContact(),employee.getPosition(),employee.getBasicSalary(),employee.getNic());

}
    public static ArrayList<String> loadEmployeeNics() throws SQLException, ClassNotFoundException {
        String sql = "SELECT nIc FROM employee";
        ResultSet result = Crudutil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }
}
