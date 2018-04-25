package mis.oblabs.com.mis.models;

import java.util.List;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectLead {

    String mEtLeadOf,
      mEtDate,
      mEtNumber,
      mEtAppDate,
      mEtTime,
      mEtPlace,
      mEtRemark,

     mTvParty,
      mTvSource,
      mTvNature,
     mTvAssign,
     mTvStatus;

    List<ObjectLeadTable> tableData;

    public void setTableData(List<ObjectLeadTable> tableData) {
        this.tableData = tableData;
    }

    public void setmEtLeadOf(String mEtLeadOf) {
        this.mEtLeadOf = mEtLeadOf;
    }

    public void setmEtDate(String mEtDate) {
        this.mEtDate = mEtDate;
    }

    public void setmEtNumber(String mEtNumber) {
        this.mEtNumber = mEtNumber;
    }

    public void setmEtAppDate(String mEtAppDate) {
        this.mEtAppDate = mEtAppDate;
    }

    public void setmEtTime(String mEtTime) {
        this.mEtTime = mEtTime;
    }

    public void setmEtPlace(String mEtPlace) {
        this.mEtPlace = mEtPlace;
    }

    public void setmEtRemark(String mEtRemark) {
        this.mEtRemark = mEtRemark;
    }

    public void setmTvParty(String mTvParty) {
        this.mTvParty = mTvParty;
    }

    public void setmTvSource(String mTvSource) {
        this.mTvSource = mTvSource;
    }

    public void setmTvNature(String mTvNature) {
        this.mTvNature = mTvNature;
    }

    public void setmTvAssign(String mTvAssign) {
        this.mTvAssign = mTvAssign;
    }

    public void setmTvStatus(String mTvStatus) {
        this.mTvStatus = mTvStatus;
    }

    public ObjectLead() {

    }
}
