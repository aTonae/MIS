package mis.oblabs.com.mis.models;

import java.util.List;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectRfaExpense {

    String mTvType,
     mTvPlan,
     mTvSfrom,
     mTvSto,
     mTvCfrom,
     mTvCto,
     mTvDepDate,
     mTvDepTime,
     mTvArrDate,
     mTvArrTime,
     mEtRemark;

    List<ObjectRfaTable> tableData;

    public void setTableData(List<ObjectRfaTable> tableData) {
        this.tableData = tableData;
    }

    public void setmTvType(String mTvType) {
        this.mTvType = mTvType;
    }

    public void setmTvPlan(String mTvPlan) {
        this.mTvPlan = mTvPlan;
    }

    public void setmTvSfrom(String mTvSfrom) {
        this.mTvSfrom = mTvSfrom;
    }

    public void setmTvSto(String mTvSto) {
        this.mTvSto = mTvSto;
    }

    public void setmTvCfrom(String mTvCfrom) {
        this.mTvCfrom = mTvCfrom;
    }

    public void setmTvCto(String mTvCto) {
        this.mTvCto = mTvCto;
    }

    public void setmTvDepDate(String mTvDepDate) {
        this.mTvDepDate = mTvDepDate;
    }

    public void setmTvDepTime(String mTvDepTime) {
        this.mTvDepTime = mTvDepTime;
    }

    public void setmTvArrDate(String mTvArrDate) {
        this.mTvArrDate = mTvArrDate;
    }

    public void setmTvArrTime(String mTvArrTime) {
        this.mTvArrTime = mTvArrTime;
    }

    public void setmEtRemark(String mEtRemark) {
        this.mEtRemark = mEtRemark;
    }

    public ObjectRfaExpense() {

    }
}
