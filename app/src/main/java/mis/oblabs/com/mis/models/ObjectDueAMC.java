package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectDueAMC {

    String mTvCompany ,
    mTvVendor ,
    mTvDate ,
    mTvRate ,
    mTvAmount ,
    mTvValid ,
    mTvLastDate,
    mTvLastPayment;

    public String getmTvCompany() {
        return mTvCompany;
    }

    public String getmTvVendor() {
        return mTvVendor;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvRate() {
        return mTvRate;
    }

    public String getmTvAmount() {
        return mTvAmount;
    }

    public String getmTvValid() {
        return mTvValid;
    }

    public String getmTvLastDate() {
        return mTvLastDate;
    }

    public String getmTvLastPayment() {
        return mTvLastPayment;
    }

    public ObjectDueAMC(String mTvCompany, String mTvVendor, String mTvDate, String mTvRate, String mTvAmount, String mTvValid, String mTvLastDate, String mTvLastPayment) {

        this.mTvCompany = mTvCompany;
        this.mTvVendor = mTvVendor;
        this.mTvDate = mTvDate;
        this.mTvRate = mTvRate;
        this.mTvAmount = mTvAmount;
        this.mTvValid = mTvValid;
        this.mTvLastDate = mTvLastDate;
        this.mTvLastPayment = mTvLastPayment;
    }
}
