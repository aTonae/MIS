package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LAHoliday extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LAHoliday(Context context, int resource) {
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
                row = layoutInflater.inflate(R.layout.e_holiday, parent, false);
TextView  mTvName =  (TextView) row.findViewById(R.id.tv_name);
TextView  mTvDate =  (TextView) row.findViewById(R.id.tv_date);
ImageView mImgStatus =  (ImageView) row.findViewById(R.id.img_status);
TextView  mTvMonth =  (TextView) row.findViewById(R.id.tv_month);
TextView  mTvYear =  (TextView) row.findViewById(R.id.tv_year);
TextView  mTvSource =  (TextView) row.findViewById(R.id.tv_source);
TextView  mTvExcelStatus =  (TextView) row.findViewById(R.id.tv_excel_status);

 return row; 
}

 }