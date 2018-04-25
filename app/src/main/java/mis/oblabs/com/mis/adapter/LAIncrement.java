package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

import mis.oblabs.com.mis.R;


public class LAIncrement extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LAIncrement(Context context, int resource) {
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
                row = layoutInflater.inflate(R.layout.e_increment, parent, false);
TextView  mTvName =  (TextView) row.findViewById(R.id.tv_name);
TextView  mTvSalary =  (TextView) row.findViewById(R.id.tv_salary);
TextView  mTvEligible =  (TextView) row.findViewById(R.id.tv_eligible);
TextView  mTvDoj =  (TextView) row.findViewById(R.id.tv_doj);
TextView  mTvLast =  (TextView) row.findViewById(R.id.tv_last);
TextView  mTvMonth =  (TextView) row.findViewById(R.id.tv_month);

 return row; 
}

 }