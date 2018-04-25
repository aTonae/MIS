package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LANewCustomer extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LANewCustomer(Context context, int resource) {
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
                row = layoutInflater.inflate(R.layout.e_new_customer, parent, false);
TextView  mTvCompanyName =  (TextView) row.findViewById(R.id.tv_company_name);
TextView  mTvVendor =  (TextView) row.findViewById(R.id.tv_vendor);
TextView  mTvExecutive =  (TextView) row.findViewById(R.id.tv_executive);
TextView  mTvDate =  (TextView) row.findViewById(R.id.tv_date);
TextView  mTvRcv =  (TextView) row.findViewById(R.id.tv_rcv);
TextView  mTvPending =  (TextView) row.findViewById(R.id.tv_pending);

 return row; 
}

 }