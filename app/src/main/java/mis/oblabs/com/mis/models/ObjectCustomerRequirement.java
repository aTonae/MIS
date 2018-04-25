package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectCustomerRequirement {

    String mTvCustomerName ,
     mTvCode ,
     mTvDate ,
     mTvProject ,
     mTvForm ,
     mTvDescription ,
     mTvAssign ;

    public String getmTvCustomerName() {
        return mTvCustomerName;
    }

    public String getmTvCode() {
        return mTvCode;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvProject() {
        return mTvProject;
    }

    public String getmTvForm() {
        return mTvForm;
    }

    public String getmTvDescription() {
        return mTvDescription;
    }

    public String getmTvAssign() {
        return mTvAssign;
    }

    public ObjectCustomerRequirement(String mTvCustomerName, String mTvCode, String mTvDate, String mTvProject, String mTvForm, String mTvDescription, String mTvAssign) {

        this.mTvCustomerName = mTvCustomerName;
        this.mTvCode = mTvCode;
        this.mTvDate = mTvDate;
        this.mTvProject = mTvProject;
        this.mTvForm = mTvForm;
        this.mTvDescription = mTvDescription;
        this.mTvAssign = mTvAssign;
    }
}
