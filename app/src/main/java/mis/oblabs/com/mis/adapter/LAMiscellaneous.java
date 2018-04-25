package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LAMiscellaneous extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LAMiscellaneous(Context context, int resource) {
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
                row = layoutInflater.inflate(R.layout.e_miscellaneous, parent, false);
TextView  mTvStatus =  (TextView) row.findViewById(R.id.tv_status);
LinearLayout mLlType =  (LinearLayout) row.findViewById(R.id.ll_type);
TextView  mTvType =  (TextView) row.findViewById(R.id.tv_type);
TextView  mTvName =  (TextView) row.findViewById(R.id.tv_name);

 return row; 
}

 }