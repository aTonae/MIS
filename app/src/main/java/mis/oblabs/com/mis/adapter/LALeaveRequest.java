package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.models.ModelLeave;


public class LALeaveRequest extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LALeaveRequest(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    public List getListItemCount() {
        return listItemCount;
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
                row = layoutInflater.inflate(R.layout.e_leave_request, parent, false);
                TextView  mTvDate =  (TextView) row.findViewById(R.id.tv_date);
                TextView  mTvType =  (TextView) row.findViewById(R.id.tv_type);
                TextView  mTvFrom =  (TextView) row.findViewById(R.id.tv_from);
                TextView  mTvTo =  (TextView) row.findViewById(R.id.tv_to);
                TextView  mTvNfd =  (TextView) row.findViewById(R.id.tv_nfd);
                TextView  mTvAvail =  (TextView) row.findViewById(R.id.tv_avail);
                TextView  mTvStatus =  (TextView) row.findViewById(R.id.tv_status);
                TextView  mTvReason =  (TextView) row.findViewById(R.id.tvReason);


                 ModelLeave data = (ModelLeave) listItemCount.get(position);


                    mTvDate.setText("Dated : "+data.getSubmitDate());
                    if(data.getLeaveType().equals("1")) {
                        mTvType.setText("Paid Leave");
                    }

                    mTvFrom.setText(data.getLeaveFrom());
                    mTvTo.setText(data.getLeaveTO());
        mTvNfd.setText("Total Days : "+data.getNofDays());
        mTvAvail.setText(data.getIsavail());
        if(data.getIsAccepted().equals("1")) {
            mTvStatus.setText("APPROVED");
        }else{
            mTvStatus.setText("DISAPPROVED");

        }

        mTvReason.setText(data.getLeaveReason());


 return row; 
}

 }