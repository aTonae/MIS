package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;


public class LASalaryInc extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View view;


    public LASalaryInc(Context context, int resource) {
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
                view = layoutInflater.inflate(R.layout.e_salary_inc, parent, false);

        TextView mTvMonth = (TextView) view.findViewById(R.id.tv_month);
        TextView mTvBasic = (TextView) view.findViewById(R.id.tv_basic);
        TextView mTvHra = (TextView) view.findViewById(R.id.tv_hra);
        TextView mTvConvey = (TextView) view.findViewById(R.id.tv_convey);
        TextView mTvSalary = (TextView) view.findViewById(R.id.tv_salary);
        TextView mTvPf = (TextView) view.findViewById(R.id.tv_pf);
        TextView mTvEsi = (TextView) view.findViewById(R.id.tv_esi);
        TextView mTvDed = (TextView) view.findViewById(R.id.tv_ded);
        TextView mTvInhand = (TextView) view.findViewById(R.id.tv_inhand);
        TextView mTvPfcomp = (TextView) view.findViewById(R.id.tv_pfcomp);
        TextView mTvEsicomp = (TextView) view.findViewById(R.id.tv_esicomp);
        TextView mTvDedcomp = (TextView) view.findViewById(R.id.tv_dedcomp);
        TextView mTvCtc = (TextView) view.findViewById(R.id.tv_ctc);

 return view;
}

 }