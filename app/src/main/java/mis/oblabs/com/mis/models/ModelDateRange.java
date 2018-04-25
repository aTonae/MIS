package mis.oblabs.com.mis.models;

/**
 * Created by ato on 22/12/17.
 */

public class ModelDateRange {

    private String Id;

    private String DateRange;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDateRange() {
        return DateRange;
    }

    public void setDateRange(String dateRange) {
        DateRange = dateRange;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+Id+", Range = "+DateRange+"]";
    }
}
