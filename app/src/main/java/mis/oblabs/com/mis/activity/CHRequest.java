package mis.oblabs.com.mis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.models.ObjectAddRollout;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CHRequest extends AppCompatActivity {




    View footer;
    EditText mEtRemark;
    TextView tDate , tDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_request_ch);





        Log.wtf("TAG" , "Logging notwoeking");
        Log.d("TAG" , "Logging notwoeking");



    initializeView(this.findViewById(android.R.id.content));




    }

    private void initializeView(View view) {


        tDate = (TextView)view.findViewById(R.id.tv_date);
        tDate.setTag("edate");
        tDate.setOnClickListener(selectDate(tDate));

        tDay = (TextView)view.findViewById(R.id.tv_day);



        mEtRemark = (EditText) view. findViewById(R.id.et_remark);

        footer = view.findViewById(R.id.footer);
        initFooter();

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

    private void submitData() {


        String chidNo = "";
        String submitDate = Helper.today();
        String empId = "7";
        String yearId = "6";
        String status = "1";

        String chDate = tDate.getText().toString();



        String day = tDay.getText().toString();

        String remark = mEtRemark.getText().toString();



        Helper.showLoading(CHRequest.this , "Creating CH Request...");

        Call<List<ObjectAddRollout>> call = new ApiRestAdapter().chrequest(chidNo ,chDate , submitDate , empId , yearId , status , remark);

        call.enqueue(new Callback<List<ObjectAddRollout>>() {
            @Override
            public void onResponse(Call<List<ObjectAddRollout>> call, Response<List<ObjectAddRollout>> response) {

                Helper.hideLoading();

                if(response.code()==200){
                    Helper.showToast(CHRequest.this , "Success");
                    String msg =  response.body().get(0).getMsg();
                    Helper.showToast(CHRequest.this , msg);


                }else{
                    Helper.showToast(CHRequest.this , "Try Again : "+response.code());

                }
            }

            @Override
            public void onFailure(Call<List<ObjectAddRollout>> call, Throwable t) {

                Helper.hideLoading();
                Helper.showToast(CHRequest.this , "Failed ");

            }
        });
    }


    public void exitScreen(View view) {
        finish();
    }
}
