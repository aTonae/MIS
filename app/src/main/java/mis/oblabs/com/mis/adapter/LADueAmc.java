package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

import mis.oblabs.com.mis.R;


public class LADueAmc extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LADueAmc(Context context, int resource) {
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
                view = layoutInflater.inflate(R.layout.e_due_amc, parent, false);
        TextView mTvCompany = (TextView) view.findViewById(R.id.tv_company);
        TextView mTvVendor = (TextView) view.findViewById(R.id.tv_vendor);
        TextView mTvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView mTvRate = (TextView) view.findViewById(R.id.tv_rate);
        TextView mTvAmount = (TextView) view.findViewById(R.id.tv_amount);
        TextView mTvValid = (TextView) view.findViewById(R.id.tv_valid);
        TextView mTvLastDate = (TextView) view.findViewById(R.id.tv_last_date);
        TextView mTvLastPayment = (TextView) view.findViewById(R.id.tv_last_payment);

 return view;
}

 }