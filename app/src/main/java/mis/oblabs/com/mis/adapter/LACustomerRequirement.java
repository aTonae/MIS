package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LACustomerRequirement extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LACustomerRequirement(Context context, int resource) {
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
                view = layoutInflater.inflate(R.layout.d_customer_requirment, parent, false);
        TextView mTvCustomerName = (TextView) view.findViewById(R.id.tv_customer_name);
        TextView mTvCode = (TextView) view.findViewById(R.id.tv_code);
        TextView mTvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView mTvProject = (TextView) view.findViewById(R.id.tv_project);
        TextView mTvForm = (TextView) view.findViewById(R.id.tv_form);
        TextView mTvDescription = (TextView) view.findViewById(R.id.tv_description);
        TextView mTvAssign = (TextView) view.findViewById(R.id.tv_assign);

 return view;
}

 }