package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectRfaApproval {

    String mTvName ;
    String mTvDate ;
    String mTvCityFrom;
    String mTvDeptDate;
    String mTvCityTo ;
    String mTvArrDate ;
    String mTvType ;
    String mTvAmount ;

    public String getmTvName() {
        return mTvName;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvCityFrom() {
        return mTvCityFrom;
    }

    public String getmTvDeptDate() {
        return mTvDeptDate;
    }

    public String getmTvCityTo() {
        return mTvCityTo;
    }

    public String getmTvArrDate() {
        return mTvArrDate;
    }

    public String getmTvType() {
        return mTvType;
    }

    public String getmTvAmount() {
        return mTvAmount;
    }

    public ObjectRfaApproval(String mTvName, String mTvDate, String mTvCityFrom, String mTvDeptDate, String mTvCityTo, String mTvArrDate, String mTvType, String mTvAmount) {

        this.mTvName = mTvName;
        this.mTvDate = mTvDate;
        this.mTvCityFrom = mTvCityFrom;
        this.mTvDeptDate = mTvDeptDate;
        this.mTvCityTo = mTvCityTo;
        this.mTvArrDate = mTvArrDate;
        this.mTvType = mTvType;
        this.mTvAmount = mTvAmount;
    }
}
