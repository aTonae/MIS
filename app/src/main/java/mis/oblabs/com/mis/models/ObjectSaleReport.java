package mis.oblabs.com.mis.models;

/**
 * Created by ato on 03/04/17.
 */

public class ObjectSaleReport {

    String mTvExecutive ;
    String mTvProduct ;
    String mTvVendor;
    String mTvType ;
    String mTvQuantity ;
    String mTvTax ;
    String mTvVat ;

    public String getmTvExecutive() {
        return mTvExecutive;
    }

    public String getmTvProduct() {
        return mTvProduct;
    }

    public String getmTvVendor() {
        return mTvVendor;
    }

    public String getmTvType() {
        return mTvType;
    }

    public String getmTvQuantity() {
        return mTvQuantity;
    }

    public String getmTvTax() {
        return mTvTax;
    }

    public String getmTvVat() {
        return mTvVat;
    }

    public String getmTvAmount() {
        return mTvAmount;
    }

    public ObjectSaleReport(String mTvExecutive, String mTvProduct, String mTvVendor, String mTvType, String mTvQuantity, String mTvTax, String mTvVat, String mTvAmount) {

        this.mTvExecutive = mTvExecutive;
        this.mTvProduct = mTvProduct;
        this.mTvVendor = mTvVendor;
        this.mTvType = mTvType;
        this.mTvQuantity = mTvQuantity;
        this.mTvTax = mTvTax;
        this.mTvVat = mTvVat;
        this.mTvAmount = mTvAmount;
    }

    String mTvAmount ;
}
