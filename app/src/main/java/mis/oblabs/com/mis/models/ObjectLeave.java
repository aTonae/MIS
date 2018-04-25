package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectLeave {

    String mTvCh ;

    String  mTvPl;

    public String getmTvCh() {
        return mTvCh;
    }

    public String getmTvPl() {
        return mTvPl;
    }

    public ObjectLeave(String mTvCh, String mTvPl) {

        this.mTvCh = mTvCh;
        this.mTvPl = mTvPl;
    }
}
