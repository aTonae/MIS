package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectLeaveDetail {

    String mTvDate   ;
    String  mTvType  ;
    String  mTvFrom  ;
    String  mTvTo ;
    String  mTvNfd   ;
    String  mTvAvail ;
    String  mTvStatus ;

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvType() {
        return mTvType;
    }

    public String getmTvFrom() {
        return mTvFrom;
    }

    public String getmTvTo() {
        return mTvTo;
    }

    public String getmTvNfd() {
        return mTvNfd;
    }

    public String getmTvAvail() {
        return mTvAvail;
    }

    public String getmTvStatus() {
        return mTvStatus;
    }

    public ObjectLeaveDetail(String mTvDate, String mTvType, String mTvFrom, String mTvTo, String mTvNfd, String mTvAvail, String mTvStatus) {

        this.mTvDate = mTvDate;
        this.mTvType = mTvType;
        this.mTvFrom = mTvFrom;
        this.mTvTo = mTvTo;
        this.mTvNfd = mTvNfd;
        this.mTvAvail = mTvAvail;
        this.mTvStatus = mTvStatus;
    }
}
