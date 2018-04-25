package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LASaleReport extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LASaleReport(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public int getCount() {
        if(listItemCount!=null) {
            return listItemCount.size();
        }else{
            return 5;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
                view = layoutInflater.inflate(R.layout.e_sale_report, parent, false);
        TextView mTvExecutive = (TextView) view.findViewById(R.id.tv_executive);
        TextView mTvProduct = (TextView) view.findViewById(R.id.tv_product);
        TextView mTvVendor = (TextView) view.findViewById(R.id.tv_vendor);
        TextView mTvType = (TextView) view.findViewById(R.id.tv_type);
        TextView mTvQuantity = (TextView) view.findViewById(R.id.tv_quantity);
        TextView mTvTax = (TextView) view.findViewById(R.id.tv_tax);
        TextView mTvVat = (TextView) view.findViewById(R.id.tv_vat);
        TextView mTvAmount = (TextView) view.findViewById(R.id.tv_amount);

 return view;
}

 }