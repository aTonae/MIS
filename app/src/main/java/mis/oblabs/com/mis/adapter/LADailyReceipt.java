package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

import mis.oblabs.com.mis.R;


public class LADailyReceipt extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LADailyReceipt(Context context, int resource) {
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
                view = layoutInflater.inflate(R.layout.d_daily_recipt, parent, false);

        TextView mTvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView mTvCompany = (TextView) view.findViewById(R.id.tv_company);
        TextView mTvUsername = (TextView) view.findViewById(R.id.tv_username);
        TextView mTvPaymentType = (TextView) view.findViewById(R.id.tv_payment_type);
        TextView mTvInstType = (TextView) view.findViewById(R.id.tv_inst_type);
        TextView mTvAmount = (TextView) view.findViewById(R.id.tv_amount);
        TextView mTvInstNo = (TextView) view.findViewById(R.id.tv_inst_no);
        TextView mTvInstDate = (TextView) view.findViewById(R.id.tv_inst_date);
        TextView mTvBank = (TextView) view.findViewById(R.id.tv_bank);
        TextView mTvNarration = (TextView) view.findViewById(R.id.tv_narration);

 return view;
}

 }