package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectIncrement {
   String mTvName ;
   String  mTvSalary ;
   String  mTvEligible    ;
   String  mTvDoj ;
   String  mTvLast ;
   String  mTvMonth ;

    public String getmTvName() {
        return mTvName;
    }

    public String getmTvSalary() {
        return mTvSalary;
    }

    public String getmTvEligible() {
        return mTvEligible;
    }

    public String getmTvDoj() {
        return mTvDoj;
    }

    public String getmTvLast() {
        return mTvLast;
    }

    public String getmTvMonth() {
        return mTvMonth;
    }

    public ObjectIncrement(String mTvName, String mTvSalary, String mTvEligible, String mTvDoj, String mTvLast, String mTvMonth) {

        this.mTvName = mTvName;
        this.mTvSalary = mTvSalary;
        this.mTvEligible = mTvEligible;
        this.mTvDoj = mTvDoj;
        this.mTvLast = mTvLast;
        this.mTvMonth = mTvMonth;
    }
}
