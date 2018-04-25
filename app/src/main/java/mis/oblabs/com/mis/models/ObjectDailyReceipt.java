package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectDailyReceipt {

   String mTvDate ,
    mTvCompany ,
    mTvUsername,
    mTvPaymentTypepe,
    mTvInstType ,
    mTvAmount,
    mTvInstNo,
    mTvInstDate ,
    mTvBank ,
    mTvNarration ;

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvCompany() {
        return mTvCompany;
    }

    public String getmTvUsername() {
        return mTvUsername;
    }

    public String getmTvPaymentTypepe() {
        return mTvPaymentTypepe;
    }

    public String getmTvInstType() {
        return mTvInstType;
    }

    public String getmTvAmount() {
        return mTvAmount;
    }

    public String getmTvInstNo() {
        return mTvInstNo;
    }

    public String getmTvInstDate() {
        return mTvInstDate;
    }

    public String getmTvBank() {
        return mTvBank;
    }

    public String getmTvNarration() {
        return mTvNarration;
    }

    public ObjectDailyReceipt(String mTvDate, String mTvCompany, String mTvUsername, String mTvPaymentTypepe, String mTvInstType, String mTvAmount, String mTvInstNo, String mTvInstDate, String mTvBank, String mTvNarration) {

        this.mTvDate = mTvDate;
        this.mTvCompany = mTvCompany;
        this.mTvUsername = mTvUsername;
        this.mTvPaymentTypepe = mTvPaymentTypepe;
        this.mTvInstType = mTvInstType;
        this.mTvAmount = mTvAmount;
        this.mTvInstNo = mTvInstNo;
        this.mTvInstDate = mTvInstDate;
        this.mTvBank = mTvBank;
        this.mTvNarration = mTvNarration;
    }
}
