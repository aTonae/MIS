package mis.oblabs.com.mis.models;

/**
 * Created by ato on 05/11/17.
 */

public class ObjectLogin {


    private String Email;

    private String User_Idno;

    private String Mobile_No;

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

    public String getUser_Idno ()
    {
        return User_Idno;
    }

    public void setUser_Idno (String User_Idno)
    {
        this.User_Idno = User_Idno;
    }

    public String getMobile_No ()
    {
        return Mobile_No;
    }

    public void setMobile_No (String Mobile_No)
    {
        this.Mobile_No = Mobile_No;
    }

    @Override
    public String toString()
    {
        return "ClassLogin [Email = "+Email+", User_Idno = "+User_Idno+", Mobile_No = "+Mobile_No+"]";
    }
}
