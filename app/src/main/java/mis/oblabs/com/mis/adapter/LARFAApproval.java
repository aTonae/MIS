package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.models.ModelRfaApproval;


public class LARFAApproval extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LARFAApproval(Context context, int resource) {
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
                view = layoutInflater.inflate(R.layout.d_rfa_approval, parent, false);

        TextView mTvName = (TextView) view.findViewById(R.id.tv_name);
        TextView mTvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView mTvCityFrom = (TextView) view.findViewById(R.id.tv_city_from);
        TextView mTvDeptDate = (TextView) view.findViewById(R.id.tv_dept_date);
        TextView mTvCityTo = (TextView) view.findViewById(R.id.tv_city_to);
        TextView mTvArrDate = (TextView) view.findViewById(R.id.tv_arr_date);
        TextView mTvType = (TextView) view.findViewById(R.id.tv_type);
        TextView mTvAmount = (TextView) view.findViewById(R.id.tv_amount);

        ModelRfaApproval data = (ModelRfaApproval) listItemCount.get(position);

        mTvName.setText(data.getUSER_NAME());
        mTvDate.setText(data.getDate());
        mTvCityFrom.setText(data.getROLLOUTFROM());
        mTvCityTo.setText(data.getROLLOUTTO());
        mTvDeptDate.setText(data.getDept_Date());
        mTvArrDate.setText(data.getARVL_DATE());
        mTvType.setText(data.getRFATYPE());
        mTvAmount.setText("\u20B9 "+data.getNetAmnt());




        return view;
}

 }