package mis.oblabs.com.mis.models;

/**
 * Created by ato on 28/12/17.
 */

public class ModelAttendanceType {

    String id;

    String name;

    public ModelAttendanceType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
