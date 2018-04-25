package mis.oblabs.com.mis.models;

/**
 * Created by ato on 06/12/17.
 */

public class ObjectAddRollout {

    private String StatusCode;

    private String Msg;

    public String getStatusCode ()
    {
        return StatusCode;
    }

    public void setStatusCode (String StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getMsg ()
    {
        return Msg;
    }

    public void setMsg (String Msg)
    {
        this.Msg = Msg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [StatusCode = "+StatusCode+", Msg = "+Msg+"]";
    }
}
