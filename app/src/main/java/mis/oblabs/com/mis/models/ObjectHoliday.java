package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectHoliday {
    String mTvName ,
     mTvDate,
     mImgStatus ,
     mTvMonth ,
     mTvYear ,
     mTvSource,
     mTvExcelStatus;

    public String getmTvName() {
        return mTvName;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmImgStatus() {
        return mImgStatus;
    }

    public String getmTvMonth() {
        return mTvMonth;
    }

    public String getmTvYear() {
        return mTvYear;
    }

    public String getmTvSource() {
        return mTvSource;
    }

    public String getmTvExcelStatus() {
        return mTvExcelStatus;
    }

    public ObjectHoliday(String mTvName, String mTvDate, String mImgStatus, String mTvMonth, String mTvYear, String mTvSource, String mTvExcelStatus) {

        this.mTvName = mTvName;
        this.mTvDate = mTvDate;
        this.mImgStatus = mImgStatus;
        this.mTvMonth = mTvMonth;
        this.mTvYear = mTvYear;
        this.mTvSource = mTvSource;
        this.mTvExcelStatus = mTvExcelStatus;
    }
}
