package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectExpense {

    String mTvExpType ,
     mTvDate ,
     mTvAmount,
     mTvAction ,
     mImgDrop ;

    public String getmTvExpType() {
        return mTvExpType;
    }

    public String getmTvDate() {
        return mTvDate;
    }

    public String getmTvAmount() {
        return mTvAmount;
    }

    public String getmTvAction() {
        return mTvAction;
    }

    public String getmImgDrop() {
        return mImgDrop;
    }

    public ObjectExpense(String mTvExpType, String mTvDate, String mTvAmount, String mTvAction, String mImgDrop) {

        this.mTvExpType = mTvExpType;
        this.mTvDate = mTvDate;
        this.mTvAmount = mTvAmount;
        this.mTvAction = mTvAction;
        this.mImgDrop = mImgDrop;
    }
}
