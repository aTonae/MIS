package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectAttendance {

    String mImgStatus,
     mTvStatus ,
      mTvDate ,
      mTvDay ,
      mTvState ;

    public ObjectAttendance(String mImgStatus, String mTvStatus, String mTvDate, String mTvDay, String mTvState) {
        this.mImgStatus = mImgStatus;
        this.mTvStatus = mTvStatus;
        this.mTvDate = mTvDate;
        this.mTvDay = mTvDay;
        this.mTvState = mTvState;
    }

    public String getmImgStatus() {
        return mImgStatus;
    }

    public String getmTvStatus() {
        return mTvStatus;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvDay() {
        return mTvDay;
    }

    public String getmTvState() {
        return mTvState;
    }
}
