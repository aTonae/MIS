package mis.oblabs.com.mis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import mis.oblabs.com.mis.models.ObjectAddRollout;
import mis.oblabs.com.mis.models.ObjectRollout;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RolloutCreate extends AppCompatActivity {




    EditText mEtName;
    TextView mTvSfrom;
    TextView mTvSto;
    EditText mTvCfrom;
    EditText mTvCto;
    TextView mTvStart;
    TextView mTvEnd;
    EditText mEtDayTravel;
    EditText mEtDayOnsite;
    EditText mEtDayBase;
    EditText mEtRemark;

    TextView tvDateRange;

    View footer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_rollout);


        initializeView(this.findViewById(android.R.id.content));





    }


    private void initializeView(View view) {


        tvDateRange = (TextView)view.findViewById(R.id.tv_date_range);
        tvDateRange.setTag("dateRange");
        tvDateRange.setOnClickListener(selectType(tvDateRange , 8812));


        mEtName = (EditText) view. findViewById(R.id.et_name);

        mTvSfrom = (TextView) view. findViewById(R.id.tv_sfrom);
        mTvSfrom.setTag("sfrom");
        mTvSfrom.setOnClickListener(selectType(mTvSfrom , 8811));

        mTvSto = (TextView) view. findViewById(R.id.tv_sto);
        mTvSto.setTag("sto");
        mTvSto.setOnClickListener(selectType(mTvSto , 8811));

        mTvCfrom = (EditText) view. findViewById(R.id.et_cfrom);
        mTvCfrom.setTag("cfrom");
        // mTvCfrom.setOnClickListener(selectType(mTvCfrom));

        mTvCto = (EditText) view. findViewById(R.id.et_cto);
        mTvCto.setTag("cto");
        // mTvCto.setOnClickListener(selectType(mTvCto));

        mTvStart = (TextView) view. findViewById(R.id.tv_start);
        mTvStart.setTag("sdate");
        mTvStart.setOnClickListener(selectDate(mTvStart));

        mTvEnd = (TextView) view. findViewById(R.id.tv_end);
        mTvEnd.setTag("edate");
        mTvEnd.setOnClickListener(selectDate(mTvEnd));

        mEtDayTravel = (EditText) view. findViewById(R.id.et_day_travel);
        mEtDayOnsite = (EditText) view. findViewById(R.id.et_day_onsite);
//        mEtDayBase = (EditText) view. findViewById(R.id.et_day_base);
        mEtRemark = (EditText) view. findViewById(R.id.et_remark);

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
//                Toast.makeText(getContext() , "Negative Clicked" , Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext() , "Positive Clicked" , Toast.LENGTH_SHORT).show();
                submitData();
            }
        };
    }

    // state code is 8811
    private View.OnClickListener selectType(final TextView tv , final int code ) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectItem2 select = new SelectItem2();
                select.selectItemCode(code);
                select.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {
                        tv.setText(name);
                    }

                    @Override
                    public void selectedItemId(String id) {

                        tv.setTag(id);

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

//        ObjectRollout obj = new ObjectRollout();
//        obj.setmEtName(mEtName.getText().toString());
//        obj.setmTvSfrom(mTvSfrom.getText().toString());
//        obj.setmTvSto(mTvSto.getText().toString());
//        obj.setmTvCfrom(mTvCfrom.getText().toString());
//        obj.setmTvCto(mTvCto.getText().toString());
//        obj.setmTvStart(mTvStart.getText().toString());
//        obj.setmTvEnd(mTvEnd.getText().toString());
//        obj.setmEtDayTravel(mEtDayTravel.getText().toString());
//        obj.setmEtDayOnsite(mEtDayOnsite.getText().toString());
//        obj.setmEtDayBase(mEtDayBase.getText().toString());
//        obj.setmEtRemark(mEtRemark.getText().toString());


//      String userId =  new SharedPreference().getValueWithKey(getContext() , "userId");
        String userId = "30";
//        String stateFrom  = mTvSfrom.getText().toString();
        String stateFrom  = mTvSfrom.getTag().toString();

        String cityFrom = mTvCfrom.getText().toString();
        String stateTo = mTvSto.getTag().toString();
        String cityTo = mTvCto.getText().toString();
        String dateFrom = mTvStart.getText().toString();
        String dateTo = mTvEnd.getText().toString();
        String remark = mEtRemark.getText().toString();
        String totalDays = mEtDayTravel.getText().toString();
        String onSiteDays = mEtDayOnsite.getText().toString();
        String yearId = "6";
//        String baseDays = mEtDayBase.getText().toString();
        String baseDays = "3";

        boolean isValidate = validateData(userId , stateFrom , cityFrom , stateTo , cityTo ,
                dateFrom ,
                dateTo ,
                remark ,
                totalDays ,
                onSiteDays ,
                yearId ,
                baseDays);

        if(isValidate){
            return;

        }


        Call<List<ObjectAddRollout>> call = new ApiRestAdapter().addRollout(userId ,
                stateFrom ,
                cityFrom ,
                stateTo ,
                cityTo ,
                dateFrom ,
                dateTo ,
                remark ,
                totalDays ,
                onSiteDays ,
                yearId ,
                baseDays);
        Helper.showLoading(RolloutCreate.this , "Creating Rollout");


        call.enqueue(new Callback<List<ObjectAddRollout>>() {
            @Override
            public void onResponse(Call<List<ObjectAddRollout>> call, Response<List<ObjectAddRollout>> response) {

                Helper.hideLoading();

                if(response.code()==200){
                    Helper.showToast(RolloutCreate.this , "Success");
                    String msg =  response.body().get(0).getMsg();
                    Helper.showToast(RolloutCreate.this , msg);


                }else{
                    Helper.showToast(RolloutCreate.this , "Try Again : "+response.code());

                }

            }

            @Override
            public void onFailure(Call<List<ObjectAddRollout>> call, Throwable t) {


                Helper.hideLoading();
                Helper.showToast(RolloutCreate.this , "Failed ");
//                Helper.showToast((RolloutCreate.this , "Failed : "+t.getMessage());

            }
        });







    }

    private boolean validateData(String userId, String stateFrom, String cityFrom, String stateTo, String cityTo, String dateFrom, String dateTo, String remark, String totalDays, String onSiteDays, String yearId, String baseDays) {



        return false;
    }



    public void exitScreen(View view) {
        finish();
    }


}

