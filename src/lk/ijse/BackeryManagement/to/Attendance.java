package lk.ijse.BackeryManagement.to;

import java.sql.Time;
import java.util.Date;

public class Attendance {
    private String date;
    private String attendance;
    private String Nic;

    public Attendance() {
    }

    public Attendance(String date, String attendance, String nic) {
        this.date = date;
        this.attendance = attendance;
        Nic = nic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }
}
