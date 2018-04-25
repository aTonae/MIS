package mis.oblabs.com.mis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveApply extends AppCompatActivity {






    TextView  mTvDate;
    TextView  mTvName;
    TextView  mTvDepartment;
    TextView  mTvEmail;
    TextView  mTvLeaveFrom;
    TextView  mTvLeaveTo;
    TextView mTvType;
    TextView mTvLeaveData;

    Button bttnInfo;

    EditText mEtRfl , mEtNod;

    View footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_leave_request);





        Log.wtf("TAG" , "Logging notwoeking");
        Log.d("TAG" , "Logging notwoeking");



    initializeView(this.findViewById(android.R.id.content));




    }

    private void initializeView(View view) {




        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());

        mTvDate =  (TextView) view.findViewById(R.id.tv_date);
        mTvDate.setText(formattedDate);
        mTvDate.setTag("date");
        mTvDate.setOnClickListener(selectDate(mTvDate));










        mTvLeaveFrom =  (TextView) view.findViewById(R.id.tv_leave_from);
        mTvLeaveFrom.setTag("from");
        mTvLeaveFrom.setOnClickListener(selectDate(mTvLeaveFrom));

        mTvLeaveTo =  (TextView) view.findViewById(R.id.tv_leave_to);
        mTvLeaveTo.setTag("to");
        mTvLeaveTo.setOnClickListener(selectDate(mTvLeaveTo));

        mTvType =  (TextView) view.findViewById(R.id.tv_type);
        mTvType.setTag("type");
        mTvType.setOnClickListener(selectType(mTvType));






        mEtRfl = (EditText)view.findViewById(R.id.et_rol);

        mEtNod = (EditText)view.findViewById(R.id.et_nod);



        footer = view.findViewById(R.id.footer);
        initFooter();

    }



    private void initFooter() {

        Button bttnPos = (Button)footer.findViewById(R.id.bttn_positive);
        Button bttnNeg = (Button)footer.findViewById(R.id.bttn_negative);

        bttnPos.setOnClickListener(clickPos());
        bttnNeg.setOnClickListener(clickNeg());
    }

    private View.OnClickListener clickNeg() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Toast.makeText(LeaveApply.this , "Negative Clicked" , Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(LeaveApply.this , "Positive Clicked" , Toast.LENGTH_SHORT).show();
                submitData();
            }
        };
    }

    private View.OnClickListener selectType(final TextView tv) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectItem2 select = new SelectItem2();
                select.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {
                        tv.setText(name);
                    }

                    @Override
                    public void selectedItemId(String id) {

                    }
                });
                select.show(getSupportFragmentManager() , "select");
            }
        };
    }

    private View.OnClickListener selectDate(final TextView tv) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker =  new DatePicker();
                datePicker.setCallback(new SelectSingleItemCallback() {
                    @Override
                    public void selectedItem(String item) {
                        tv.setText(item);
                    }
                });
                datePicker.show(getSupportFragmentManager() , "date");
            }
        };
    }

    public void submitData(){



        //      String userId =  new SharedPreference().getValueWithKey(getContext() , "userId");


        String userId = "7";
        String submitDate = mTvDate.getText().toString();
        String leaveFrom =mTvLeaveFrom.getText().toString();
        String leaveTo =mTvLeaveTo.getText().toString();
        String daysCount = mEtNod.getText().toString() ;
//        String leaveType =mTvType.getTag().toString();
        String leaveType = "4";

        String leaveReason = mEtRfl.getText().toString() ;
        String isAccepted = "3" ;
        String yearId = "6";


        Call<List<ObjectSendLeaveRequest>> call = new ApiRestAdapter().sendLeaveRequest(userId , submitDate , leaveFrom , leaveTo , daysCount , leaveType , leaveReason , isAccepted , yearId);
        Helper.showLoading(LeaveApply.this , "Requesting Leave");
        call.enqueue(new Callback<List<ObjectSendLeaveRequest>>() {
            @Override
            public void onResponse(Call<List<ObjectSendLeaveRequest>> call, Response<List<ObjectSendLeaveRequest>> response) {

                Helper.hideLoading();

                if(response.code() == 200) {
                    Helper.showToast(LeaveApply.this, "Success");
                    String msg =  response.body().get(0).getMsg();

                    Helper.showToast(LeaveApply.this , msg);




                }else{
                    Helper.showToast(LeaveApply.this, "Try Again : "+response.code());

                }
            }

            @Override
            public void onFailure(Call<List<ObjectSendLeaveRequest>> call, Throwable t) {

                Helper.hideLoading();
                Helper.showToast(LeaveApply.this , "Failed : "+t.getMessage());

            }
        });

    }


    public void exitScreen(View view) {
        finish();
    }
}
