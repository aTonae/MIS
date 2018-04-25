package mis.oblabs.com.mis.models;


/**
 * Created by ato on 26/11/17.
 */



public class ModelAttendance
{
    private String User_Name;

    private String Attend_Date;

    private String Attend_Type;

    private String Date_Modified;

    private String Status;

    private String Week_No;

    private String AttendUser_Name;

    private String Date_Added;

    private String AttendType_Idno;

    private String AttendByUser_Idno;

    private String RemarkBy_User;

    private String AttendByUser_Remark;

    private String Remark;

    private String Is_Checked;

    private String User_Idno;

    private String AttendDetail_Idno;

    public String getUser_Name ()
    {
        return User_Name;
    }

    public void setUser_Name (String User_Name)
    {
        this.User_Name = User_Name;
    }

    public String getAttend_Date ()
    {
        return Attend_Date;
    }

    public void setAttend_Date (String Attend_Date)
    {
        this.Attend_Date = Attend_Date;
    }

    public String getAttend_Type ()
    {
        return Attend_Type;
    }

    public void setAttend_Type (String Attend_Type)
    {
        this.Attend_Type = Attend_Type;
    }

    public String getDate_Modified ()
    {
        return Date_Modified;
    }

    public void setDate_Modified (String Date_Modified)
    {
        this.Date_Modified = Date_Modified;
    }

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getWeek_No ()
    {
        return Week_No;
    }

    public void setWeek_No (String Week_No)
    {
        this.Week_No = Week_No;
    }

    public String getAttendUser_Name ()
    {
        return AttendUser_Name;
    }

    public void setAttendUser_Name (String AttendUser_Name)
    {
        this.AttendUser_Name = AttendUser_Name;
    }

    public String getDate_Added ()
    {
        return Date_Added;
    }

    public void setDate_Added (String Date_Added)
    {
        this.Date_Added = Date_Added;
    }

    public String getAttendType_Idno ()
    {
        return AttendType_Idno;
    }

    public void setAttendType_Idno (String AttendType_Idno)
    {
        this.AttendType_Idno = AttendType_Idno;
    }

    public String getAttendByUser_Idno ()
    {
        return AttendByUser_Idno;
    }

    public void setAttendByUser_Idno (String AttendByUser_Idno)
    {
        this.AttendByUser_Idno = AttendByUser_Idno;
    }

    public String getRemarkBy_User ()
    {
        return RemarkBy_User;
    }

    public void setRemarkBy_User (String RemarkBy_User)
    {
        this.RemarkBy_User = RemarkBy_User;
    }

    public String getAttendByUser_Remark ()
    {
        return AttendByUser_Remark;
    }

    public void setAttendByUser_Remark (String AttendByUser_Remark)
    {
        this.AttendByUser_Remark = AttendByUser_Remark;
    }

    public String getRemark ()
    {
        return Remark;
    }

    public void setRemark (String Remark)
    {
        this.Remark = Remark;
    }

    public String getIs_Checked ()
    {
        return Is_Checked;
    }

    public void setIs_Checked (String Is_Checked)
    {
        this.Is_Checked = Is_Checked;
    }

    public String getUser_Idno ()
    {
        return User_Idno;
    }

    public void setUser_Idno (String User_Idno)
    {
        this.User_Idno = User_Idno;
    }

    public String getAttendDetail_Idno ()
    {
        return AttendDetail_Idno;
    }

    public void setAttendDetail_Idno (String AttendDetail_Idno)
    {
        this.AttendDetail_Idno = AttendDetail_Idno;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [User_Name = "+User_Name+", Attend_Date = "+Attend_Date+", Attend_Type = "+Attend_Type+", Date_Modified = "+Date_Modified+", Status = "+Status+", Week_No = "+Week_No+", AttendUser_Name = "+AttendUser_Name+", Date_Added = "+Date_Added+", AttendType_Idno = "+AttendType_Idno+", AttendByUser_Idno = "+AttendByUser_Idno+", RemarkBy_User = "+RemarkBy_User+", AttendByUser_Remark = "+AttendByUser_Remark+", Remark = "+Remark+", Is_Checked = "+Is_Checked+", User_Idno = "+User_Idno+", AttendDetail_Idno = "+AttendDetail_Idno+"]";
    }
}
