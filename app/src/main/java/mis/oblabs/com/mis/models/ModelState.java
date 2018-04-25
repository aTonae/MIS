package mis.oblabs.com.mis.models;

public class ModelState
{
    private String State_Name;

    private String State_Idno;

    public String getState_Name ()
    {
        return State_Name;
    }

    public void setState_Name (String State_Name)
    {
        this.State_Name = State_Name;
    }

    public String getState_Idno ()
    {
        return State_Idno;
    }

    public void setState_Idno (String State_Idno)
    {
        this.State_Idno = State_Idno;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [State_Name = "+State_Name+", State_Idno = "+State_Idno+"]";
    }
}