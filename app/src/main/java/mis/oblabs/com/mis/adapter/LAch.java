package mis.oblabs.com.mis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.models.ModelAttendance;
import mis.oblabs.com.mis.models.ObjectCH;


public class LAch extends ArrayAdapter {

    public void setListItemCount(List listItemCount) {
        this.listItemCount = listItemCount;
    }
    Context context;
    List listItemCount ;
    View row;


    public LAch(Context context, int resource) {
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
                row = layoutInflater.inflate(R.layout.e_ch_request, parent, false);
        ImageView mImgStatus =  (ImageView) row.findViewById(R.id.img_status);
        TextView  mTvStatus =  (TextView) row.findViewById(R.id.tv_status);
        TextView  mTvDate =  (TextView) row.findViewById(R.id.tv_date);
        TextView  mTvDept =  (TextView) row.findViewById(R.id.tv_dept);
//        TextView  mTvState =  (TextView) row.findViewById(R.id.tv_state);

        ObjectCH data = (ObjectCH) listItemCount.get(position);


        String dateString = data.getEmpCh_Date();
                    mTvDate.setText(dateString);


        String submitDate = data.getSubmit_Date();
        mTvDept.setText(submitDate);


//        DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH);
//        DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = null;
//        try {
//            date = originalFormat.parse(dateString);
//            mTvDate.setText(targetFormat.format(date));
//
//
//            mTvDept.setText(targetFormat.format(originalFormat.parse(submitDate)));
//
////            SimpleDateFormat formatter = new SimpleDateFormat("EEE");
////
////            mTvDate.setText(formatter.format(date));
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        String formattedDate = targetFormat.format(date);

//        mTvDate.setText("Dated : "+data.getAttend_Date());
//        if(data.getRemark().equals("")){
//            mTvStatus.setVisibility(View.GONE);
//        }else{
//            mTvStatus.setText("Remark: "+data.getRemark());
//
//        }


        if(data.getStatus().equals("1")){
            mImgStatus.setImageResource(R.drawable.status_confirm);

        }else{
            mImgStatus.setImageResource(R.drawable.status_pending);

        }

//        mImgStatus.setImageResource(R.drawable.status_confirm);


        mTvStatus.setText(data.getAttend_Type());

//        mTvState.setText((data.getIs_Checked()==""?"Pending":data.getIs_Checked()));
//
//        TextDrawable drawable = null;
//        switch (data.getAttend_Type()){
//            case "Present":{
//
//                drawable = TextDrawable.builder().beginConfig().textColor(Color.BLACK)
//                        .
//                        endConfig()
//
//                        .buildRound("P", Color.parseColor("#4CAF50"));
//
//                break;
//
//            }
//            case "Holiday":{
//
//                drawable = TextDrawable.builder().beginConfig().textColor(Color.BLACK).endConfig()
//                        .buildRound("H", Color.parseColor("#FFEB3B"));
//
//                break;
//
//            }
//            case "Absent":{
//
//                drawable = TextDrawable.builder().beginConfig().textColor(Color.BLACK).endConfig()
//                        .buildRound("A", Color.parseColor("#F44336"));
//
//                break;
//
//            }
//        }

      




 return row; 
}

 }