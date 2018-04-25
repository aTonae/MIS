package mis.oblabs.com.mis.models;

/**
 * Created by ato on 10/01/18.
 */

public class ObjectCH {

    private String User_Name;

    private String Desig_Name;

    private String EmpCh_Idno;

    private String Year_Idno;

    private String Dept_Name;

    private String Attend_Type;

    private String Status;

    private String EmpCh_Date;

    private String Emp_Idno;

    private String Email;

    private String AdminRemark;

    private String Remark;

    private String Submit_Date;

    public String getUser_Name ()
    {
        return User_Name;
    }

    public void setUser_Name (String User_Name)
    {
        this.User_Name = User_Name;
    }

    public String getDesig_Name ()
    {
        return Desig_Name;
    }

    public void setDesig_Name (String Desig_Name)
    {
        this.Desig_Name = Desig_Name;
    }

    public String getEmpCh_Idno ()
    {
        return EmpCh_Idno;
    }

    public void setEmpCh_Idno (String EmpCh_Idno)
    {
        this.EmpCh_Idno = EmpCh_Idno;
    }

    public String getYear_Idno ()
    {
        return Year_Idno;
    }

    public void setYear_Idno (String Year_Idno)
    {
        this.Year_Idno = Year_Idno;
    }

    public String getDept_Name ()
    {
        return Dept_Name;
    }

    public void setDept_Name (String Dept_Name)
    {
        this.Dept_Name = Dept_Name;
    }

    public String getAttend_Type ()
    {
        return Attend_Type;
    }

    public void setAttend_Type (String Attend_Type)
    {
        this.Attend_Type = Attend_Type;
    }

    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getEmpCh_Date ()
    {
        return EmpCh_Date;
    }

    public void setEmpCh_Date (String EmpCh_Date)
    {
        this.EmpCh_Date = EmpCh_Date;
    }

    public String getEmp_Idno ()
    {
        return Emp_Idno;
    }

    public void setEmp_Idno (String Emp_Idno)
    {
        this.Emp_Idno = Emp_Idno;
    }

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

    public String getAdminRemark ()
    {
        return AdminRemark;
    }

    public void setAdminRemark (String AdminRemark)
    {
        this.AdminRemark = AdminRemark;
    }

    public String getRemark ()
    {
        return Remark;
    }

    public void setRemark (String Remark)
    {
        this.Remark = Remark;
    }

    public String getSubmit_Date ()
    {
        return Submit_Date;
    }

    public void setSubmit_Date (String Submit_Date)
    {
        this.Submit_Date = Submit_Date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [User_Name = "+User_Name+", Desig_Name = "+Desig_Name+", EmpCh_Idno = "+EmpCh_Idno+", Year_Idno = "+Year_Idno+", Dept_Name = "+Dept_Name+", Attend_Type = "+Attend_Type+", Status = "+Status+", EmpCh_Date = "+EmpCh_Date+", Emp_Idno = "+Emp_Idno+", Email = "+Email+", AdminRemark = "+AdminRemark+", Remark = "+Remark+", Submit_Date = "+Submit_Date+"]";
    }
}
