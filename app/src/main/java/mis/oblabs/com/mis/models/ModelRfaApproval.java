package mis.oblabs.com.mis.models;

public class ModelRfaApproval
{
    private String RFA_TYPE;

    private String Dept_Date;

    private String USER_IDNO;

    private String ARVL_DATE;

    private String Rej_Amnt;

    private String ROLLOUTIDNO;

    private String ROLLOUTFROM;

    private String Pnd_Amnt;

    private String TRVEXPIDNO;

    private String ROLLOUTTO;

    private String Paid_Amnt;

    private String Date;

    private String USER_NAME;

    private String NetAmnt;

    private String RFATYPE;

    private String Appr_Amnt;

    public String getRFA_TYPE ()
    {
        return RFA_TYPE;
    }

    public void setRFA_TYPE (String RFA_TYPE)
    {
        this.RFA_TYPE = RFA_TYPE;
    }

    public String getDept_Date ()
    {
        return Dept_Date;
    }

    public void setDept_Date (String Dept_Date)
    {
        this.Dept_Date = Dept_Date;
    }

    public String getUSER_IDNO ()
    {
        return USER_IDNO;
    }

    public void setUSER_IDNO (String USER_IDNO)
    {
        this.USER_IDNO = USER_IDNO;
    }

    public String getARVL_DATE ()
    {
        return ARVL_DATE;
    }

    public void setARVL_DATE (String ARVL_DATE)
    {
        this.ARVL_DATE = ARVL_DATE;
    }

    public String getRej_Amnt ()
    {
        return Rej_Amnt;
    }

    public void setRej_Amnt (String Rej_Amnt)
    {
        this.Rej_Amnt = Rej_Amnt;
    }

    public String getROLLOUTIDNO ()
    {
        return ROLLOUTIDNO;
    }

    public void setROLLOUTIDNO (String ROLLOUTIDNO)
    {
        this.ROLLOUTIDNO = ROLLOUTIDNO;
    }

    public String getROLLOUTFROM ()
    {
        return ROLLOUTFROM;
    }

    public void setROLLOUTFROM (String ROLLOUTFROM)
    {
        this.ROLLOUTFROM = ROLLOUTFROM;
    }

    public String getPnd_Amnt ()
    {
        return Pnd_Amnt;
    }

    public void setPnd_Amnt (String Pnd_Amnt)
    {
        this.Pnd_Amnt = Pnd_Amnt;
    }

    public String getTRVEXPIDNO ()
    {
        return TRVEXPIDNO;
    }

    public void setTRVEXPIDNO (String TRVEXPIDNO)
    {
        this.TRVEXPIDNO = TRVEXPIDNO;
    }

    public String getROLLOUTTO ()
    {
        return ROLLOUTTO;
    }

    public void setROLLOUTTO (String ROLLOUTTO)
    {
        this.ROLLOUTTO = ROLLOUTTO;
    }

    public String getPaid_Amnt ()
    {
        return Paid_Amnt;
    }

    public void setPaid_Amnt (String Paid_Amnt)
    {
        this.Paid_Amnt = Paid_Amnt;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    public String getUSER_NAME ()
    {
        return USER_NAME;
    }

    public void setUSER_NAME (String USER_NAME)
    {
        this.USER_NAME = USER_NAME;
    }

    public String getNetAmnt ()
    {
        return NetAmnt;
    }

    public void setNetAmnt (String NetAmnt)
    {
        this.NetAmnt = NetAmnt;
    }

    public String getRFATYPE ()
    {
        return RFATYPE;
    }

    public void setRFATYPE (String RFATYPE)
    {
        this.RFATYPE = RFATYPE;
    }

    public String getAppr_Amnt ()
    {
        return Appr_Amnt;
    }

    public void setAppr_Amnt (String Appr_Amnt)
    {
        this.Appr_Amnt = Appr_Amnt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RFA_TYPE = "+RFA_TYPE+", Dept_Date = "+Dept_Date+", USER_IDNO = "+USER_IDNO+", ARVL_DATE = "+ARVL_DATE+", Rej_Amnt = "+Rej_Amnt+", ROLLOUTIDNO = "+ROLLOUTIDNO+", ROLLOUTFROM = "+ROLLOUTFROM+", Pnd_Amnt = "+Pnd_Amnt+", TRVEXPIDNO = "+TRVEXPIDNO+", ROLLOUTTO = "+ROLLOUTTO+", Paid_Amnt = "+Paid_Amnt+", Date = "+Date+", USER_NAME = "+USER_NAME+", NetAmnt = "+NetAmnt+", RFATYPE = "+RFATYPE+", Appr_Amnt = "+Appr_Amnt+"]";
    }
}