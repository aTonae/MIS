package mis.oblabs.com.mis.models;

public class ModelLeave
{
    private String LeaveType;

    private String DepartName;

    private String IsAccepted;

    private String Remarks;

    private String Year_Idno;

    private String UserEmail;

    private String UserIdno;

    private String LeaveTO;

    private String SubmitDate;

    private String isavail;

    private String LeaveFrom;

    private String Username;

    private String LeaveReason;

    private String DesignName;

    private String NofDays;

    private String LeaveIdno;

    public String getLeaveType ()
    {
        return LeaveType;
    }

    public void setLeaveType (String LeaveType)
    {
        this.LeaveType = LeaveType;
    }

    public String getDepartName ()
    {
        return DepartName;
    }

    public void setDepartName (String DepartName)
    {
        this.DepartName = DepartName;
    }

    public String getIsAccepted ()
    {
        return IsAccepted;
    }

    public void setIsAccepted (String IsAccepted)
    {
        this.IsAccepted = IsAccepted;
    }

    public String getRemarks ()
    {
        return Remarks;
    }

    public void setRemarks (String Remarks)
    {
        this.Remarks = Remarks;
    }

    public String getYear_Idno ()
    {
        return Year_Idno;
    }

    public void setYear_Idno (String Year_Idno)
    {
        this.Year_Idno = Year_Idno;
    }

    public String getUserEmail ()
    {
        return UserEmail;
    }

    public void setUserEmail (String UserEmail)
    {
        this.UserEmail = UserEmail;
    }

    public String getUserIdno ()
    {
        return UserIdno;
    }

    public void setUserIdno (String UserIdno)
    {
        this.UserIdno = UserIdno;
    }

    public String getLeaveTO ()
    {
        return LeaveTO;
    }

    public void setLeaveTO (String LeaveTO)
    {
        this.LeaveTO = LeaveTO;
    }

    public String getSubmitDate ()
    {
        return SubmitDate;
    }

    public void setSubmitDate (String SubmitDate)
    {
        this.SubmitDate = SubmitDate;
    }

    public String getIsavail ()
    {
        return isavail;
    }

    public void setIsavail (String isavail)
    {
        this.isavail = isavail;
    }

    public String getLeaveFrom ()
    {
        return LeaveFrom;
    }

    public void setLeaveFrom (String LeaveFrom)
    {
        this.LeaveFrom = LeaveFrom;
    }

    public String getUsername ()
    {
        return Username;
    }

    public void setUsername (String Username)
    {
        this.Username = Username;
    }

    public String getLeaveReason ()
    {
        return LeaveReason;
    }

    public void setLeaveReason (String LeaveReason)
    {
        this.LeaveReason = LeaveReason;
    }

    public String getDesignName ()
    {
        return DesignName;
    }

    public void setDesignName (String DesignName)
    {
        this.DesignName = DesignName;
    }

    public String getNofDays ()
    {
        return NofDays;
    }

    public void setNofDays (String NofDays)
    {
        this.NofDays = NofDays;
    }

    public String getLeaveIdno ()
    {
        return LeaveIdno;
    }

    public void setLeaveIdno (String LeaveIdno)
    {
        this.LeaveIdno = LeaveIdno;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LeaveType = "+LeaveType+", DepartName = "+DepartName+", IsAccepted = "+IsAccepted+", Remarks = "+Remarks+", Year_Idno = "+Year_Idno+", UserEmail = "+UserEmail+", UserIdno = "+UserIdno+", LeaveTO = "+LeaveTO+", SubmitDate = "+SubmitDate+", isavail = "+isavail+", LeaveFrom = "+LeaveFrom+", Username = "+Username+", LeaveReason = "+LeaveReason+", DesignName = "+DesignName+", NofDays = "+NofDays+", LeaveIdno = "+LeaveIdno+"]";
    }
}