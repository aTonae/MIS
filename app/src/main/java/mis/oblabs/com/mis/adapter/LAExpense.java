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


public class LAExpense extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LAExpense(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public int getCount() {
        if(listItemCount!=null) {
            return listItemCount.size();
        }else{
            return 0;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService((Context.LAYOUT_INFLATER_SERVICE));
                row = layoutInflater.inflate(R.layout.e_expense, parent, false);
TextView  mTvExpType =  (TextView) row.findViewById(R.id.tv_exp_type);
TextView  mTvDate =  (TextView) row.findViewById(R.id.tv_date);
TextView  mTvAmount =  (TextView) row.findViewById(R.id.tv_amount);
TextView  mTvAction =  (TextView) row.findViewById(R.id.tv_action);
ImageView  mImgDrop =  (ImageView) row.findViewById(R.id.img_drop);

 return row; 
}

 }