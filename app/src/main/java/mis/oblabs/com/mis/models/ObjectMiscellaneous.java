package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectMiscellaneous {

    String mTvStatus;
    String  mTvType ;
    String  mTvName ;

    public String getmTvStatus() {
        return mTvStatus;
    }

    public String getmTvType() {
        return mTvType;
    }

    public String getmTvName() {
        return mTvName;
    }

    public ObjectMiscellaneous(String mTvStatus, String mTvType, String mTvName) {

        this.mTvStatus = mTvStatus;
        this.mTvType = mTvType;
        this.mTvName = mTvName;
    }
}
