package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectNewCustomer {

   String mTvCompanyName ;
   String  mTvVendor ;
   String  mTvExecutive ;
   String  mTvDate ;
   String  mTvRcv ;
   String  mTvPending   ;

    public String getmTvCompanyName() {
        return mTvCompanyName;
    }

    public String getmTvVendor() {
        return mTvVendor;
    }

    public String getmTvExecutive() {
        return mTvExecutive;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvRcv() {
        return mTvRcv;
    }

    public String getmTvPending() {
        return mTvPending;
    }

    public ObjectNewCustomer(String mTvCompanyName, String mTvVendor, String mTvExecutive, String mTvDate, String mTvRcv, String mTvPending) {

        this.mTvCompanyName = mTvCompanyName;
        this.mTvVendor = mTvVendor;
        this.mTvExecutive = mTvExecutive;
        this.mTvDate = mTvDate;
        this.mTvRcv = mTvRcv;
        this.mTvPending = mTvPending;
    }
}
